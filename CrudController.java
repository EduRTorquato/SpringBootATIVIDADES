package com.ExercicioCrud.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExercicioCrud.crud.model.crudModel;
import com.ExercicioCrud.crud.repository.RepositoryCrud;

@RestController

@RequestMapping("/crud")
public class CrudController {

	@Autowired
	private RepositoryCrud repository;
	
	@GetMapping("/tudo")
	public ResponseEntity<List<crudModel>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	@GetMapping()
	public String crud()
	{
		return "Olá, bem vindo ao exercício CRUD";
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<crudModel> GetById(@PathVariable int id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<crudModel>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findByNomeContainingIgnoringCase(nome));
	}
	
	@PostMapping("/SalvaPerfil")
	public ResponseEntity<crudModel> salvaPerfil(@RequestBody crudModel perfil) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(perfil));
	}
		
}
