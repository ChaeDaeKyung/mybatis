package day0715;

import java.security.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class NewsDTO {
	private int num;
	private String subject,	newsContent, writer;
	private Timestamp inputDate;
}
