package fi.gapps.intra.thesis.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


@NodeEntity
public class Vertex  {
	
    @GraphId
	private Long id;
    //will be the email address =>unique
	private String name;

	@Relationship(type = "PAIRS_WITH", direction = "UNDIRECTED")
    public  Set<Vertex> teammates;
	
	
	public Vertex() {	}

	public Vertex(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void worksWith(Vertex person) {
        if (teammates == null) {
            teammates = new HashSet<>();
        }
        teammates.add(person);
    }

	
	
}
