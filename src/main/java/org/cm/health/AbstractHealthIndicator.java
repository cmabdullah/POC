package org.cm.health;

import java.util.function.Function;

/**
 * SpringActuatorPOC
 * Created By Khan, C M Abdullah on 2/6/24 : Time: 01:01
 * Ref:
 */
public abstract class AbstractHealthIndicator implements HealthIndicator {

	private static final String NO_MESSAGE = null;

	private final Function<Exception, String> healthCheckFailedMessage;

	protected AbstractHealthIndicator() {
		this(NO_MESSAGE);
	}

	protected AbstractHealthIndicator(String healthCheckFailedMessage) {
		this.healthCheckFailedMessage = (ex) -> healthCheckFailedMessage;
	}

	protected AbstractHealthIndicator(Function<Exception, String> healthCheckFailedMessage) {
		this.healthCheckFailedMessage = healthCheckFailedMessage;
	}

	@Override
	public final String health() {
		String str = "Health status";
		Health.Builder builder = new Health.Builder();
		try {
			doHealthCheck(builder);
		} catch (Exception ex) {
			str = "";
		}
		return str.toLowerCase();
	}

	protected abstract void doHealthCheck(Health.Builder builder) throws Exception;
}
