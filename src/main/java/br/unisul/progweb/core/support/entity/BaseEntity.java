package br.unisul.progweb.core.support.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;

public interface BaseEntity extends Serializable {

    Object getId();

    @JsonIgnore
    default String getBase64() {
        return null;
    }

    @JsonIgnore
    default boolean isNew() {
        return Objects.isNull(getId());
    }

}
