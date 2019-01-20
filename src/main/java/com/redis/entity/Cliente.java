package com.redis.entity;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("CatalogoClientes")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombre;
	private String paterno;
	private String materno;
	
	public Cliente() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
}
