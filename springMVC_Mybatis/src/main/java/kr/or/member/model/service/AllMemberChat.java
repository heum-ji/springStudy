package kr.or.member.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class AllMemberChat extends TextWebSocketHandler {
	// 접속한 회원의 세션을 저장하는 리스트
	private ArrayList<WebSocketSession> sessionList;
	// 각 세션별로 접속한 회원의 아이디를 저장하는 map
	private HashMap<WebSocketSession, String> memberList;

	public AllMemberChat() {
		super();
		sessionList = new ArrayList<WebSocketSession>();
		memberList = new HashMap<WebSocketSession, String>();
	}

	// 클라이언트가 최초로 웹소켓 서버에 접속 했을 때
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("클라이언트가 접속함");
		// 새로 접속한 클라이언트의 웹 소켓 세션을 리스트에 추가
		sessionList.add(session);
	}

	// 클라이언트가 서버로 메시지를 전송 했을 때 ( 실제 웹 소켓 로직 구현 )
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// jsp에서 웹 소켓을 통해 보내준 메시지 값(문자열) 확인
		System.out.println(message.getPayload());

		TextMessage tm = new TextMessage("<div class='chat left'>" + message.getPayload() + "</div>");

		// 접속한 세션에 메세지 전송
		session.sendMessage(tm);
	}

	// 클라이언트가 연결을 끊을 때
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 접속이 끊긴 세션을 리스트에서 제거
		sessionList.remove(session);
	}

}