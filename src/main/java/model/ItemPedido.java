package model;

import patterns.composite.Producto;

public class ItemPedido {
	
	private int id;
	private Producto producto;
	private int cantidad;
	
	public ItemPedido() {
		super();
	}

	public ItemPedido(int id, Producto producto, int cantidad) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
