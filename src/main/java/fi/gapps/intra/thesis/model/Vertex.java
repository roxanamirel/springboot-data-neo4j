package fi.gapps.intra.thesis.model;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity (label="User")
public class Vertex  {
	private Long id;
	private String name;
	private String email;
	private Long universeUserId;
	
	@Relationship(type="WORKS_WITH", direction = Relationship.OUTGOING)
    private  List<Edge> teammates;
	
	
	public Vertex() {	}


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
	
	public Long getUniverseUserId() {
		return universeUserId;
	}


	public void setUniverseUserId(Long universeUserId) {
		this.universeUserId = universeUserId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


//	public void worksWith(Vertex person) {
//        if (teammates == null) {
//            teammates = new ArrayList<>();
//        }
//        teammates.add(person);
//    }
//
//	public Vertex( String name) {
//	
//		this.name = name;
//	}
//
//
//	public List<Vertex> getTeammates() {
//		return teammates;
//	}
	
	public void worksWith(Edge person) {
        if (teammates == null) {
            teammates = new ArrayList<>();
        }
        teammates.add(person);
    }

	public Vertex( String name) {
	
		this.name = name;
	}


	public List<Edge> getTeammates() {
		return teammates;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((universeUserId == null) ? 0 : universeUserId.hashCode());
		return result;
	}


	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (universeUserId == null) {
			if (other.universeUserId != null)
				return false;
		} else if (!universeUserId.equals(other.universeUserId))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	
}
