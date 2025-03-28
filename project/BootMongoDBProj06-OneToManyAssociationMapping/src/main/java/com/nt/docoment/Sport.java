package com.nt.docoment;

import java.util.Arrays;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "Sport_Info")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sport {
	
	@Id
	private Integer sid;
	private String sname;
	private String[] kitItems;
	@Override
	public String toString() {
		return "Sport [sid=" + sid + ", sname=" + sname + ", kitItems=" + Arrays.toString(kitItems) + "]";
	}
	
	
	
	
	
	

}
