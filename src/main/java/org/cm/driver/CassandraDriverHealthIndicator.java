package org.cm.driver;

import org.cm.health.AbstractHealthIndicator;
import org.cm.pojo.CqlSession;

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
	protected void doHealthCheck(String builder) throws Exception {
	}
}
