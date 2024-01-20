package com.joel.productos_categorias.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="productos")
@Getter
@Setter
@NoArgsConstructor
public class Producto extends ModelBase {

    @NotNull
    @NotBlank
    @Size(min = 3)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 5)
    private String description;

    @NotNull
    private float price;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categorias_productos", 
        joinColumns = @JoinColumn(name = "producto_id"), 
        inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias;
}

