package fi.gapps.intra.thesis.service;

import java.util.List;

import fi.gapps.intra.thesis.model.Vertex;


public interface VertexService {
	
	Vertex create(Vertex vertex);

	void delete(Vertex vertex);
	
	Vertex findById(Long id);
	
	Vertex findByName(String name);
	
	Vertex findByEmail(String email);

	Iterable<Vertex> findAll();
	
	List<String> getCommunity(String email);
	
	List<String> getTopFriends(String email, int top);
}
