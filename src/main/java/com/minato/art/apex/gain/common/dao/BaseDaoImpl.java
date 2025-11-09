package com.minato.art.apex.gain.common.dao;

import com.minato.art.apex.gain.common.mapper.DomainMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.minato.art.apex.gain.common.constant.ErrorMessage.MAPPER_NULL;
import static com.minato.art.apex.gain.common.constant.ErrorMessage.REPOSITORY_NULL;
import static com.minato.art.apex.gain.common.utility.CommonUtility.getSimplifiedClassName;

/**
 * Generic Base DAO Implementation using Spring Data JPA
 * @param <T> Domain/DTO type
 * @param <K> Primary key type
 * @param <E> Entity type
 */
@Slf4j
public abstract class BaseDaoImpl<T, E, K> implements BaseDao<T, K> {

    protected final JpaRepository<E, K> repository;
    protected final DomainMapper<T, E> mapper;

    /**
     * @param repository Spring Data JPA repository for the entity
     * @param mapper     Mapper to convert between Entity and Domain
     */
    protected BaseDaoImpl(JpaRepository<E, K> repository, DomainMapper<T, E> mapper) {
        this.repository = Objects.requireNonNull(repository, REPOSITORY_NULL.getMessage());
        this.mapper = Objects.requireNonNull(mapper, MAPPER_NULL.getMessage());
    }

    @Override
    public T save(T domain) {
        E entity = mapper.toEntity(domain);
        E saved = repository.save(entity);
        log.info("saving domain: {}",getSimplifiedClassName(domain.getClass()));
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<T> findById(K id) {
        var domain = repository.findById(id);
        log.info("fetching domain: {}",getSimplifiedClassName(domain.getClass()));
        return domain.map(mapper::toDomain);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Page<T> findAllWithPagination(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDomain);
    }

    @Override
    public T update(T domain) {
        E entity = mapper.toEntity(domain);
        E updated = repository.save(entity);
        return mapper.toDomain(updated);
    }

    @Override
    public void deleteById(K id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(T domain) {
        E entity = mapper.toEntity(domain);
        repository.delete(entity);
    }

    @Override
    public long count() {
        return repository.count();
    }
}
