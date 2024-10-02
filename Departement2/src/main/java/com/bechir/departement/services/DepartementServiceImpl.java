package com.bechir.departement.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bechir.departement.College;
import com.bechir.departement.Departement;
import com.bechir.departement.DepartementDTO;
import com.bechir.departement.repos.DepartementRepository;
@Service
public class DepartementServiceImpl implements DepartementServices {
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	DepartementRepository  departementRepository ; 
	

	 
	    @Override
	    public void deleteDepartementById(Long id) {

	    	departementRepository.deleteById(id);
}

	    @Override
	    public void deleteDepartement(Departement p) {
	    	departementRepository.delete(p);
	    }

	    @Override
	    public DepartementDTO updateDepartement(DepartementDTO departement) {
			return convertEntityToDto(departementRepository.save(convertDtoToEntity(departement)));

	    }

	  
		@Override
		public List<Departement> findByNomDepartement(String nom) {
			
			return findByNomDepartement(nom);
		}

		@Override
		public List<Departement> findByNomDepartementContains(String nom) {
			return findByNomDepartementContains(nom);
		}

		@Override
		public List<Departement> findByNomNombre(String nom, int nombre) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Departement> findByCollege(College college) {
			// TODO Auto-generated method stub
			return findByCollege(college);
		}

		@Override
		public List<Departement> findByCollegeIdCol(Long id) {
			// TODO Auto-generated method stub
			return findByCollegeIdCol(id);
		}

		@Override
		public List<Departement> findByOrderByNomDepartementAsc() {
			return findByOrderByNomDepartementAsc();
		}

		@Override
		public List<Departement> trierDepartementsNomsNombre() {
			return trierDepartementsNomsNombre();
		}

		@Override
		public DepartementDTO convertEntityToDto(Departement departement) {
			
			
			
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
			DepartementDTO DepartementDTo = modelMapper.map(departement, DepartementDTO.class);
			 return DepartementDTo;
			 }

		@Override
		public DepartementDTO saveDepartement(DepartementDTO departement) {
			
			return convertEntityToDto(departementRepository.save(convertDtoToEntity(departement)));

		}

		@Override
		public DepartementDTO getDepartement(Long id) {
			return convertEntityToDto(departementRepository.findById(id).get());
		}

		@Override
		public List<DepartementDTO> getAllDepartements() {
			return  departementRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList()); 
		}

		@Override
		public Departement convertDtoToEntity(DepartementDTO DepartementDto) {
			Departement departement = new Departement();
			departement = modelMapper.map(DepartementDto, Departement.class);
			 return departement;
		}
	    
	    
}
