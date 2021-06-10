package kr.or.dm.model.vo;

import lombok.Data;

@Data
public class Dm {
	private int dmNo;
	private String sender;
	private String receiver;
	private String dmContent;
	private String dmTime;
	private String readStatus;
	
	public String getReadStatus() {
		if(readStatus.equals("Y")) {
			return "읽음";
		} else {
			return "읽지 않음";
		}
	}
}