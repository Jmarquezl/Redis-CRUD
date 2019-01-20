package com.redis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redis.entity.Cliente;
import com.redis.repository.ClienteRepository;

@RestController
public class RedisController {
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Cliente> home() {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		repository.findAll().forEach(listaClientes::add);
		return listaClientes;
	}
	
	@GetMapping(value = "/obtenerCliente")
	public Cliente getCliente(@RequestParam String id) {
		return repository.findById(id).get();
	}
	
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public boolean save(@RequestBody Cliente cliente) {
		repository.save(cliente);
		return true;
	}
	
	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public boolean update(@RequestBody Cliente cliente) {
		repository.save(cliente);
		return true;
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public boolean delete(@PathVariable String id) {
		repository.deleteById(id);return true;
	}
}
