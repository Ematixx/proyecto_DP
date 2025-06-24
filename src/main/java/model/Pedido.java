package model;

import java.util.List;

public class Pedido {

	private int id;
	private Cliente cliente;
	private List<ItemPedido> items;
	private MetodoPagoFactory metodoPagoFactory;
	private MetodoEnvioFactory metodoEnvioFactory;
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

	public MetodoPagoFactory getMetodoPagoFactory() {
		return metodoPagoFactory;
	}

	public void setMetodoPagoFactory(MetodoPagoFactory metodoPagoFactory) {
		this.metodoPagoFactory = metodoPagoFactory;
	}

	public MetodoEnvioFactory getMetodoEnvioFactory() {
		return metodoEnvioFactory;
	}

	public void setMetodoEnvioFactory(MetodoEnvioFactory metodoEnvioFactory) {
		this.metodoEnvioFactory = metodoEnvioFactory;
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

}
