package fi.gapps.intra.thesis.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.gapps.intra.thesis.model.Vertex;
import fi.gapps.intra.thesis.service.VertexService;

@RestController
@RequestMapping("/api/")
public class GraphController {

	@Autowired
	VertexService vertexService;

	@Transactional
	@RequestMapping(value = "vertex", method = RequestMethod.POST, consumes = "application/json")
	public void addVertex() {
		Vertex v = new Vertex();
		v.setName("mueees");
		vertexService.create(v);
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public Iterable<Vertex> getVertices() {
		return vertexService.findAll();
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "findByName", method = RequestMethod.GET)
	public Vertex findByName(@PathVariable("name")String name) {
		return vertexService.findByName(name);
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "findTeammates", method = RequestMethod.GET)
	public Set<Vertex> findTeammates(@PathVariable("id")Long id) {
		Vertex v = vertexService.findById(id);
		return v.teammates;
	}

}
