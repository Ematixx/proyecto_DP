package patterns.factory;

import patterns.strategy.PagoConTarjeta;
import patterns.strategy.PagosStrategy;

public class PagoConTarjetaFactory extends MetodoPagoFactory{

	@Override
	public PagosStrategy crearMetodoPago() {
		return new PagoConTarjeta();
	}

}
