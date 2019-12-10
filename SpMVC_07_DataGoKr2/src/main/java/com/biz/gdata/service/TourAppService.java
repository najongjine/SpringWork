package com.biz.gdata.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.gdata.config.DataGoConfig;
import com.biz.gdata.domain.AreaBaseDTO;
import com.biz.gdata.domain.CityVO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TourAppService {
	@Autowired
	TourGetService tgService;

	private String getHeaderQuery(String servName) throws UnsupportedEncodingException {
		String queryString = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/" + servName;
		queryString += "?ServiceKey=" + DataGoConfig.goDataAuth;
		queryString += "&MobileApp=" + URLEncoder.encode(DataGoConfig.MY_APP_NAME, "UTF-8");
		queryString += "&_type=json";
		queryString += "&MobileOS=ETC";

		queryString += String.format("&numOfRows=%d", 20);
		queryString += String.format("&pageNo=%d", 1);

		return queryString;
	}

	//시 도 리스트를 가져오는 query 문자열
	public String getAreaQuery() throws UnsupportedEncodingException {
		String queryString = getHeaderQuery("areaCode");

		return queryString;
	}// end

	//시 도 리스트를 가져오는 query문자열 + 시군구 리스트를 가져오는 문자열 추가
	public String getAreaQuery(String cityCode) throws UnsupportedEncodingException {
		String queryString = getHeaderQuery("areaCode");
		queryString += "&areaCode=" + cityCode;

		return queryString;
	}// end

	//controller에서 호출
	//city 코드가 없이 실행되는 코드
	//시 도 리스트를 추출하도록
	public List<CityVO> getAreaData() throws JsonSyntaxException, IOException {
		return getAreaData(null);
	}

	//controller에서 호출
	//시 도 리스트를 선택했을때 호출
	//city 코드가 있으면 시군구 리스트를 추출하도록
	public List<CityVO> getAreaData(String cityCode) throws JsonSyntaxException, IOException {
		// 이 클래스에서 만든 query 문자열을 tgService의 getDataString()에 보내서
		// 데이터 조회를 하는 method
		String resString = "";
		if (cityCode == null) {
			resString=tgService.getDataString(getAreaQuery());
		} else {
			resString=tgService.getDataString(getAreaQuery(cityCode));
		}

		// JSONParser jParser=new JSONParser();
		JsonElement jElement = JsonParser.parseString(resString);

		// response tag
		JsonObject oRes = (JsonObject) jElement.getAsJsonObject().get("response");

		// response.body
		JsonObject oBody = (JsonObject) oRes.getAsJsonObject().get("body");

		// response.body.items
		JsonObject oItems = (JsonObject) oBody.getAsJsonObject().get("items");

		// response.body.items.item
		JsonArray oitemList = (JsonArray) oItems.getAsJsonObject().get("item");

		// gson에 있는 class
		// JsonArray 데이터를 List형 데이터로 변환하는 도구
		// 1. JsonArray를 List형으로 변환하기 위한 변환 바구니를 생성
		// 2. gson을 이용하여 List 형으로 변환
		TypeToken<List<CityVO>> cityToken = new TypeToken<List<CityVO>>() {
		};

		// token 도구를 사용하여 List<Class> 형으로 변환하는 method 호출
		Gson gson = new Gson();
		List<CityVO> cityList = gson.fromJson(oitemList, cityToken.getType());
		return cityList;
	}// end

	public String getAreaBaseQuery(String cityCode) throws UnsupportedEncodingException {
		return getAreaBaseQuery(cityCode, null);
	}
	//지역의 관광정보를 가져오기 위한 method
	public String getAreaBaseQuery(String cityCode,String sigun) throws UnsupportedEncodingException {
		String queryString = getHeaderQuery("areaBasedList");
		queryString += "&arrange=A";
		queryString += "&contentTypeId=15";
		queryString += String.format("&areaCode=%s", cityCode);
		// queryString += String.format("&sigunguCode=%s",cityCode);
		queryString += "&listYN=Y";
		if(sigun!=null) {
			queryString+="&sigunguCode="+sigun;
		}
		return queryString;
	}// end

	public List<AreaBaseDTO> getAreaBaseListData(String cityCode,String sigun) throws JsonSyntaxException, IOException {
		String resString = tgService.getDataString(getAreaBaseQuery(cityCode,sigun));

		log.debug(resString);
		// JSONParser jParser=new JSONParser();
		JsonElement jElement = JsonParser.parseString(resString);

		// response tag
		JsonObject oRes = (JsonObject) jElement.getAsJsonObject().get("response");

		// response.body
		JsonObject oBody = (JsonObject) oRes.getAsJsonObject().get("body");

		// response.body.items
		JsonObject oItems = (JsonObject) oBody.getAsJsonObject().get("items");

		// response.body.items.item
		JsonArray oitemList = (JsonArray) oItems.getAsJsonObject().get("item");

		// gson에 있는 class
		// JsonArray 데이터를 List형 데이터로 변환하는 도구
		// 1. JsonArray를 List형으로 변환하기 위한 변환 바구니를 생성
		// 2. gson을 이용하여 List 형으로 변환
		TypeToken<List<AreaBaseDTO>> cityToken = new TypeToken<List<AreaBaseDTO>>() {
		};

		// token 도구를 사용하여 List<Class> 형으로 변환하는 method 호출
		Gson gson = new Gson();
		List<AreaBaseDTO> baseList = gson.fromJson(oitemList, cityToken.getType());
		return baseList;
	}// end
}
