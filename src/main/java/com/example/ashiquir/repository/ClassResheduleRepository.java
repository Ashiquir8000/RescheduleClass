package com.example.ashiquir.repository;

import com.example.ashiquir.Entity.ClassReshedulingRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClassResheduleRepository extends MongoRepository<ClassReshedulingRequest, String> {
}
