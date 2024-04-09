package com.mycompany.parcial;

public class Producto {

    int referencia;
    String descripcion;
    int cantidadInicial;
    int cantidadActual;
    double costo;
    double precioVenta;

    public Producto(int referencia, String descripcion, int cantidadInicial, int cantidadActual, double costo, double precioVenta) {
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.cantidadInicial = cantidadInicial;
        this.cantidadActual = cantidadActual;
        this.costo = costo;
        this.precioVenta = precioVenta;
    }

}
