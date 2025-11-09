package com.minato.art.apex.gain.common.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;



public interface BaseDao<T, K> {

    /**
     * Save a new domain or update an existing domain.
     *
     * @param domain the domain to save
     * @return the saved domain
     */
    T save(T domain);

    /**
     * Find a domain by its ID.
     *
     * @param id the ID of the domain
     * @return an Optional containing the domain if found, or empty if not
     */
    Optional<T> findById(K id);

    /**
     * Find all domain.
     *
     * @return a list of all domain
     */
    List<T> findAll();

    /**
     * Find all domain with pagination.
     *
     * @param pageable the pagination information
     * @return a page of domain
     */
    Page<T> findAllWithPagination(Pageable pageable);

    /**
     * Update an existing domain.
     *
     * @param domain the domain to update
     * @return the updated domain
     */
    T update(T domain);

    /**
     * Delete a domain by its ID.
     *
     * @param id the ID of the domain to delete
     */
    void deleteById(K id);

    /**
     * Delete a given domain.
     *
     * @param domain the domain to delete
     */
    void delete(T domain);

    /**
     * Count all entities.
     *
     * @return total number of entities
     */
    long count();
}
