package com.boasaude.SGPS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boasaude.SGPS.Entity.ServiceProvider;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {
	@Query("select a from ServiceProvider a order by id")
	List<ServiceProvider> findAllAndSort();
}
