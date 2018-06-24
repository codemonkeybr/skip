package org.tesso.skip.infrastructure.data;

import org.springframework.data.domain.Sort;
import org.tesso.skip.infrastructure.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericData<T extends BaseEntity<ID>, ID extends Serializable> {

    public List<T> findAll();

    public List<T> findAll(Integer page, Integer size, Sort.Direction direction, String... fields);

    public T add(T entityObject);

    public void update(T entityObject);

    public void delete(T entityObject);

    public Optional<T> findById(ID id);

}
