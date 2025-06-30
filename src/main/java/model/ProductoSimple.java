package model;

import patterns.composite.Producto;

public class ProductoSimple implements Producto {

	private int id;
	private String nombre;
	private String descripcion;
	private double precio;
	private int stock;
	private Categoria categoria;

	public ProductoSimple(int id, String nombre, String descripcion, double precio, int stock, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public double getPrecio() {
		return this.precio;
	}

	@Override
	public int getStock() {
		return this.stock;
	}

	@Override
	public double getSubTotal() {
		return this.precio * this.stock;
	}

}
