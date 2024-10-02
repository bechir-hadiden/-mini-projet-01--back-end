package com.bechir.departement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bechir.departement.College;
@Repository
public interface CollegeRepositroy extends  JpaRepository<College, Long>   {

}
