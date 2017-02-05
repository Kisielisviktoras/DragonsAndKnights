package com.dak.domain;

import java.util.List;

/**
 * Interface marking object as trainable units
 * @author Saji
 */
public interface Trainable {

    /**
     * Total attribute value on trainable unit
     * @return
     */
    int getUsedAttributePoints();

    /**
     * List of units attributes
     * @return
     */
    List<Attribute> getAttributes();
}
