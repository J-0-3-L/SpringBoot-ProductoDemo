package com.joel.productos_categorias.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joel.productos_categorias.models.Producto;
import com.joel.productos_categorias.repositories.ProductoRepository;

@Service
public class ProductoServicio extends BaseServicio<Producto> {

    @Autowired ProductoRepository productoRepo;
    
}
