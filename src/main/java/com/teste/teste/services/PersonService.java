package com.teste.teste.services;

import com.teste.teste.dto.PersonDepartmentDTO;
import com.teste.teste.entities.Department;
import com.teste.teste.entities.Person;
import com.teste.teste.repositories.DepartmentRepository;
import com.teste.teste.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public PersonDepartmentDTO insert(PersonDepartmentDTO dto){
        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        Department dept = departmentRepository.getReferenceById(dto.getDepartment().getId());

        entity.setDepartment(dept);

        entity = repository.save(entity);
        return new PersonDepartmentDTO(entity);
    }
}
