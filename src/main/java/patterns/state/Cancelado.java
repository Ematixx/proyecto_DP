package patterns.state;

import model.Pedido;

public class Cancelado implements EstadoPedido{

	@Override
	public void avanzar(Pedido pedido) {
		System.out.println("El pedido está cancelado. No se puede avanzar.");
	}

	@Override
	public void cancelar(Pedido pedido) {
		System.out.println("El pedido ya está cancelado.");
	}

	@Override
	public String obtenerNombre() {
		return "Cancelado";
	}

}
