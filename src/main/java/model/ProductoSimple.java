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

	@Override
	public int getId() {
		return id;
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

	@Override
	public void setStock(int nuevoStock) {
		this.stock = nuevoStock;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
