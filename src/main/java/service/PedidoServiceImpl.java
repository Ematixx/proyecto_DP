package service;

import java.util.ArrayList;
import java.util.List;

import model.ItemPedido;
import model.Pedido;

public class PedidoServiceImpl implements PedidoService{
	
	private List<Pedido> pedidos = new ArrayList<>();

	@Override
	public Pedido crearPedido(int clienteId, List<ItemPedido> items, double total) {
		Pedido pedido = new Pedido(clienteId, items, total);
        pedidos.add(pedido);
        return pedido;
	}

}
