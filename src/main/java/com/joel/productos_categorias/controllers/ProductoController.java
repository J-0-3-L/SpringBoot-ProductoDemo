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
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private CategoriaServicio categoriaServicio;

    @GetMapping("/new")
    public String viewAddProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "add_producto";
    }

    @PostMapping("/new")
    public String addProducto(@ModelAttribute("producto") Producto producto) {
        productoServicio.save(producto);
        return "redirect:/tienda";
    }

    // Muestra las categorias para añadir al producto seleccionado
    @GetMapping("/{id}")
    public String viewIdProducto(@PathVariable("id") Long productoId, Model model) {
        List<Categoria> categorias = categoriaServicio.findAll();
        Producto producto = productoServicio.findById(productoId);
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categorias);
        return "main_producto";
    }

    //Realiza la accion de agregar la categoria al producto seleccionado
    @PostMapping("/{id}")
    public String addCategoria(
        @RequestParam("categoria_id") Long categoriaId,
        @PathVariable("id") Long productoId) {

        Producto producto = productoServicio.findById(productoId);
        Categoria categoria= categoriaServicio.findById(categoriaId);
        List<Categoria> categorias = producto.getCategorias();
        categorias.add(categoria);
        producto.setCategorias(categorias);
        productoServicio.save(producto);
        String url="redirect:/productos/" + productoId;
        return url;
    }


}
