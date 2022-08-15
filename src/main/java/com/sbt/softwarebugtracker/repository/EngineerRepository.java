package com.sbt.softwarebugtracker.repository;

import com.sbt.softwarebugtracker.model.Engineer;
import com.sbt.softwarebugtracker.model.EngineerRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EngineerRepository extends MongoRepository<Engineer, String> {
    Optional<Engineer> findEngineerByEmail(String email);
    Optional<Engineer> findEngineerByRole(EngineerRole engineerRole);
}