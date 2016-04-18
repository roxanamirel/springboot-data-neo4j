package fi.gapps.intra.thesis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.List;

import fi.gapps.intra.thesis.model.Edge;
import fi.gapps.intra.thesis.model.Vertex;
import fi.gapps.intra.thesis.repository.VertexRepository;
import fi.gapps.intra.thesis.service.VertexService;

@Service
public class VertexServiceImpl implements VertexService {

	@Autowired
	private VertexRepository vertexRepository;

	@Override
	@Transactional
	public Vertex create(Vertex vertex) {
		return vertexRepository.save(vertex);
	}

	@Override
	public void delete(Vertex vertex) {
		vertexRepository.delete(vertex);
	}

	@Override
	public Vertex findByName(String name) {
		return vertexRepository.findByName(name);
	}
	
	@Override
	public Vertex findByEmail(String email) {
		return vertexRepository.findByEmail(email);
	}

	@Override
	@Transactional
	public Iterable<Vertex> findAll() {
		return vertexRepository.findAll();
	}

	@Override
	public Vertex findById(Long id) {
		return vertexRepository.findOne(id);
	}

	@Override
	public List<String> getCommunity(String email) {
		Vertex curr = vertexRepository.findByEmail(email);
		System.out.println("NO Edges" + curr.getTeammates().size());
		List<String> teammates = new ArrayList<>();
		for (Edge edge: curr.getTeammates()){
			teammates.add(edge.getDest().getEmail());
			
		}
		return teammates;
	}

}
