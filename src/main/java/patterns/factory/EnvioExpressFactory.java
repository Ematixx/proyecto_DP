package patterns.factory;

import patterns.strategy.EnvioExpress;
import patterns.strategy.EnviosStrategy;
//tipo de envio express
public class EnvioExpressFactory extends MetodoEnvioFactory{

	@Override
	public EnviosStrategy crearMetodoEnvio() {
		return new EnvioExpress();
	}

}
