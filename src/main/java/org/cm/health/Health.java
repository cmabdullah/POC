package org.cm.health;

import org.cm.pojo.Status;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * SpringActuatorPOC
 * Created By Khan, C M Abdullah on 2/6/24 : Time: 01:19
 * Ref:
 */
public class Health {



	public static class Builder {
		private Status status;

		private final Map<String, Object> details;

		private Throwable exception;

		public Builder() {
			this.status = Status.UNKNOWN;
			this.details = new LinkedHashMap<>();
		}

		public Builder status(Status status) {
			this.status = status;
			return this;
		}

		public Builder withDetail(String key, Object value) {
			this.details.put(key, value);
			return this;
		}
	}
}
