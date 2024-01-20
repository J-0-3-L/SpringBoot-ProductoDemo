package com.joel.productos_categorias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.joel.productos_categorias.models.Categoria;
import com.joel.productos_categorias.models.Producto;
import com.joel.productos_categorias.servicies.CategoriaServicio;
import com.joel.productos_categorias.servicies.ProductoServicio;

@Controller
public class HomeController {

    @Autowired private CategoriaServicio categoriaServicio;
    @Autowired private ProductoServicio productoServicio;
    
    @GetMapping("/")
    public String in(){
        return "index";
        //return "main";
        //return "main_categoria";
        //return "main_producto";
        //return "add_producto";
         //return "add_categoria";

    }

    @GetMapping("/tienda")
    public String home(Model model){
        List<Producto> productos=productoServicio.findAll();
        List<Categoria> categorias=categoriaServicio.findAll();
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        return "main";
    }
}
