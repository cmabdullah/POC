package org.cm.health.reactive;

import org.cm.health.Health;
import org.cm.pojo.Mono;

import java.util.function.Function;

/**
 * SpringActuatorPOC
 * Created By Khan, C M Abdullah on 2/6/24 : Time: 01:06
 * Ref:
 */
public abstract class AbstractReactiveHealthIndicator implements ReactiveHealthIndicator {

	private static final String NO_MESSAGE = null;
	private final Function<Throwable, String> healthCheckFailedMessage;

	protected AbstractReactiveHealthIndicator() {
		this(NO_MESSAGE);
	}

	protected AbstractReactiveHealthIndicator(String healthCheckFailedMessage) {
		this.healthCheckFailedMessage = (ex) -> healthCheckFailedMessage;
	}

	protected AbstractReactiveHealthIndicator(Function<Throwable, String> healthCheckFailedMessage) {
		this.healthCheckFailedMessage = healthCheckFailedMessage;
	}

	@Override
	public final Mono health() {
		String str = "Health status";
		Mono builder;
		Health.Builder customBuilder = new Health.Builder();
		try {
			builder = doHealthCheck(customBuilder);
		} catch (Exception ex) {
			builder = new Mono(customBuilder.build());
		}
		return builder;
	}

	protected abstract Mono doHealthCheck(Health.Builder builder);
}
