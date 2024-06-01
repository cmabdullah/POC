package org.cm.pojo;

import org.cm.health.Health;

/**
 * SpringActuatorPOC
 * Created By Khan, C M Abdullah on 2/6/24 : Time: 01:05
 * Ref:
 */
public class Mono {

	private Health value;

	public Health getValue() {
		return value;
	}

	public void setValue(Health value) {
		this.value = value;
	}

	public Mono(Health value) {
		this.value = value;
	}
}
