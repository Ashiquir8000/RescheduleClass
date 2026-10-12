package com.example.ashiquir.service;

import com.example.ashiquir.Entity.ClassReshedulingRequest;
import com.example.ashiquir.repository.ClassResheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassResheduleService {

    private final ClassResheduleRepository classResheduleRepository;

    @Cacheable(value = "classes")
    public List<ClassReshedulingRequest> getAllFromReshedule()
    {
        return classResheduleRepository.findAll();
    }

    @CacheEvict(value = "classes", allEntries = true)
    public ClassReshedulingRequest createClassess(ClassReshedulingRequest classReshedulingRequest)
    {
        return classResheduleRepository.save(classReshedulingRequest);
    }

    @CacheEvict(value = {"class, classes"}, key = "#idd", allEntries = true)
    public void deleteClassesById(String idd)
    {
        classResheduleRepository.deleteById(idd);
    }
}
