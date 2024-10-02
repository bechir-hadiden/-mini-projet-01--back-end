package com.bechir.departement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bechir.departement.Departement;
import com.bechir.departement.DepartementDTO;
import com.bechir.departement.services.DepartementServices;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DepartementRestController {
	
	@Autowired
	DepartementServices departementService;

	@RequestMapping(method = RequestMethod.GET)
	public List<DepartementDTO> getAllDepartements() {
		return departementService.getAllDepartements();
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public DepartementDTO getDepartementById(@PathVariable("id") Long id) {
//		return departementService.getDepartement(id);
//	}
//	
	@RequestMapping(method = RequestMethod.POST)
	public DepartementDTO createDepartement(@RequestBody DepartementDTO DepartementDTo) {
	return departementService.saveDepartement(DepartementDTo);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public DepartementDTO updateDepartement(@RequestBody DepartementDTO DepartementDTo) {
	return departementService.updateDepartement(DepartementDTo);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteDepartement(@PathVariable("id") Long id)
	{
		departementService.deleteDepartementById(id);
	}
		
	@RequestMapping(value = "/prodscat/{idCol}", method = RequestMethod.GET)
	public List<Departement> getDepartementByColId(@PathVariable("idCol") Long idCol) {
		return departementService.findByCollegeIdCol(idCol);
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public List<DepartementDTO> getAllDepartement() {
//		return departementService.getAllDepartements();
//	}
//	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DepartementDTO getDepartementByIds(@PathVariable("id") Long id) {
		return departementService.getDepartement(id);
	}



}
