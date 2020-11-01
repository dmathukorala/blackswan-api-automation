package com.blackswan.api.service.tests;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blackswan.api.service.services.UserService;
import com.blackswan.test.base.TestBase;
import com.blackswan.utils.data.HeaderProvider;

import comblackswan.api.service.responce.dto.PostsUserDTO;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetUserAPITest extends TestBase {

	private UserService userService;
	private Map<String, Object> headers;

	@BeforeClass(alwaysRun = true)
	public void serviceSetUp() throws Exception {

		try {
			userService = new UserService();
			headers = HeaderProvider.getHeaders("Header1");

		} catch (Exception e) {
			throw e;
		}
	}

	@Test
	public void sendValidFilterPostRequest() {

		PostsUserDTO[] userList = userService.getAllUsers(headers);

		for (PostsUserDTO user : userList) {

			Assert.assertEquals(user.getStatusCode(), 200);

			Assert.assertNotNull(user.getId());

			Assert.assertNotNull(user.getName());

			Assert.assertNotNull(user.getUsername());

			Assert.assertNotNull(user.getEmail());

			Assert.assertNotNull(user.getPhone());

			Assert.assertNotNull(user.getPhone());

			Assert.assertNotNull(user.getWebsite());

			Assert.assertNotNull(user.getAddress().getStreet());

			Assert.assertNotNull(user.getAddress().getSuite());

			Assert.assertNotNull(user.getAddress().getCity());

			Assert.assertNotNull(user.getAddress().getZipcode());

			Assert.assertNotNull(user.getAddress().getGeo().getLat());

			Assert.assertNotNull(user.getAddress().getGeo().getLng());

			Assert.assertNotNull(user.getCompany().getName());

			Assert.assertNotNull(user.getCompany().getCatchPhrase());

			Assert.assertNotNull(user.getCompany().getBs());
		}

	}

}
