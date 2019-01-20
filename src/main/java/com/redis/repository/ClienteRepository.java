package com.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.redis.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String> {

}
