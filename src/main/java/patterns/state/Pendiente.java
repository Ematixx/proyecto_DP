package patterns.state;

import model.Pedido;
//estado de pedido
public class Pendiente implements EstadoPedido{

	@Override
	public void avanzar(Pedido pedido) {
		pedido.setEstadoPedido(new Enviado());
	}

	@Override
	public void cancelar(Pedido pedido) {
		pedido.setEstadoPedido(new Cancelado());
	}

	@Override
	public String obtenerNombre() {
		return "Pendiente";
	}

}
