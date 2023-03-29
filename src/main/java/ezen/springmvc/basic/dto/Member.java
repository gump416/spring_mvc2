package ezen.springmvc.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String id;
	private String password;
	private String name;
	//private String email;
	private int age;
}









