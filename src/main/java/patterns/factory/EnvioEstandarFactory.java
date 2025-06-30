package patterns.factory;

import patterns.strategy.EnvioEstandar;
import patterns.strategy.EnviosStrategy;
//tipo de envio standar
public class EnvioEstandarFactory extends MetodoEnvioFactory{

	@Override
	public EnviosStrategy crearMetodoEnvio() {
		return new EnvioEstandar();
	}

}
