package com.poc.bem.demo.repositories;

import com.poc.bem.demo.domain.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Bootstraps the CRUD operations on the AppUser table.
 */
@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
}
