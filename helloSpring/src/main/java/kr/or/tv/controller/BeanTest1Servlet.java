package kr.or.tv.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.member.TestData;

/**
 * Servlet implementation class BeanTest1Servlet
 */
public class BeanTest1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BeanTest1Servlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("testContext.xml");
		TestData data = cntx.getBean("data", TestData.class);

		System.out.println(data.getData()); // 100

		data.setData(data.getData() + 1);
		System.out.println(data.getData()); // 101

		TestData data1 = cntx.getBean("data", TestData.class);
		System.out.println("재사용? : " + data1.getData()); // 101 - default : 재사용

		cntx.close();
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
