package ezen.springmvc.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



//@AllArgsConstructor //소스(코드)상에는 없지만 컴파일러에 생성자가 만들어진것, 이제부터 만들 필요없음
//@Getter
//@Setter
//@ToString
@Data //저위에 5개 기능을 한번에 해주는 어노테이션, 생산성은 좋지만 가독성은 흠..
@NoArgsConstructor //default생성자
@AllArgsConstructor //생성될때 name,age받을수 있도록 추가해줘야함
public class Member {
	private String id;
	private String password;
	private String name;
	//private String email;
	private int age;
}









