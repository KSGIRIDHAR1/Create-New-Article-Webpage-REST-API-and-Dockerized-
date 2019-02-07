package com.cts.newsarticle.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleControllerMockMVCTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleControllerMockMVCTest.class);
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testForFavoriteArticleSave() throws Exception {

		LOGGER.info("Start");

		String TEST_DATA = "{\"id\":\"8\"" + "," + "\"article\":[{\"id\":\"1\"" + "," + "\"title\":\"giridhar\""
				+ "," + "\"author\":\"giridhar\"" + "," + "\"description\":\"asdsad\"" + ","
				+ "\"content\":\"xzcaswqe\"" + "," + "\"url\":\"asda\"" + "," + "\"urlToImage\":\"asda\"}]}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/saveArticle").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk());
		LOGGER.info("End");
	}
	
	@Test
	public void testForFavoriteArticleDelete() throws Exception {

		LOGGER.info("Start");

		String TEST_DATA = "{\"id\":\"8\"" + "," + "\"article\":[{\"title\":\"giridhar\"}]}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/delete").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk());
		LOGGER.info("End");
	}
}
