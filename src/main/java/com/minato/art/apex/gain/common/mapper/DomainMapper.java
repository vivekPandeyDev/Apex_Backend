package com.minato.art.apex.gain.common.mapper;

/**
 * The interface Domain mapper.
 *
 * @param <D> the type parameter
 * @param <E> the type parameter
 */
public interface DomainMapper<D, E> {

    /**
     * To entity e.
     *
     * @param domain the domain
     * @return the e
     */
    E toEntity(D domain);

    /**
     * To domain d.
     *
     * @param entity the entity
     * @return the d
     */
    D toDomain(E entity);
}