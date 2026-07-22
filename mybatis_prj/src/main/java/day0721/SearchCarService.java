package day0721;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SearchCarService {

	private static SearchCarService scs;
	private SearchCarService() {}
	
	public static SearchCarService getInstance() {
		if(scs == null) {
			scs = new SearchCarService();
		}// end if
		return scs;
	}//getInstance
	
	public JSONObject searchMaker(String country) {
		JSONObject jsonObj = new JSONObject();
		//{ resuletFlag:true||false, data:[{maker:"현대"},{maker:"기아"}],,, }
		SelectDAO4 sDAO = SelectDAO4.getInstance();
		jsonObj.put("result", false);
		try {
			List<String> listMaker = sDAO.selectMaker(country);
			//부가적인 정보 생성
			jsonObj.put("result", true);
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonObjMaker = null;
			for(String maker : listMaker) {
				jsonObjMaker = new JSONObject();
				//검색결과를 사용하여 JSONObject 생성
				jsonObjMaker.put("maker", maker);
				//생성된 JSONObject을 JSONArray 에 할당
				jsonArr.add(jsonObjMaker);
			}// end for
			jsonObj.put("data", jsonArr);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return jsonObj;
	}//searchMaker
	
	public JSONObject searchModel(String maker) {
		JSONObject jsonObj = new JSONObject();
		//{ resuletFlag:true||false, data:[{model:"아반테"},{model:"그랜저"}],,, }
		SelectDAO4 sDAO = SelectDAO4.getInstance();
		jsonObj.put("result", false);
		try {
			List<String> listModel = sDAO.selectModel(maker);
			//부가적인 정보 생성
			jsonObj.put("result", true);
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonObjModel = null;
			for(String model : listModel) {
				jsonObjModel = new JSONObject();
				//검색결과를 사용하여 JSONObject 생성
				jsonObjModel.put("model", model);
				//생성된 JSONObject을 JSONArray 에 할당
				jsonArr.add(jsonObjModel);
			}// end for
			jsonObj.put("data", jsonArr);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return jsonObj;
	}//searchModel
	
	public JSONObject searchCar(String model) {
		JSONObject jsonObj = new JSONObject();
		//{ resuletFlag:true||false, data:[{maker:"현대",model:"아반테",car_year:2012,cc:1500,car_img:"test.jpg",input_date:"2026-01-01"},,, }
		SelectDAO4 sDAO = SelectDAO4.getInstance();
		jsonObj.put("result", false);
		try {
			List<CarDomain> listCar = sDAO.selectCar(model);
			//부가적인 정보 생성
			jsonObj.put("result", true);
			jsonObj.put("searchLength", listCar.size());
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonObjCar = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd EEEE");
			for(CarDomain car : listCar) {
				jsonObjCar = new JSONObject();
				//검색결과를 사용하여 JSONObject 생성
				jsonObjCar.put("maker", car.getMaker());
				jsonObjCar.put("model", car.getModel());
				jsonObjCar.put("car_year", car.getCarYear());
				jsonObjCar.put("price", car.getPrice());
				jsonObjCar.put("cc", car.getCc());
				jsonObjCar.put("car_img", car.getCarImg());
				//날짜가 출력 되면 에러 발생
				//날짜는 문자열로 변환하여 jsonObj를 생성해야 한다.
				jsonObjCar.put("input_date", sdf.format(car.getInputDate()));
				//생성된 JSONObject을 JSONArray 에 할당
				jsonArr.add(jsonObjCar);
			}// end for
			jsonObj.put("data", jsonArr);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return jsonObj;
	}//searchCar
	
}// class
