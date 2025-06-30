package patterns.factory;

import patterns.strategy.PagoEnEfectivo;
import patterns.strategy.PagosStrategy;

public class PagoEnEfectivoFactory extends MetodoPagoFactory{

	@Override
	public PagosStrategy crearMetodoPago() {
		return new PagoEnEfectivo();
	}

}
