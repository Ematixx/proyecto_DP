package model;

public class ItemPedido {
	
	private int id;
	private ProductoSimple producto;
	private int cantidad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductoSimple getProducto() {
		return producto;
	}

	public void setProducto(ProductoSimple producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
