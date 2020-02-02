package com.steven.nagie.domain.api.repository;

import com.steven.nagie.schema.security.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
