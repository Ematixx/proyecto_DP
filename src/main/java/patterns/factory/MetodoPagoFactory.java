package patterns.factory;

import patterns.strategy.PagosStrategy;

public abstract class MetodoPagoFactory {
	public abstract PagosStrategy crearMetodoPago();
}
