package fi.gapps.intra.thesis.controller;
import java.util.List;
import fi.gapps.intra.thesis.model.Vertex;


public class RequestObject {
		
		private String token;
		private List<Vertex> vertices;
		
		
		public RequestObject() {
		}
		public RequestObject(String token, List<Vertex> vertices) {
			this.token = token;
			this.vertices = vertices;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public List<Vertex> getVertices() {
			return vertices;
		}
		public void setVertices(List<Vertex> vertices) {
			this.vertices = vertices;
		}


}
