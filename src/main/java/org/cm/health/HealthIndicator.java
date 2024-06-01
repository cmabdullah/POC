package org.cm.health;

/**
 * SpringActuatorPOC
 * Created By Khan, C M Abdullah on 2/6/24 : Time: 01:00
 * Ref:
 */
@FunctionalInterface
public interface HealthIndicator extends HealthContributor {
	default String getHealth(boolean includeDetails) {
		String health = health();
		return includeDetails ? health : health.toLowerCase();
	}

	String health();
}
