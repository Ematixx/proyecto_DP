package model;

public class Enviado implements EstadoPedido{

	@Override
	public void avanzar(Pedido pedido) {
		pedido.setEstadoPedido(new Entregado());
	}

	@Override
	public void cancelar(Pedido pedido) {
		System.out.println("No se puede cancelar un pedido que ya fue enviado.");
	}

	@Override
	public String obtenerNombre() {
		return "Enviado";
	}

}
