package com.personal.organizationalnews.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {

    public final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getDepartment(){
        return departmentRepository.findAll();
    }

    public void addNewDepartment(Department department) {
         Optional<Department> departmentByName= departmentRepository
                 .getDepartmentByName(department.getName());
         if (departmentByName.isPresent()){
             throw new IllegalStateException("The name is already taken");
         }
        departmentRepository.save(department);
    }

    public void deleteDepartment(Long departmentId) {

        boolean exists =departmentRepository.existsById(departmentId);
        if(!exists){
            throw new IllegalStateException("Department does not exist");
        }
        departmentRepository.deleteById(departmentId);
    }

    @Transactional
    public void updateDepartment(Long departmentId, String name, String chairperson) {
        Department department=departmentRepository.findById(departmentId)
                .orElseThrow(()-> new
                        IllegalStateException("Department with " + departmentId+"does not exist"));
        if(name !=null && name.length()>0 &&
        !Objects.equals(department.getName(),name)){
            department.setName(name);
        }
        if(chairperson !=null && chairperson.length() >0 &&
        !Objects.equals(department.getChairperson(), chairperson)){
            department.setChairperson(chairperson);
        }
    }
}
