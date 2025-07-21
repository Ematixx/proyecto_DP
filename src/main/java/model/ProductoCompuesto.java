package model;

import java.util.ArrayList;
import java.util.List;

import patterns.composite.Producto;

public class ProductoCompuesto implements Producto {

	private String nombre;
	private int stock;
	private List<Producto> productos = new ArrayList<Producto>();

	public ProductoCompuesto(String nombre, int stock) {
		super();
		this.nombre = nombre;
		this.stock = stock;
	}

	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public double getPrecio() {
		double total = 0;
		for (Producto p : productos) {
			total += p.getSubTotal();
		}
		return total;
	}

	@Override
	public int getStock() {
		return this.stock;
	}

	@Override
	public double getSubTotal() {
		return getPrecio() * this.stock;
	}
	
	public void mostrarContenido(String prefijo) {
        System.out.println(prefijo + getNombre() + 
                " (x" + this.stock + ") - Subtotal: $"
                + getSubTotal());
        for (Producto p : productos) {
            if (p instanceof ProductoCompuesto) {
                ((ProductoCompuesto) p)
                        .mostrarContenido(prefijo + "  ");
            } else {
                System.out.println(prefijo + "  "
                        + p.getNombre() + " (x" 
                        + p.getStock() 
                        + ") - Subtotal: $" 
                        + p.getSubTotal());
            }
        }
    }

	@Override
	public void setStock(int nuevoStock) {
		this.stock = nuevoStock;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
