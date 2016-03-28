package fi.gapps.intra.thesis.service;

import fi.gapps.intra.thesis.model.Vertex;
import java.lang.Iterable;


public interface VertexService {
	
	Vertex create(Vertex vertex);

	void delete(Vertex vertex);
	
	Vertex findById(Long id);
	
	Vertex findByName(String name);

	Iterable<Vertex> findAll();
}
