package day0721;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class BoardDomain {
	private int num, cnt;
	private String id, title, content, upfile, ip;	
	private Date inputDate;
}// class
