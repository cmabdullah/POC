package org.cm.pojo;

import java.util.Map;
import java.util.UUID;

/**
 * SpringActuatorPOC
 * Created By Khan, C M Abdullah on 2/6/24 : Time: 01:13
 * Ref:
 */
public interface Metadata {
	Map<UUID, Node> getNodes();
}
