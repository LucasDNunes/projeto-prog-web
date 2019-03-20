package br.unisul.progweb.core.support.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public interface BaseEntity {

    Object getId();

    default String getBase64() {
        return null;
    }

    @JsonIgnore
    default boolean isNew() {
        return Objects.isNull(getId());
    }

}
