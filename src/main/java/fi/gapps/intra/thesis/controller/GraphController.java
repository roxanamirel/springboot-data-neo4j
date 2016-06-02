package fi.gapps.intra.thesis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.gapps.intra.thesis.model.Edge;
import fi.gapps.intra.thesis.model.Vertex;
import fi.gapps.intra.thesis.service.EdgeService;
import fi.gapps.intra.thesis.service.VertexService;

@RestController
@RequestMapping("/api/v1/")
public class GraphController {

	@Autowired
	private VertexService vertexService;

	@Autowired
	private EdgeService edgeService;

	private static final String TOKEN = "fb080452-1cc9-11e6-b6ba-3e1d05defe78";
	private static final String AUTH_MSG = "ERROR: NOT AUTHENTICATED!";

	@Transactional
	@RequestMapping(value = "vertex/all", method = RequestMethod.POST, consumes = "application/json")
	public void addVertex(@RequestBody RequestObject reqObject) {
		String token = reqObject.getToken();
		if (!token.equals(TOKEN)) {
			System.out.println(AUTH_MSG);
			return;
		}

		// Vertex v = new Vertex();
		// v.setEmail("ysyysys@gmail.com");
		// v.setName("ICSY");
		// v.setUniverseUserId(3l);
		// for(int i=0;i<40;i++){
		// Vertex vv = new Vertex();
		// vv.setEmail("email" + i + "@yahoo.com");
		// vv.setName("NAme" + i);
		// vv.setUniverseUserId(Long.valueOf(i));
		// Edge edge = new Edge();
		// edge.setDest(vv);
		// edge.setSrc(v);
		// edge.setWeight(i);
		// v.worksWith(edge);
		// }
		// vertexService.create(v);

		List<Vertex> vertices = reqObject.getVertices();
		for (Vertex v : vertices) {
			Vertex old = vertexService.findByEmail(v.getEmail());
			if (old == null && !v.getEmail().contains("aaron")) {
				System.out.println("Teammates of " + v.getEmail());
				Vertex newV = new Vertex();
				newV.setEmail(v.getEmail());
				newV.setName(v.getName());
				newV.setUniverseUserId(v.getUniverseUserId());
				for (Edge e : v.getTeammates()) {
					Edge newE = new Edge();
					Vertex dest =  new Vertex();
					dest.setEmail(e.getDest().getEmail());
					dest.setName(e.getDest().getName());
					dest.setUniverseUserId(e.getDest().getUniverseUserId());
					if(e.getDest() !=null){
						for(Edge dd: e.getDest().getTeammates()){
							dest.worksWith(dd);
						}
					}
					
					
					newE.setDest(dest);
					newE.setSrc(newV);
					newE.setWeight(e.getWeight());
					newV.worksWith(newE);
				}
				vertexService.create(newV);
			} else {
				for (Edge e : v.getTeammates()) {
					boolean found = false;
					if(old.getTeammates()!=null){
						for (Edge t : old.getTeammates()) {
							if (e.getDest().getEmail().equals(t.getDest().getEmail())) {
								found = true;
							}
						}
						if (found == false)
							old.worksWith(e);
							
					}
				
				}
			}
		}

		System.out.println("Done");

	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "vertex", method = RequestMethod.GET)
	public Iterable<Vertex> getAllVertices() {
		return vertexService.findAll();
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "vertex/teammates", method = RequestMethod.GET)
	public List<String> getCommunity(@RequestHeader(name = "email") String email,
			@RequestHeader(name = "token") String token) {
		if (!token.equals(TOKEN)) {
			System.out.println(AUTH_MSG);
			return new ArrayList<>();
		}
		System.out.println("Email " + email);
		return vertexService.getCommunity(email);
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "vertex/topFriends", method = RequestMethod.GET)
	public List<String> getTopFriends(@RequestHeader(name = "email") String email,
			@RequestHeader(name = "top") Integer top, @RequestHeader(name = "token") String token) {
		if (!token.equals(TOKEN)) {
			System.out.println(AUTH_MSG);
			return new ArrayList<>();
		}
		System.out.println("Email " + email);
		return vertexService.getTopFriends(email, top);
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "vertex/delete", method = RequestMethod.DELETE)
	public void deleteAll() {
		Iterable<Vertex> vertices = vertexService.findAll();
		for (Vertex v : vertices) {
			vertexService.delete(v);
		}
		Iterable<Edge> edges = edgeService.findAll();
		for (Edge e : edges) {
			edgeService.delete(e);
		}

	}
}
