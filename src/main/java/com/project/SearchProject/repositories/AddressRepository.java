package com.project.SearchProject.repositories;

import com.project.SearchProject.model.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ctola
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
}
