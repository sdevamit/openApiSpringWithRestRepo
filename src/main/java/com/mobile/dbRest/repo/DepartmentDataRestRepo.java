package com.mobile.dbRest.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mobile.dbRest.model.Department;

@RepositoryRestResource
public interface DepartmentDataRestRepo extends PagingAndSortingRepository<Department, Integer> {

}
