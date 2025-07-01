package service;

import java.util.List;

import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import patterns.state.EstadoPedido;
//practicamente las implementacions son los services, la interfaz se hace por buena practica
public interface PedidoService {
	
	Pedido crearPedido(Cliente cliente, List<ItemPedido> items, double total, EstadoPedido estadoPedido);
	
}
