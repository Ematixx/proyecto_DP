package service;

import java.util.List;

import model.ItemPedido;
//practicamente las implementacions son los services, la interfaz se hace por buena practica
public interface PrecioService {
	
	double calcularTotal(List<ItemPedido> items);
	double getPrecioPorItem(ItemPedido item);
	
}
