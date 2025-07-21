package patterns.strategy;

import model.Pedido;
//tipo de envio
public class EnvioExpress implements EnviosStrategy{

	@Override
	public void enviar(Pedido pedido) {
		System.out.println("Enviando el pedido numero " + pedido.getId() + " por entrega expres.");
	}

	@Override
	public String getNombre() {
		return "EXPRESS";
	}

}
