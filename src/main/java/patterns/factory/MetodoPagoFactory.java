package patterns.factory;

import patterns.strategy.PagosStrategy;
//utilizamos el patron para permitir la creacion dinamica de diferentes	estrategias de envio
public abstract class MetodoPagoFactory {
	//el objeto devuelto implementa la interfaz PagosStrategy
	public abstract PagosStrategy crearMetodoPago();
}
