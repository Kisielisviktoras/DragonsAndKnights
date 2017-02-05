package com.dak.domain;

import com.dak.domain.constants.AttributeTypeEnum;

/**
 * @author Saji
 */
public class Attribute {

    private AttributeTypeEnum type;
    private int value;

    public Attribute() {
    }

    public Attribute(AttributeTypeEnum type, int value) {
        this.type = type;
        this.value = value;
    }

    public AttributeTypeEnum getType() {
        return type;
    }

    public void setType(AttributeTypeEnum type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "type=" + type.getName() +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Attribute)) {
            return false;
        }

        Attribute anotherObj = (Attribute) o;

        return type == anotherObj.type;
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }
}
