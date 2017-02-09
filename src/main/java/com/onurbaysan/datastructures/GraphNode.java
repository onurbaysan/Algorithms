package com.onurbaysan.datastructures;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by stall10n on 7.02.2017.
 */
public class GraphNode
{
    private String identifier;
    private int value;

    public GraphNode(String identifier, int value)
    {
        this.identifier = identifier;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        GraphNode node = (GraphNode) o;

        return new EqualsBuilder()
                .append(value, node.value)
                .append(identifier, node.identifier)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(identifier)
                .append(value)
                .toHashCode();
    }
}
