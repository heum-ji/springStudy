package kr.or.tv.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.member.Member;
import kr.or.member.MemberMgr;

/**
 * Servlet implementation class Dependency2Servlet
 */
public class Dependency2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dependency2Servlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// xml 읽어오기
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("memberContext.xml");
		// getBean(id / type)
		Member member = cntx.getBean("m1", Member.class);
		MemberMgr mm2 = cntx.getBean("mm2", MemberMgr.class);

		System.out.println(member.getName());
		System.out.println(mm2.getM().getName());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
