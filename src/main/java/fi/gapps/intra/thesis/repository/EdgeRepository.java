package fi.gapps.intra.thesis.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import fi.gapps.intra.thesis.model.Edge;

public interface EdgeRepository extends GraphRepository<Edge> {

}
