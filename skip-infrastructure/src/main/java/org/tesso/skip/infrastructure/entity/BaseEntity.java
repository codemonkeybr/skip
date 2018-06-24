package org.tesso.skip.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Transient;
import java.io.Serializable;

public abstract class BaseEntity<ID extends Serializable> extends AbstractPersistable<ID> {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    public void setId(ID id) {
        super.setId(id);
    }

    @Override
    @Transient
    @JsonIgnore
    public boolean isNew() {
        return null == this.getId();
    }
}
