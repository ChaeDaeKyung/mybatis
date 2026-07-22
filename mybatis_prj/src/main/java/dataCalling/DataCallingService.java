package dataCalling;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DataCallingService {

	private static DataCallingService dcs;
	private DataCallingService() {
	}
	
	public static DataCallingService getInstance() {
		
		if(dcs == null) {
			dcs = new DataCallingService();
		}// end if
		
		return dcs;
	}// getInstancse
	
	public String getKey() {
		String myKey = "ceff4a7504433bce8e4c7813de6dd3c739dfbdaa267c70afc132a0c7e0fff968";
		String serviceKey = "";
		try {
			serviceKey = URLEncoder.encode(myKey, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return serviceKey;
	}// getKey
	
}//class
