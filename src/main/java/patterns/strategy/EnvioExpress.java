package patterns.strategy;

import model.Pedido;

public class EnvioExpress implements EnviosStrategy{

	@Override
	public void enviar(Pedido pedido) {
		System.out.println("Enviando el pedido numero " + pedido.getId() + " por entrega expres.");
	}

}
