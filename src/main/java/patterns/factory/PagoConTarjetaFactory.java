package patterns.factory;

import patterns.strategy.PagoConTarjeta;
import patterns.strategy.PagosStrategy;
//tipo de pago tarjeta
public class PagoConTarjetaFactory extends MetodoPagoFactory{

	@Override
	public PagosStrategy crearMetodoPago() {
		return new PagoConTarjeta();
	}

}
