package org.cm.driver;

import org.cm.health.AbstractHealthIndicator;
import org.cm.health.Health;
import org.cm.pojo.CqlSession;
import org.cm.pojo.Node;
import org.cm.pojo.NodeState;
import org.cm.pojo.Status;

import java.util.Collection;
import java.util.Optional;

/**
 * SpringActuatorPOC
 * Created By Khan, C M Abdullah on 2/6/24 : Time: 01:09
 * Ref:
 */
public class CassandraDriverHealthIndicator extends AbstractHealthIndicator {

	private final CqlSession session;

	public CassandraDriverHealthIndicator(CqlSession session) {
		super("Cassandra health check failed");
		this.session = session;
	}

	@Override
	protected void doHealthCheck(Health.Builder builder) throws Exception {
		Collection<Node> nodes = this.session.getMetadata().getNodes().values();
		Optional<Node> nodeUp = nodes.stream().filter((node) -> node.getState() == NodeState.UP).findAny();
		builder.status(nodeUp.isPresent() ? Status.UP : Status.DOWN);
		nodeUp.map(Node::getCassandraVersion).ifPresent((version) -> builder.withDetail("version", version));
	}
}
