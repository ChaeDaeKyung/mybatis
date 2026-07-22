package day0721;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class CarDomain {
	private String maker, model, carYear, carImg; 
	private int price, cc;
	private Date inputDate;
}// class
