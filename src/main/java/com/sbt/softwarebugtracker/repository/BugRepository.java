package com.sbt.softwarebugtracker.repository;

import com.sbt.softwarebugtracker.model.Bug;
import com.sbt.softwarebugtracker.model.Engineer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends MongoRepository<Bug, String> {
}
