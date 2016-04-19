package fi.gapps.intra.thesis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fi.gapps.intra.thesis.model.Edge;
import fi.gapps.intra.thesis.model.Vertex;
import fi.gapps.intra.thesis.service.VertexService;

@RestController
@RequestMapping("/api/v1/")
public class GraphController {

	@Autowired
	private VertexService vertexService;

	@Transactional
	@RequestMapping(value = "vertex", method = RequestMethod.POST, consumes = "application/json")
	public void addVertex(@RequestBody List<Vertex> vertices) {
		for (Vertex v : vertices) {
			Vertex old = vertexService.findByEmail(v.getEmail());
			if (old == null) {
				vertexService.create(v);
			}
		}

	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "vertex", method = RequestMethod.GET)
	public Iterable<Vertex> getAllVertices() {
		return vertexService.findAll();
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(value = "vertex/teammates", method = RequestMethod.GET)
	public List<String> getCommunity(@RequestHeader (name="email") String email) {
		System.out.println("Email " + email);
		return vertexService.getCommunity(email);
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(value = "vertex/topFriends", method = RequestMethod.GET)
	public List<String> getTopFriends(@RequestHeader (name="email") String email) {
		System.out.println("Email " + email);
		return vertexService.getTopThree(email);
	}

}
