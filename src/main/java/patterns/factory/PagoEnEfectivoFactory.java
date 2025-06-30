package patterns.factory;

import patterns.strategy.PagoEnEfectivo;
import patterns.strategy.PagosStrategy;
//tipo de pago en efectivo
public class PagoEnEfectivoFactory extends MetodoPagoFactory{

	@Override
	public PagosStrategy crearMetodoPago() {
		return new PagoEnEfectivo();
	}

}
