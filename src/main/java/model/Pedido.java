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
	private String pagoTipo;
	private String envioTipo;
	private String estado;

	public Pedido(Cliente cliente, List<ItemPedido> items, double total, EstadoPedido estadoPedido) {
		super();
		this.cliente = cliente;
		this.items = items;
		this.total = total;
		this.estadoPedido = estadoPedido;
	}

	public Pedido(int id, Cliente cliente, List<ItemPedido> items, double total, String pagoTipo, String envioTipo,
			String estado) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.items = items;
		this.total = total;
		this.pagoTipo = pagoTipo;
		this.envioTipo = envioTipo;
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

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

	public PagosStrategy getPagosStrategy() {
		return pagosStrategy;
	}

	public void setPagosStrategy(PagosStrategy pagosStrategy) {
		this.pagosStrategy = pagosStrategy;
	}

	public EnviosStrategy getEnviosStrategy() {
		return enviosStrategy;
	}

	public void setEnviosStrategy(EnviosStrategy enviosStrategy) {
		this.enviosStrategy = enviosStrategy;
	}

	public String getPagoTipo() {
		return pagoTipo;
	}

	public void setPagoTipo(String pagoTipo) {
		this.pagoTipo = pagoTipo;
	}

	public String getEnvioTipo() {
		return envioTipo;
	}

	public void setEnvioTipo(String envioTipo) {
		this.envioTipo = envioTipo;
	}

}
