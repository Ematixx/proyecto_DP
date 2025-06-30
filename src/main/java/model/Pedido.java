package model;

import java.util.List;

import patterns.state.EstadoPedido;
import patterns.strategy.EnviosStrategy;
import patterns.strategy.PagosStrategy;

public class Pedido {

	private int id;
	private Cliente cliente;
	private List<ItemPedido> items;
	private PagosStrategy pagosStrategy;
	private EnviosStrategy enviosStrategy;
	private EstadoPedido estadoPedido;
	private double total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItems() {
		return items;
	}

	public void setItems(List<ItemPedido> items) {
		this.items = items;
	}

	public EstadoPedido getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public void procesarPedido(double monto) {
		pagosStrategy.pagar(monto);
		enviosStrategy.enviar(this);
    }

}
