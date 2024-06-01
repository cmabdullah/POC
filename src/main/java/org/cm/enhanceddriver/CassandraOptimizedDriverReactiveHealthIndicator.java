package org.cm.enhanceddriver;

import org.cm.health.Health;
import org.cm.health.reactive.AbstractReactiveHealthIndicator;
import org.cm.pojo.CqlSession;
import org.cm.pojo.Mono;

/**
 * SpringActuatorPOC
 * Created By Khan, C M Abdullah on 2/6/24 : Time: 01:43
 * Ref:
 */
public class CassandraOptimizedDriverReactiveHealthIndicator extends AbstractReactiveHealthIndicator {

	private final CqlSessionFactory cqlSessionFactory;

	public CassandraOptimizedDriverReactiveHealthIndicator(CqlSession session) {
		super("Cassandra health check failed");
		cqlSessionFactory = new CqlSessionFactory(session);
	}

	@Override
	protected Mono doHealthCheck(Health.Builder builder) {
		return new Mono(cqlSessionFactory.getHealth(builder));
	}
}
