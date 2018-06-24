package org.tesso.skip.infrastructure.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.tesso.skip.infrastructure.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class JpaGenericData<T extends BaseEntity<ID>, ID extends Serializable> implements GenericData<T, ID> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericData.class);

    @Autowired
    protected JpaRepository<T, ID> genericRepository;

    @Override
    public List<T> findAll() {
        return this.genericRepository.findAll();
    }

    @Override
    public List<T> findAll(Integer page, Integer size, Direction direction, String... fields) {
        Sort sort = this.mountSort(direction, fields);

        if ((page != null) || (size != null)) {
            if (page == null) {
                page = DefaultValues.DEFAULT_PAGE;
            } else if (size == null) {
                size = DefaultValues.DEFAULT_SIZE;
            }

            return this.genericRepository.findAll(this.mountPage(page, size, sort)).getContent();
        } else if (sort != null) {
            return this.genericRepository.findAll(sort);
        } else {
            return this.genericRepository.findAll();
        }
    }

    @Override
    public T add(T entityObject) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Adding a new record [%s].", entityObject));
        }

        return this.genericRepository.save(entityObject);
    }

    @Override
    public void update(T entityObject) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Updating the entity [%s].", entityObject));
        }

        this.genericRepository.save(entityObject);
    }

    @Override
    public void delete(T entityObject) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Deleting the entity [%s].", entityObject));
        }

        this.genericRepository.delete(entityObject);
    }

    @Override
    public Optional<T> findById(ID id) {
        return this.genericRepository.findById(id);
    }

    protected PageRequest mountPage(Integer page, Integer size, Sort sort) {
        if (sort == null) {
            return PageRequest.of(page, size);
        } else {
            return PageRequest.of(page, size, sort);
        }
    }

    protected Sort mountSort(Direction direction, String[] fields) {
        if ((fields == null) || (fields.length <= 0)) {
            return null;
        }

        return new Sort(direction, fields);
    }

}
