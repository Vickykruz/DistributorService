package com.stackroute.Distributor.service;
import java.util.List;

import com.stackroute.Distributor.exceptions.DistributorAlreadyExistsException;
import com.stackroute.Distributor.exceptions.DistributorNotFoundException;
import com.stackroute.Distributor.model.*;
public interface DistributorService {
	Distributor createDistributor(Distributor distributor)throws DistributorAlreadyExistsException;
	boolean deleteDistributor(String distributorId)throws DistributorNotFoundException;
	public Distributor getDistributorById(String DistributorId) throws DistributorNotFoundException;
	//public List<Movies> getAllMoviesByDistributorLocation(String DistributorLocation);
	Distributor updateDistributor(String distributorId, Distributor distributor) throws DistributorNotFoundException;
}
