package com.mybooking.demo.repository.rdbms;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybooking.demo.model.rdbms.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

	public List<Theater> findByPartnerId(Integer partnerId);

	/*
	 * Case 1: If we query the table from the Spring Data Repositories (or Hibernate
	 * ORM) then it is safe from SQL injection vulnerabilities...
	 */

//	@Query("From Theater where partnerId = :partnerId")  // named parameters
//	@Query("From Theater where partnerId = ? ")  // indexed parameters
//	@Query("select * from theater where partnerId = ? ", nativeQuery = true))  // native sql query
//	public List<Theater> getPartnerId(Integer partnerId);

	/*
	 * Case 2: But if we are using entityManager(or try to query some other way)
	 * then we need to sanitize/validate parameters 
	 * if we are taking them from the directly request...
	 */
// Query sqlQuery = entityManager.createNativeQuery("Select * from Theater where partnerId = ?", Theater.class);
// List results = sqlQuery.setParameter(1, <parameter_from_the_request>).getResultList();


}
