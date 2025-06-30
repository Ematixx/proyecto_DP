package service;

import java.util.List;

import model.ItemPedido;
import model.Pedido;
//practicamente las implementacions son los services, la interfaz se hace por buena practica
public interface PedidoService {
	
	Pedido crearPedido(int clienteId, List<ItemPedido> items, double total);
	
}
