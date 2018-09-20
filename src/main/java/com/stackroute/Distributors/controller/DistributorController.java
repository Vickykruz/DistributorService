package com.stackroute.Distributors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.Distributor.exceptions.DistributorAlreadyExistsException;
import com.stackroute.Distributor.exceptions.DistributorNotFoundException;
import com.stackroute.Distributor.model.Distributor;
import com.stackroute.Distributor.model.Movies;
import com.stackroute.Distributor.service.DistributorService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class DistributorController {
	private DistributorService distributorService;

	

	@Autowired
	public DistributorController(DistributorService distributorService) {
		super();
		this.distributorService = distributorService;
	}
	@PostMapping("/distributor")
	public ResponseEntity<?>createDistributor(@RequestBody Distributor distributor){
		ResponseEntity<?>responseEntity= null;
		try {
			distributorService.createDistributor(distributor);
			responseEntity = new ResponseEntity<Distributor>(distributor,HttpStatus.CREATED);
		}
		catch(DistributorAlreadyExistsException e){
			responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	@PutMapping("/distributor/{distributorId}")
	public ResponseEntity<?>updateRepository(@PathVariable() String distributorId,@RequestBody Distributor distributor){
		ResponseEntity<?>responseEntity=null;
		try {
			Distributor fetchDistributor=distributorService.updateDistributor(distributorId, distributor);
			responseEntity= new ResponseEntity<>(fetchDistributor,HttpStatus.OK);
		}
		catch(DistributorNotFoundException e){
			responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@DeleteMapping("/distributor/{distributorId}")
	public ResponseEntity<?>deleteRepository(@PathVariable() String distributorId){
		ResponseEntity<?>responseEntity=null;
		try {
			distributorService.deleteDistributor(distributorId);
			responseEntity = new ResponseEntity<>("Distributor is Successfully Deleted"+ distributorId,HttpStatus.OK);
		}
		catch(DistributorNotFoundException e) {
			responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@GetMapping("/{id}")
	public ResponseEntity<?>getDistributorById(@PathVariable String id){
		ResponseEntity<?>responseEntity=null;
		try {
			Distributor fetchDistributor= distributorService.getDistributorById(id);
			responseEntity=new ResponseEntity<>(fetchDistributor,HttpStatus.OK);
		}catch(DistributorNotFoundException e) {
			responseEntity = new ResponseEntity<>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
/*	@GetMapping("/{location}")
	   public ResponseEntity<?> getAllMoviesByDistributorLocation(@PathVariable() String DistributorLocation) {
	       ResponseEntity<?> responseEntity = null;

	        @SuppressWarnings("unused")
			Distributor distributorLocation = null;
	        List<Movies> movie = distributorService.getAllMoviesByDistributorLocation(DistributorLocation);

	       if (movie != null) {
	           responseEntity = new ResponseEntity<List<Movies>>(movie, HttpStatus.OK);
	       } else {
	           responseEntity = new ResponseEntity<String>("You don't have any movies added in your list", HttpStatus.OK);
	       }


	       return responseEntity;
	   }*/
}
