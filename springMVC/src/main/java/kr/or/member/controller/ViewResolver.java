package kr.or.member.controller;

public class ViewResolver {
	
	public String getView(String viewName) {
		return "/views/" + viewName + ".jsp";
	}
}
