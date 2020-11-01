package comblackswan.api.service.responce.dto;

import com.blackswan.test.base.BaseResponseDTO;

public class GeoDTO extends BaseResponseDTO {

	private String lat;
	private String lng;

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

}
