package guru.springframework;

import guru.springframework.controllers.IndexController;
import guru.springframework.services.RecipeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring5RecipeAppApplicationTests {

	// Requisiti esercizio
	/* 	1) Creare un test per il conreoller
	*	2) Usare Mockito Mock per RecipeService e Model
	* 	3) Controllare che la stringa corretta venga ritornata dal controller
	* 	4) Verificare le interazioni con i mock
	* */

	@MockBean
	private RecipeService recipeService;

	@Mock
	private Model model;

	IndexController controller;

	@Before
	public void setUp() {
		when(recipeService.getRecipes()).thenReturn(new HashSet<>());
		controller = new IndexController(recipeService);
	}

	@Test
	public void testController() {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		try {
			mockMvc.perform(get("/")).andExpect(status().isOk());
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Test
	public void contextLoads() {
		IndexController indexController = new IndexController(recipeService);
		Assert.assertEquals("index", indexController.getIndexPage(model));
	}



}
