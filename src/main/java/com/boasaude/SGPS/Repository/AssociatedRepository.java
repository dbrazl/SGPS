package com.boasaude.SGPS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boasaude.SGPS.Entity.Associated;

@Repository
public interface AssociatedRepository extends JpaRepository<Associated, Long> {
	@Query("select a from Associated a order by id")
	List<Associated> findAllAndSort();
}