package org.tesso.skip.infrastructure.resource;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.*;
import org.tesso.skip.infrastructure.data.DefaultValues;
import org.tesso.skip.infrastructure.entity.BaseEntity;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

public interface GenericResource<T extends BaseEntity<ID>, ID extends Serializable> {

    @GetMapping
    public List<T> findAll(@RequestParam(name = "page", required = false, defaultValue = DefaultValues.DEFAULT_PAGE + "") Integer page,
                           @RequestParam(name = "size", required = false, defaultValue = DefaultValues.DEFAULT_SIZE + "") Integer size,
                           @RequestParam(name = "sort", required = false, defaultValue = "ASC") Direction sort,
                           @RequestParam(name = "fields", required = false, defaultValue = "") String fields);

    @PostMapping
    public T insert(@RequestBody @Valid T entity);

    @PutMapping
    public void update(@RequestBody @Valid T entity);

    @DeleteMapping
    public void delete(@RequestBody @Valid T entity);

    @GetMapping("/{id:[0-9.,]*$}")
    public T findById(@PathVariable("id") ID id);

}
