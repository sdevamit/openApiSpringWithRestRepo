package com.mobile.dbRest.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mobile.dbRest.model.Department;
import com.mobile.dbRest.repo.DepartmentDataRestRepo;

@Component
public class DepartmentApiControllerImpl implements DepartmentApiDelegate {

    @Autowired
    DepartmentDataRestRepo departmentDataRestRepo;

    @Override
    public ResponseEntity<Void> addDepartment(Department department) {
        departmentDataRestRepo.save(department);
        return ResponseEntity.created(null).build();
    }

    @Override
    public ResponseEntity<Void> deleteDepartmentById(Integer id) {
        departmentDataRestRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<Department>> getAllDepartment() {
        List<Department> departments = (List<Department>) departmentDataRestRepo.findAll();
        if (departments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(departments);
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentById(Integer id) {
        List<Department> departments = new ArrayList<>();
        Optional<Department> department = departmentDataRestRepo.findById(id);
        if (!department.isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(departments);
        }
    }

}
