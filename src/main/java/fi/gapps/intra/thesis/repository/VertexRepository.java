package fi.gapps.intra.thesis.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import fi.gapps.intra.thesis.model.Vertex;

@Repository
public interface VertexRepository extends GraphRepository<Vertex> {
	
	Vertex findByName(String name);
	
	Vertex findByEmail(String email);

    List<Vertex> findByTeammatesName(String name);

}
