package com.ExercicioCrud.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.ExercicioCrud.crud.model.crudModel;

@Repository
public interface RepositoryCrud extends JpaRepositoryImplementation<crudModel, Integer>{
	
		public List<crudModel> findByNomeContainingIgnoringCase(String nome);
		public List<crudModel> findByIdade(int idade);
		
}

