package com.br.chocolatePontoVirgula.controller;

import com.br.chocolatePontoVirgula.model.dto.ClienteDTO;
import com.br.chocolatePontoVirgula.model.form.ClienteForm;
import com.br.chocolatePontoVirgula.model.repository.ClienteRepository;
import com.br.chocolatePontoVirgula.model.repository.ProdutoRepository;
import com.br.chocolatePontoVirgula.model.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.chocolatePontoVirgula.model.entity.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@Autowired
	ClienteRepository clienteRepository;

	@PostMapping
	public ResponseEntity<String> save(@RequestBody ClienteForm cliente){
		return clienteService.save(cliente);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @RequestBody Cliente cliente){
		clienteService.update(id, cliente);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		clienteService.delete(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		 return clienteService.findById(id);
	}

	@GetMapping("/all")
	public ResponseEntity<Page<Cliente>> findAll( Pageable pageable) {
		return clienteService.findAll(pageable);
	}
}
