package fi.gapps.intra.thesis.controller;

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
@RequestMapping("/api/v1/")
public class GraphController {

	@Autowired
	VertexService vertexService;

	@Transactional
	@RequestMapping(value = "vertex", method = RequestMethod.POST, consumes = "application/json")
	public Vertex addVertex(@RequestBody Vertex vertex) {
//		Vertex old = vertexService.findByEmail(vertex.getEmail());
//		if (old != null) {
//			for (Vertex v : vertex.getTeammates()) {
//				old.worksWith(v);
//			}
//			return vertexService.create(old);
//		} else {
			return vertexService.create(vertex);
//		}

	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "vertex", method = RequestMethod.GET)
	public Iterable<Vertex> getAllVertices() {
		return vertexService.findAll();
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "vertex/teammate", method = RequestMethod.GET)
	public Set<Vertex> findTeammates(@PathVariable("id") Long id) {
		Vertex v = vertexService.findById(id);
		return v.getTeammates();
	}

}
