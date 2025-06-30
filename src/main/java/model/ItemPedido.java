package model;

public class ItemPedido {

	private ProductoSimple producto;
	private int cantidad;

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
