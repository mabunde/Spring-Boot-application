package com.personal.organizationalnews.department;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService=departmentService;
    }

    @GetMapping
    public List<Department> getDepartment(){
    return departmentService.getDepartment();
    }

    @PostMapping
    public void addNewDepartment(@RequestBody Department department){
        departmentService.addNewDepartment(department);
    }
    @DeleteMapping(path = "{departmentId}")
    public void deleteDepartmentById(@PathVariable("departmentId") Long departmentId){
        departmentService.deleteDepartment(departmentId);
    }
    @PutMapping(path="{departmentId}")
    public void updateDepartment(@PathVariable("departmentId") Long departmentId,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false)String chairperson){
        departmentService.updateDepartment(departmentId,name,chairperson);


    }
}
