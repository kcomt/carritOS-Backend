package com.FAS.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.FAS.entities.Contract;
import com.FAS.service.IContractService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contracts")
@Api(value="REST contract")
public class ContractController {

	@Autowired
	private IContractService contractService;
	
	@ApiOperation("Registro de contracts")
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> savecontract(@Valid @RequestBody Contract contract)
	{
		try {
			Contract hor = new Contract();
			hor= contractService.save(contract);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hor.getId()).toUri();
			
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
	}
	
	@ApiOperation("Listado de contracts")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contract>> fetchcontracts(){
		try {
			List<Contract> contracts = new ArrayList<>();
			contracts= contractService.findAll();
			return new ResponseEntity<List<Contract>>(contracts,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Contract>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Listado de contracts por ownerId y estado")
	@GetMapping(value = "owner/{ownerId}/state/{estado}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contract>> fetchcontractsByownerIdAndState(@PathVariable("ownerId") int ownerId,@PathVariable("estado") boolean estado){
		try {
			List<Contract> contracts = new ArrayList<>();
			contracts= contractService.fetchByBuisnessOwnerIdState(ownerId, estado);
			return new ResponseEntity<List<Contract>>(contracts,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Contract>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Listado de contracts por consumerId y estado")
	@GetMapping(value = "consumer/{consumerId}/state/{estado}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contract>> fetchcontractsByconsumerIdAndState(@PathVariable("consumerId") int consumerId,@PathVariable("estado") boolean estado){
		try {
			List<Contract> contracts = new ArrayList<>();
			contracts= contractService.fetchByConsumerIdState(consumerId, estado);
			return new ResponseEntity<List<Contract>>(contracts,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Contract>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener contract por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contract> fetchcontract(@PathVariable("id") Integer id) {

		try {
			Optional<Contract> bO = contractService.findById(id);

			if (!bO.isPresent()) {
				return new ResponseEntity<Contract>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Contract>(bO.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Contract>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Actualizar contract")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Contract contract) {
		try {
			contractService.update(contract);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Eliminar contract por id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Contract> hor = contractService.findById(id);

			if (!hor.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				contractService.deleteById(id);
				return new ResponseEntity<>("contract se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
