package org.cm.pojo;

/**
 * SpringActuatorPOC
 * Created By Khan, C M Abdullah on 2/6/24 : Time: 01:15
 * Ref:
 */
public interface Node {
	NodeState getState();
	Version getCassandraVersion();
}
