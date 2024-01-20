package com.joel.productos_categorias.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joel.productos_categorias.models.Categoria;
import com.joel.productos_categorias.repositories.CategoriaRepository;

@Service
public class CategoriaServicio extends BaseServicio<Categoria>{

    @Autowired CategoriaRepository categoriaRepo;
    
}
