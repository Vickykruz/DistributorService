package com.stackroute.Distributor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.Distributor.model.*;

/*public interface DistributorRepository {*/
	@Repository
	public interface DistributorRepository extends MongoRepository<Distributor, String> {

		//Optional<Distributor> findByLocation(String distributorLocation);
		//public List<Movies> findByDistributorLocation(String distributorLocation);

		//public List<Movies> findByDistributorLocation(String distributorLocation);

		/*Optional<Distributor> findByLocation(String distributorLocation);*/
		

		//public Distributor findByLocation(String distributorLocation);
	}

	/*public Distributor insert(Distributor distributor);

	public boolean existsById(String distributorId);

	public Distributor findById(String distributorId);

	public void delete(Distributor fetchDistributor);

	public void save(Distributor fetchDistributor);

	public Distributor findByLocation(String distributorLocation);
*/
	

