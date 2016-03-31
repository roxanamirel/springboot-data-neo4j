package fi.gapps.intra.thesis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.gapps.intra.thesis.model.Edge;
import fi.gapps.intra.thesis.repository.EdgeRepository;
import fi.gapps.intra.thesis.service.EdgeService;

@Service
public class EdgeServiceImpl implements EdgeService {

	@Autowired
	private EdgeRepository edgeRepository;
	
	@Override
	public Edge create(Edge edge) {
		return edgeRepository.save(edge);
	}

}
