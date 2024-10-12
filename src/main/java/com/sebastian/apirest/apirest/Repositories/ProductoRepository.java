package com.sebastian.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sebastian.apirest.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

    

}
