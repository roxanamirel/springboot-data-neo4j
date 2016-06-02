package fi.gapps.intra.thesis;

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
		System.setProperty("server.port", "80");
		System.setProperty("username", "neo4j");
		System.setProperty("password", "root");

	}

	@Override
	@Bean
	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Session getSession() throws Exception {
		return super.getSession();
	}

	@Bean
	public org.neo4j.ogm.config.Configuration getConfiguration() {
		org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();
		config.driverConfiguration().setDriverClassName("org.neo4j.ogm.drivers.embedded.driver.EmbeddedDriver")
				.setURI("file:///var/lib/neo4j/data/graph.db");
		return config;
	}

	@Bean
	public SessionFactory getSessionFactory() {
		return new SessionFactory(getConfiguration(), "fi.gapps.intra.thesis.model");
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}

}
