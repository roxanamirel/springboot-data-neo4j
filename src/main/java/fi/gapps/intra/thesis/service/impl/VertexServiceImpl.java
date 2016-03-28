package fi.gapps.intra.thesis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.Iterable;
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
	@Transactional
	public Iterable<Vertex> findAll() {
		return vertexRepository.findAll();
	}

	@Override
	public Vertex findById(Long id) {
		return vertexRepository.findOne(id);
	}

}
