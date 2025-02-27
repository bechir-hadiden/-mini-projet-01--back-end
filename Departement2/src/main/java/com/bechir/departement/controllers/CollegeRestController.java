package com.bechir.departement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bechir.departement.College;
import com.bechir.departement.repos.CollegeRepositroy;

@RestController

public class CollegeRestController {
	
	
	@Autowired
	CollegeRepositroy collegeRepositroy;

	@RequestMapping(method = RequestMethod.GET)
	public List<College> getAllColleges() {
		return collegeRepositroy.findAll();
	}

	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public College getCollegeById(@PathVariable("id") Long id) {
		return collegeRepositroy.findById(id).get();

}
}
