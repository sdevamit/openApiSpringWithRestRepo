package com.mobile.dbRest.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mobile.dbRest.model.Employee;
import com.mobile.dbRest.repo.EmployeeDataRestRepo;

@Component
public class EmployeeApiControllerImpl implements EmployeeApiDelegate {

    @Autowired
    EmployeeDataRestRepo employeeDataRestRepo;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public ResponseEntity<Void> addEmployee(Employee employee) {
        try {
            employeeDataRestRepo.save(employee);
        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.created(null).build();
    }

    @Override
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> emps = (List<Employee>) employeeDataRestRepo.findAll();
        if (!emps.isEmpty()) {
            return ResponseEntity.ok().body(emps);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeById(Integer id) {
        List<Employee> emps = new ArrayList<>();
        Optional<Employee> emp = employeeDataRestRepo.findById(id);
        if (emp.isPresent()) {
            emps.add(emp.get());
            return ResponseEntity.ok().body(emps);
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    @Override
    public ResponseEntity<Void> deleteEmployeeById(Integer id) {
        employeeDataRestRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
