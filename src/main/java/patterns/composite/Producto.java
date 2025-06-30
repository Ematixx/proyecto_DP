package patterns.composite;

public interface Producto {
	
	String getNombre();
	double getPrecio();
	int getStock();
	double getSubTotal();
	void setStock(int nuevoStock);
	
}
