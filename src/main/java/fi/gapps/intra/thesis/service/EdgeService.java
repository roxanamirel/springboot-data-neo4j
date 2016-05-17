package fi.gapps.intra.thesis.service;

import fi.gapps.intra.thesis.model.Edge;

public interface EdgeService {

	Edge create(Edge edge);
	Iterable<Edge> findAll();
	void delete (Edge edge);
}
