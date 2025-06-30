package service;

import java.util.List;

import model.ItemPedido;

public class PrecioServiceImpl implements PrecioService{
	//calcula el todal
	@Override
	public double calcularTotal(List<ItemPedido> items) {
		double total = 0;
        for (ItemPedido item : items) {
            double precioUnitario = getPrecioPorItem(item);
            total += precioUnitario * item.getCantidad();
        }
        return total;
	}
	//obtenemos el preio por item para sacar el total
	@Override
	public double getPrecioPorItem(ItemPedido item) {
		return item.getProducto().getSubTotal();
	}

}
