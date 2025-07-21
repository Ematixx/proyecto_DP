package patterns.composite;

public interface Producto {
	
	int getId();
	String getNombre();
	double getPrecio();
	int getStock();
	double getSubTotal();
	void setStock(int nuevoStock);
	
}
