package com.project.SearchProject.repositories;

import com.project.SearchProject.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ctola
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
