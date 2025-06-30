package patterns.state;

import model.Pedido;

public class Entregado implements EstadoPedido{

	@Override
	public void avanzar(Pedido pedido) {
		System.out.println("El pedido ya fue entregado. No se puede avanzar más.");
	}

	@Override
	public void cancelar(Pedido pedido) {
		System.out.println("No se puede cancelar un pedido entregado.");
	}

	@Override
	public String obtenerNombre() {
		return "Entregado";
	}

}
