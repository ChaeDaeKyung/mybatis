package day0715;

import org.apache.ibatis.exceptions.PersistenceException;

public class UseMapperService {

	
	
	
	public static void main(String[] args) {
		UseMapperDAO umDAO = UseMapperDAO.getInstance();
		
		try {
			umDAO.insertNotParameter();
		} catch(PersistenceException pe) {
			System.out.println("====================예외 발생=====================");
			pe.printStackTrace();
		}// end try catch
	}

}// class
