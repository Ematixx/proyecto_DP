package patterns.factory;

import patterns.strategy.EnviosStrategy;
//utilizamos el patron para permitir la creacion dinamica de diferentes	estrategias de envio
public abstract class MetodoEnvioFactory {
	//el objeto devuelto implementa la interfaz EnviosStrategy
	public abstract EnviosStrategy crearMetodoEnvio();
}
