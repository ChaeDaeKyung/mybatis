package day0723;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class WebMemberDTO {
	
	private String id,	password,	name,	email,	phone,	zipcode,	
					address,	address2,	profile,	
					ip,	smsreceiveyn,	emailreceiveyn,	cesession;
	private Date inputdate;
	
}//class
