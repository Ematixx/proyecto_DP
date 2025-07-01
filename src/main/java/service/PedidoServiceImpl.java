package service;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import patterns.state.EstadoPedido;

public class PedidoServiceImpl implements PedidoService{
	
	private List<Pedido> pedidos = new ArrayList<>();

	@Override
	public Pedido crearPedido(Cliente cliente, List<ItemPedido> items, double total, EstadoPedido estadoPedido) {
		Pedido pedido = new Pedido(cliente, items, total, estadoPedido);
        pedidos.add(pedido);
        return pedido;
	}

}
