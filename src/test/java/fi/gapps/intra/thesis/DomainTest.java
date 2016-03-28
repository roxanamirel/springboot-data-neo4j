//package fi.gapps.intra.thesis;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import fi.gapps.intra.thesis.model.Vertex;
//import fi.gapps.intra.thesis.service.VertexService;
//import fi.gapps.intra.thesis.service.impl.VertexServiceImpl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import com.google.common.collect.Lists;
//
//
//@ContextConfiguration(classes = {App.class})
//@RunWith(SpringJUnit4ClassRunner.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//@WebAppConfiguration
//public class DomainTest {
//
//   @Autowired
//    VertexService vertexService;
//
//    @Test
//    public void shouldBeAbleToSaveAnIngredient() {
//    	Vertex v = new Vertex();
//		v.setId(1l);
//		v.setLabel("Roxana");
//		v.setName("Roxana");
//		Vertex v2 = new Vertex();
//		v2.setId(2l);
//		v2.setLabel("vlad");
//		
//		v.worksWith(v2);
//		Vertex ret = vertexService.create(v);
//		assertEquals("Roxana",ret.getName());
//		
//		List<Vertex> vs = Lists.newArrayList(vertexService.findAll());
//		assertEquals(1,vs.size());
//    }
//}