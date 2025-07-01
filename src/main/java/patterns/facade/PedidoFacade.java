package patterns.facade;

import java.util.List;

import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import patterns.composite.Producto;
import patterns.observer.Notificador;
import patterns.observer.NotificadorImpl;
import patterns.state.Pendiente;
import service.PedidoService;
import service.PedidoServiceImpl;
import service.PrecioService;
import service.PrecioServiceImpl;

public class PedidoFacade {
	
	//llamamos a los services
	private PedidoService pedidoService = new PedidoServiceImpl();
	private PrecioService precioService = new PrecioServiceImpl();
	private Notificador notificador = new NotificadorImpl();
	
	public Pedido crearPedido(Cliente cliente, List<ItemPedido> items) {
       
		//validar stock
		for (ItemPedido item : items) {
            int stockDisponible = item.getProducto().getStock();
            int cantidadSolicitada = item.getCantidad();

            if (stockDisponible < cantidadSolicitada) {
                throw new IllegalArgumentException("Stock insuficiente para el producto: " 
                        + item.getProducto().getNombre());
            }
        }
		
		//reserva el stock
        for (ItemPedido item : items) {
            Producto producto = item.getProducto();
            int nuevoStock = producto.getStock() - item.getCantidad();
            producto.setStock(nuevoStock); //asgina el nuevo stock
        }

        double total = precioService.calcularTotal(items);
        Pedido pedido = pedidoService.crearPedido(cliente, items, total, new Pendiente());
        notificador.notificar(pedido);

        System.out.println("Pedido creado correctamente");
        
        return pedido;
    }

	public Notificador getNotificador() {
		return notificador;
	}

	public void setNotificador(Notificador notificador) {
		this.notificador = notificador;
	}
	
}
