package service;

import java.util.List;

import model.Cliente;
import repository.ClienteRepository;

public class ClienteServiceImpl implements ClienteService{
	
	private final ClienteRepository clienteRepository;
	
	public ClienteServiceImpl() {
		this.clienteRepository = new ClienteRepository();
	}

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente findById(int id) {
		return clienteRepository.findById(id);
	}

	@Override
	public int save(Cliente t) {
		return clienteRepository.save(t);
	}

	@Override
	public int update(Cliente t) {
		return clienteRepository.update(t);
	}

}
