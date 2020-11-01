package com.blackswan.api.service.tests;

import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.blackswan.api.service.services.UserService;
import com.blackswan.test.base.TestBase;
import com.blackswan.utils.data.HeaderProvider;

import comblackswan.api.service.responce.dto.PostsUserDTO;

public class CreateUserAPITest extends TestBase {

	private UserService userService;
	private PostsUserDTO postUserDTO;
	private Map<String, Object> headers;
	private JSONObject body;

	@BeforeClass(alwaysRun = true)
	public void serviceSetUp() throws Exception {

		try {
			userService = new UserService();
			body = getJSONBodyTemplate("CreateUser");
			headers = HeaderProvider.getHeaders("Header1");

		} catch (Exception e) {
			throw e;
		}
	}

	@Test
	public void sendValidPostRequest() {

		postUserDTO = userService.createUser(body, headers);

		Assert.assertEquals(postUserDTO.getStatusCode(), 201);

		Assert.assertEquals(postUserDTO.getName(), body.get("name"));

		Assert.assertEquals(postUserDTO.getUsername(), body.get("username"));

		Assert.assertEquals(postUserDTO.getUsername(), body.get("username"));

		Assert.assertEquals(postUserDTO.getEmail(), body.get("email"));

		Assert.assertEquals(postUserDTO.getPhone(), body.get("phone"));

		Assert.assertEquals(postUserDTO.getPhone(), body.get("phone"));

		Assert.assertEquals(postUserDTO.getWebsite(), body.get("website"));

		Assert.assertEquals(postUserDTO.getAddress().getStreet(), ((JSONObject) body.get("address")).get("street"));

		Assert.assertEquals(postUserDTO.getAddress().getSuite(), ((JSONObject) body.get("address")).get("suite"));

		Assert.assertEquals(postUserDTO.getAddress().getCity(), ((JSONObject) body.get("address")).get("city"));

		Assert.assertEquals(postUserDTO.getAddress().getZipcode(), ((JSONObject) body.get("address")).get("zipcode"));

		Assert.assertEquals(postUserDTO.getAddress().getGeo().getLat(),
				((JSONObject) ((JSONObject) body.get("address")).get("geo")).get("lat"));

		Assert.assertEquals(postUserDTO.getAddress().getGeo().getLng(),
				((JSONObject) ((JSONObject) body.get("address")).get("geo")).get("lng"));

		Assert.assertEquals(postUserDTO.getCompany().getName(), ((JSONObject) body.get("company")).get("name"));

		Assert.assertEquals(postUserDTO.getCompany().getCatchPhrase(),
				((JSONObject) body.get("company")).get("catchPhrase"));

		Assert.assertEquals(postUserDTO.getCompany().getBs(), ((JSONObject) body.get("company")).get("bs"));

	}

}
