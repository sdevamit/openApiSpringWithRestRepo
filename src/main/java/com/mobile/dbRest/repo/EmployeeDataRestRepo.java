package com.mobile.dbRest.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mobile.dbRest.model.Employee;

@RepositoryRestResource
public interface EmployeeDataRestRepo extends PagingAndSortingRepository<Employee, Integer> {

}
