package com.mycompany.parcial;

import java.util.ArrayList;

public class Pedido {

    ArrayList<Producto> productos;
    ArrayList<Integer> cantidades;

    public Pedido(ArrayList<Producto> productos, ArrayList<Integer> cantidades) {
        this.productos = productos;
        this.cantidades = cantidades;
    }

}
