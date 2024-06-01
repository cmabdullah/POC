package org.cm.health.reactive;

import org.cm.health.Health;
import org.cm.pojo.Mono;

/**
 * SpringActuatorPOC
 * Created By Khan, C M Abdullah on 2/6/24 : Time: 01:04
 * Ref:
 */
@FunctionalInterface
public interface ReactiveHealthIndicator extends ReactiveHealthContributor {

	default Mono getHealth(boolean includeDetails) {
		Mono health = health();
		return includeDetails ? health : new Mono(health.getValue());
	}
	Mono health();
}
