package com.edu.dto;

import lombok.Data;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
@Data
@ToString(exclude= {"val3"})
public class SampleDTO {
	
	private String val1;
	private String val2;
	private String val3;
	
	/*
	public String getVal1() {
		return val1;
	}
	public void setVal1(String val1) {
		this.val1 = val1;
	}
	public String getVal2() {
		return val2;
	}
	public void setVal2(String val2) {
		this.val2 = val2;
	}
	public String getVal3() {
		return val3;
	}
	public void setVal3(String val3) {
		this.val3 = val3;
	}
	@Override
	public String toString() {
		return "SampleDTO [val1=" + val1 + ", val2=" + val2 + ", val3=" + val3 + "]";
	}
*/	

}
