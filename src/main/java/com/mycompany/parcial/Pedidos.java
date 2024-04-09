package com.mycompany.parcial;

import java.util.ArrayList;

public class Pedidos {

    public static void main(String[] args) {
        Vendedor vendedor1 = new Vendedor("V001", "Juan", "Pérez", "Av. Siempre Viva 123", "555-1234", "555-5678");
        Vendedor vendedor2 = new Vendedor("V002", "María", "García", "Av. Revolución 456", "555-5678", "555-9012");
        Producto producto1 = new Producto(001, "Leche", 100, 100, 0.5, 1.0);
        Producto producto2 = new Producto(002, "Pan", 200, 200, 0.3, 0.6);
        Producto producto3 = new Producto(003, "Huevos", 50, 50, 0.1, 0.2);
        Cliente cliente1 = new Cliente("C001", "Ana", "López", "Av. Juárez 789", "555-2345", "555-6789");
        Cliente cliente2 = new Cliente("C002", "Pedro", "Martínez", "Av. Insurgentes 321", "555-6789", "555-0123");
        ArrayList<Producto> productosPedido1 = new ArrayList<Producto>();
        productosPedido1.add(producto1);
        productosPedido1.add(producto2);
        ArrayList<Integer> cantidadesPedido1 = new ArrayList<Integer>();
        cantidadesPedido1.add(2);
        cantidadesPedido1.add(3);
        Pedido pedido1 = new Pedido(productosPedido1, cantidadesPedido1);
        ArrayList<Producto> productosPedido2 = new ArrayList<Producto>();
        productosPedido2.add(producto1);
        productosPedido2.add(producto3);
        ArrayList<Integer> cantidadesPedido2 = new ArrayList<Integer>();
        cantidadesPedido2.add(1);
        cantidadesPedido2.add(2);
        Pedido pedido2 = new Pedido(productosPedido2, cantidadesPedido2);
        PilaPedidos pilaPedidosVendedor1 = new PilaPedidos();
        pilaPedidosVendedor1.agregarPedido(pedido1);
        pilaPedidosVendedor1.agregarPedido(pedido2);
        System.out.println("Pedidos procesados por " + vendedor1.nombre + " " + vendedor1.apellidos + ":");
        while (!pilaPedidosVendedor1.pilaPedidos.empty()) {
            Pedido pedido = pilaPedidosVendedor1.procesarPedido();
            if (pedido != null) {
                double totalPedido = 0.0;
                for (int i = 0; i < pedido.productos.size(); i++) {
                    Producto producto = pedido.productos.get(i);
                    int cantidad = pedido.cantidades.get(i);
                    double totalProducto = cantidad * producto.precioVenta;
                    totalPedido += totalProducto;
                    System.out.println("Producto despachado: " + producto.referencia + ", cantidad: " + cantidad + ", total: " + totalProducto);
                }
                System.out.println("Total del pedido: " + totalPedido);
            }
        }

    }
}
