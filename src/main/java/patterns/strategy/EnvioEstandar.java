package patterns.strategy;

import model.Pedido;
//tipo de envio
public class EnvioEstandar implements EnviosStrategy{

	@Override
	public void enviar(Pedido pedido) {
		System.out.println("Enviando el pedido numero " + pedido.getId() + " por correo estandar.");
	}

}
