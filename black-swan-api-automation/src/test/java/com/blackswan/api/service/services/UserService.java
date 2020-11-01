package com.blackswan.api.service.services;

import com.blackswan.api.constants.RelativeURLs;
import com.blackswan.utils.data.Config;
import com.blackswan.utils.rest.APIServicesBase;
import com.blackswan.utils.rest.RestUtil;

import comblackswan.api.service.responce.dto.PostsUserDTO;
import io.restassured.response.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Map;

public class UserService extends APIServicesBase {

	private PostsUserDTO postsDTO;
	private PostsUserDTO[] postsListDTO;
	private String baseURI;
	private String serviceType;

	public UserService() {
		this.baseURI = Config.getProperty("service.host");
		this.serviceType = Config.getProperty("service.type");
	}

	public PostsUserDTO createUser(JSONObject body, Map<String, Object> headers) {

		try {
			// Make Request
			Response response = postRequest(body, headers, baseURI, RelativeURLs.CREATE_USER);

			if (response.statusCode() == 201)
				postsDTO = objectMapper.readValue(response.asString(), PostsUserDTO.class);
			else
				postsDTO = new PostsUserDTO();

			postsDTO.setResponse(response);

			// Clear Base Path
			RestUtil.resetBasePath();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return postsDTO;

	}

	public PostsUserDTO updateUser(JSONObject body, Map<String, Object> headers, String id) {

		try {
			// Make Request
			Response response = putRequest(body, headers, baseURI, RelativeURLs.UPDATE_USER.replace("{id}", id));

			if (response.statusCode() == 200)
				postsDTO = objectMapper.readValue(response.asString(), PostsUserDTO.class);
			else
				postsDTO = new PostsUserDTO();

			postsDTO.setResponse(response);

			// Clear Base Path
			RestUtil.resetBasePath();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return postsDTO;

	}

	public PostsUserDTO[] getAllUsers(Map<String, Object> headers) {

		Response response = null;

		try {
			// Make Request
			response = getRequest(headers, baseURI, RelativeURLs.GET_USER);

			if (response.statusCode() == 200)
				postsListDTO = objectMapper.readValue(response.asString(), PostsUserDTO[].class);
			else {
				postsListDTO = new PostsUserDTO[((JSONArray) response.getBody()).size()];

			}

			for (int i = 0; i < postsListDTO.length; i++) {
				postsListDTO[i].setResponse(response);
			}
			// Clear Base Path
			RestUtil.resetBasePath();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return postsListDTO;

	}

}