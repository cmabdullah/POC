package org.cm.pojo;

/**
 * SpringActuatorPOC
 * Created By Khan, C M Abdullah on 2/6/24 : Time: 01:20
 * Ref:
 */
public class Status {

	public static final Status UNKNOWN = new Status("UNKNOWN");

	public static final Status UP = new Status("UP");

	public static final Status DOWN = new Status("DOWN");

	private final String code;

	private final String description;

	public Status(String code) {
		this(code, "");
	}

	public Status(String code, String description) {
		this.code = code;
		this.description = description;
	}
}
