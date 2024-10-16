package com.sebastian.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebastian.apirest.apirest.Repositories.ProductoRepository;
import com.sebastian.apirest.apirest.Entities.Producto;

@RestController
@RequestMapping("/productos")

public class ProductoController {

    @Autowired
    private ProductoRepository ProductoRepository;
    
    @GetMapping
    public List<Producto> getAllProductos(){
        return ProductoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProuctoPorId(@PathVariable Long id){
        return ProductoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID" + id));
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return ProductoRepository.save(producto);
    }

    @PutMapping({"/{id}"})
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto productDetails){
        Producto producto = ProductoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID" + id));

        producto.setNombre(productDetails.getNombre());
        producto.setPrecio(productDetails.getPrecio());
                return ProductoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String deletedProduct(@PathVariable Long id){
        Producto producto = ProductoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID" + id));

        ProductoRepository.delete(producto);
        return "El producto con el ID: " + id + " fue eliminado correctamente";
    }

}
