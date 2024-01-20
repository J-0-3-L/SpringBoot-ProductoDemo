package com.joel.productos_categorias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joel.productos_categorias.models.Categoria;
import com.joel.productos_categorias.models.Producto;
import com.joel.productos_categorias.servicies.CategoriaServicio;
import com.joel.productos_categorias.servicies.ProductoServicio;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired private CategoriaServicio categoriaServicio;
    @Autowired private ProductoServicio productoServicio;

    @GetMapping("/new")
    public String viewAddCategoria(Model model){
        model.addAttribute("categoria", new Categoria());
        return "add_categoria";
    }
    @PostMapping("/new")
    public String addCategoria(@ModelAttribute("categoria") Categoria categoria){
        categoriaServicio.save(categoria);
        return "redirect:/tienda";
    }

    @GetMapping("/{id}")
    public String viewIdCategoria(@PathVariable("id") Long CategoriaId, Model model){
        List<Producto> productos= productoServicio.findAll();
        Categoria categoria=categoriaServicio.findById(CategoriaId);
        model.addAttribute("categoria", categoria);
        model.addAttribute("productos", productos);
        return "main_categoria";
    }
    @PostMapping("/{id}")
    public String addProducto(
        @RequestParam("producto_id") Long productoId,
        @PathVariable("id") Long categoriaId){
        Categoria categoria=categoriaServicio.findById(categoriaId);
        Producto producto=productoServicio.findById(productoId);
        List<Producto> productos=categoria.getProductos();
        productos.add(producto);
        categoria.setProductos(productos);
        categoriaServicio.save(categoria);
        String url="redirect:/categorias/"+ categoriaId;
        return url;
    }
}
