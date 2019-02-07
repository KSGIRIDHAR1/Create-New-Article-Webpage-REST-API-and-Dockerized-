package com.cts.newsarticle.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class SignupControllerMockMVCTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignupControllerMockMVCTest.class);
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void signupControllerTest() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{\"name\":\"Giridhar\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"email\":\"giridhar@email.com\"" + "," + "\"password\":\"giridhar\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.signupStatus").value(true));

		LOGGER.info("End: signupControllerTest()");
	}

	@Test
	public void signupControllerTestrForNullObject() throws Exception {

		LOGGER.info("Start: inside signupControllerTestrForNullObject()");
		String TEST_DATA = "{}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError()).andExpect(jsonPath("$.errorMessage").isNotEmpty());
		LOGGER.info("End: signupControllerTestForNullObject()");
	}

	@Test
	public void signupControllerTestForPreExistingEmailId() throws Exception {
		LOGGER.info("Start: inside signupControllerTestForPreExistingEmailId()");
		String TEST_DATA = "{\"name\":\"Giridhar\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"email\":\"giridhar@gmail.com\"" + "," + "\"password\":\"giridhar\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk());
		LOGGER.info("End: signupControllerTestForPreExistingEmailId()");
	}

	@Test
	public void signupControllerTestForNullName() throws Exception {

		LOGGER.info("Start: inside signupControllerTestrForNullName()");

		String TEST_DATA = "{\"password\":\"giridhar\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"email\":\"giridhar@gmail.com\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Invalid input format: Username cannot be null"));
		;
		LOGGER.info("End: signupControllerTestForNullName()");
	}

	@Test
	public void signupControllerTestForNullPassword() throws Exception {

		LOGGER.info("Start: inside testUserControllerForNullPassword()");
		String TEST_DATA = "{\"name\":\"giridhar\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"email\":\"giridhar@gmail.com\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Invalid input format: Password cannot be null"));
		;
		LOGGER.info("End: signupControllerTestForNullPassword()");
	}

	@Test
	public void signupControllerTestForNullEmail() throws Exception {

		LOGGER.info("Start: inside signupControllerTestForNullEmail()");
		String TEST_DATA = "{\"name\":\"giridhar\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"password\":\"giridhar\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Invalid input format: Email cannot be null"));
		;
		LOGGER.info("End: signupControllerTestForNullEmail()");
	}

	@Test
	public void signupControllerTestInvalidPasswordFormat() throws Exception {

		LOGGER.info("Start: inside signupControllerTestForNullPassword()");

		String TEST_DATA = "{\"name\":\"giridhar\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"email\":\"giridhar@gmail.com\"" + "," + "\"password\":\"giri\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError()).andExpect(
						jsonPath("$.errorMessage").value("Invalid input format: Password must be 6 to 50 characters"));
		;
		LOGGER.info("End: signupControllerTestForPasswordSize()");
	}

	@Test
	public void signupControllerTestForInvalidNameFormat() throws Exception {

		LOGGER.info("Start: inside testUserControllerForNameSize()");

		String TEST_DATA = "{\"name\":\"gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg\""
				+ "," + "\"language\":{\"id\":\"1\"}" + "," + "\"email\":\"giridhar@gmail.com\"" + ","
				+ "\"password\":\"giridhar\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError());
	}

	@Test
	public void testUserControllerInvalidEmailFormat() throws Exception {

		LOGGER.info("Start: inside signupControllerTestForEmailSize()");
		String TEST_DATA = "{\"name\":\"giridhar\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"email\":\"ghghghghghghghghghghghghghghghghghghffffffffffffffffjjjjjjjzfszfszdfdgxdgdzfszffsbcdzhjbsfyusgfuysgfusfjzhbchjbsfsfhsufhjncisfosjckzmdfijsfisdjfiodgfodjgidjgidjihdgfihdgihdfvndiisojdsfuihsdguindksnfiosiofnksfyusgfyusfbcshbcsybfyusfbyusbchzbcshyfbyusfbyusfbcshbcfbcyusfbgyusfbyusfyusfscbshfbsyfysfsbsfbsfbyuffbsfyufsfbzhfbsfyusfzhbfuszfuyfzfbgddghudghudghudhgusfhjnhjnbhqwdasdcxzcasdasdgfhdbfsgfdhsfsdfsdf@gmail.com\""
				+ "," + "\"password\":\"giridhar\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError()).andExpect(
						jsonPath("$.errorMessage").value("Invalid input format: Email must not exceed 255 characters"));
		LOGGER.info("End: signupControllerTestForEmailSize()");
	}

	@Test
	public void signupControllerTestForEmailPattern() throws Exception {

		LOGGER.info("Start: inside testUserControllerForEmailPattern()");
		String TEST_DATA = "{\"name\":\"giridhar\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"giridhar\"" + "," + "\"password\":\"giridhar\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Invalid input format: Email address is invalid"));
		LOGGER.info("End: signupControllerTestForEmailPattern()");
	}

}
