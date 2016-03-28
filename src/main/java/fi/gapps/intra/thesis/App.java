package fi.gapps.intra.thesis;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;

/**
 * Hello world!
 *
 */

@Configuration
@ComponentScan("fi.gapps.intra.thesis")
@EnableAutoConfiguration
@EnableNeo4jRepositories("fi.gapps.intra.thesis.repository")

public class App extends Neo4jConfiguration {

	public App() {
		System.setProperty("username", "neo4j");
		System.setProperty("password", "root");
	}

	@Override
	public SessionFactory getSessionFactory() {
		return new SessionFactory("fi.gapps.intra.thesis.model");
	}

	@Override
	@Bean
	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Session getSession() throws Exception {
		return super.getSession();
	}

	@Override
	public Neo4jServer neo4jServer() {
		return new RemoteServer("http://localhost:7474");
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
//	@Bean(destroyMethod = "shutdown")
//	public GraphDatabaseService graphDatabaseService() {
//	    return new GraphDatabaseFactory().newEmbeddedDatabase("default.graphdb");
//	}

}
