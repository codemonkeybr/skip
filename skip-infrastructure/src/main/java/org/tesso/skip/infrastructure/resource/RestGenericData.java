package org.tesso.skip.infrastructure.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.*;
import org.tesso.skip.infrastructure.data.DefaultValues;
import org.tesso.skip.infrastructure.data.GenericData;
import org.tesso.skip.infrastructure.entity.BaseEntity;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

public class RestGenericData<T extends BaseEntity<ID>, ID extends Serializable> implements GenericResource<T, ID> {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected GenericData<T, ID> genericData;

    @GetMapping
    @Override
    public List<T> findAll(@RequestParam(name = "page", required = false, defaultValue = DefaultValues.DEFAULT_PAGE + "") Integer page,
                           @RequestParam(name = "size", required = false, defaultValue = DefaultValues.DEFAULT_SIZE + "") Integer size,
                           @RequestParam(name = "sort", required = false, defaultValue = "ASC") Direction sort,
                           @RequestParam(name = "fields", required = false, defaultValue = "") String fields) {
        if (this.LOGGER.isDebugEnabled()) {
            this.LOGGER.debug(String.format("Request all records [%s] to page [%s] with size of [%s] and fields [%s].",
                    this.getClass(), page, size, fields));
        }

        return this.genericData.findAll(page, size, sort, this.splitFields(fields));
    }

    @Override
    @PostMapping
    public T insert(@RequestBody @Valid T entity) {
        if (this.LOGGER.isDebugEnabled()) {
            this.LOGGER.debug(String.format("Request to add the record [%s].", entity));
        }

        return this.genericData.add(entity);
    }

    @PutMapping
    public void update(@RequestBody @Valid T entity) {
        if (this.LOGGER.isDebugEnabled()) {
            this.LOGGER.debug(String.format("Request to update the record [%s].", entity));
        }

        this.genericData.update(entity);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody @Valid T entity) {
        if (this.LOGGER.isDebugEnabled()) {
            this.LOGGER.debug(String.format("Request to delete the record [%s].", entity));
        }

        this.genericData.delete(entity);
    }

    @Override
    @GetMapping("/{id:[0-9.,]*$}")
    public T findById(@PathVariable("id") ID id) {
        if (this.LOGGER.isDebugEnabled()) {
            this.LOGGER.debug(String.format("Request to find a record of [] by id [%s].", this.getClass(), id));
        }

        return this.genericData.findById(id).get();
    }

    protected String[] splitFields(String fields) {
        if ((fields == null) || (fields.trim().isEmpty())) {
            return null;
        }

        return fields.split("\\.|,");
    }

}
