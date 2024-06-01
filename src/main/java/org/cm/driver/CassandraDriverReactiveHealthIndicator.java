package org.cm.driver;

import org.cm.health.reactive.AbstractReactiveHealthIndicator;
import org.cm.pojo.CqlSession;
import org.cm.pojo.Mono;


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
	protected Mono doHealthCheck(String builder) {
		return null;
	}
}
