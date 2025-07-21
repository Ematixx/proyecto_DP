package service;

import java.util.List;

import model.Cliente;

public interface ClienteService {
	List<Cliente> findAll();
	Cliente findById(int id);
	int save(Cliente t);
	int update(Cliente t);
}
