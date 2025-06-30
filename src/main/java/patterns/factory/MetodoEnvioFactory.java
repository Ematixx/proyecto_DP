package patterns.factory;

import patterns.strategy.EnviosStrategy;

public abstract class MetodoEnvioFactory {
	public abstract EnviosStrategy crearMetodoEnvio();
}
