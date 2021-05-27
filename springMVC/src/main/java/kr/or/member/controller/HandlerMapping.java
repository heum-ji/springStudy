package kr.or.member.controller;

import java.util.HashMap;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;

	public HandlerMapping() {
		super();
		mappings = new HashMap<String, Controller>();
		mappings.put("/search.do", new SearchMember());
		mappings.put("/login.do", new LoginMember());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
	
}