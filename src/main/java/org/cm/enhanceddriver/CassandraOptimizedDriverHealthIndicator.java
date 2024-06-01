package org.cm.enhanceddriver;

import org.cm.health.AbstractHealthIndicator;
import org.cm.health.Health;
import org.cm.pojo.CqlSession;

/**
 * SpringActuatorPOC
 * Created By Khan, C M Abdullah on 2/6/24 : Time: 01:35
 * Ref:
 */
public class CassandraOptimizedDriverHealthIndicator extends AbstractHealthIndicator {

	private final CqlSessionFactory cqlSessionFactory;

	public CassandraOptimizedDriverHealthIndicator(CqlSession session) {
		super("Cassandra health check failed");
		cqlSessionFactory = new CqlSessionFactory(session);
	}

	@Override
	protected void doHealthCheck(Health.Builder builder) throws Exception {
		cqlSessionFactory.getHealth(builder);
	}
}
