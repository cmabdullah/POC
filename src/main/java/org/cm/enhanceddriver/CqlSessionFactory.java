package org.cm.enhanceddriver;

import org.cm.health.Health;
import org.cm.pojo.CqlSession;
import org.cm.pojo.Node;
import org.cm.pojo.NodeState;
import org.cm.pojo.Status;

import java.util.Collection;
import java.util.Optional;

/**
 * SpringActuatorPOC
 * Created By Khan, C M Abdullah on 2/6/24 : Time: 01:36
 * Ref:
 */
public class CqlSessionFactory {

	private final CqlSession session;

	public CqlSessionFactory(CqlSession session) {
		this.session = session;
	}

	public Health getHealth(Health.Builder builder) {
		Collection<Node> nodes = this.session.getMetadata().getNodes().values();
		Optional<Node> nodeUp = nodes.stream().filter((node) -> node.getState() == NodeState.UP).findAny();
		builder.status(nodeUp.isPresent() ? Status.UP : Status.DOWN);
		nodeUp.map(Node::getCassandraVersion).ifPresent((version) -> builder.withDetail("version", version));
		return builder.build();
	}
}
