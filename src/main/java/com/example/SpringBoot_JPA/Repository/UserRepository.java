package com.example.SpringBoot_JPA.Repository;

import com.example.SpringBoot_JPA.Model.UserRecord;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserRecord, Integer> {
}
