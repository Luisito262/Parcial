package com.mycompany.parcial;

import java.util.Stack;

public class PilaPedidos {

    Stack<Pedido> pilaPedidos;

    public PilaPedidos() {
        pilaPedidos = new Stack<>();
    }

    public void agregarPedido(Pedido pedido) {
        pilaPedidos.push(pedido);
    }

    public Pedido procesarPedido() {
        if (!pilaPedidos.empty()) {
            Pedido pedido = pilaPedidos.pop();
            for (int i = 0; i < pedido.productos.size(); i++) {
                Producto producto = pedido.productos.get(i);
                int cantidad = pedido.cantidades.get(i);
                if (cantidad > producto.cantidadActual) {
                    System.out.println("Producto incompleto: " + producto.referencia);
                }
                producto.cantidadActual -= cantidad;
            }
            return pedido;
        }
        return null;
    }
}
