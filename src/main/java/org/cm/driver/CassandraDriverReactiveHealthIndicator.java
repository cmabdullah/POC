package org.cm.driver;

import org.cm.health.Health;
import org.cm.health.reactive.AbstractReactiveHealthIndicator;
import org.cm.pojo.*;

import java.util.Collection;
import java.util.Optional;


/**
 * SpringActuatorPOC
 * Created By Khan, C M Abdullah on 2/6/24 : Time: 01:10
 * Ref:
 */
public class CassandraDriverReactiveHealthIndicator extends AbstractReactiveHealthIndicator {

	private final CqlSession session;

	public CassandraDriverReactiveHealthIndicator(CqlSession session) {
		super("Cassandra health check failed");
		this.session = session;
	}

	@Override
	protected Mono doHealthCheck(Health.Builder builder) {
		Collection<Node> nodes = this.session.getMetadata().getNodes().values();
		Optional<Node> nodeUp = nodes.stream().filter((node) -> node.getState() == NodeState.UP).findAny();
		builder.status(nodeUp.isPresent() ? Status.UP : Status.DOWN);
		nodeUp.map(Node::getCassandraVersion).ifPresent((version) -> builder.withDetail("version", version));
		return new Mono(builder.build());
	}
}
