package com.cosumirapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cosumirapi.domain.SecurityUpdate;

@Repository
public interface SecurityUpdateRepository extends JpaRepository<SecurityUpdate, String> {

	
	//para passar valores nulos
	@Query("SELECT c FROM SecurityUpdate c WHERE "
			+ "(:id is null or c.id = :id) and "
			+ "(:alias is null or c.alias = :alias) and "
			+ "(:documentTitle is null or c.documentTitle = :documentTitle) and "
			+ "(:severity is null or c.severity = :severity) and "
			+ "(:cvrfUrl is null or c.cvrfUrl = :cvrfUrl)")
	List<SecurityUpdate> findAllByIdOrAliasOrDocumentTitleOrSeverityOrInitialReleaseDateOrCurrentReleaseDateOrCvrfUrlContaining(
			@Param("id") String id, 
		    @Param("alias") String alias, 
		    @Param("documentTitle") String documentTitle, 
		    @Param("severity") String severity, 
		    @Param("cvrfUrl") String cvrfUrl);

}
