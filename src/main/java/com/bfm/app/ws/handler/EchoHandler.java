package com.bfm.app.ws.handler;

import java.io.IOException;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.ConcurrentWebSocketSessionDecorator;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws IOException {
		TextMessage message = new TextMessage("Connection established");
		concurrentSession(session).sendMessage(message);	
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String msg = message.getPayload();
		TextMessage msg2 = new TextMessage("Recieved : "+msg);
		concurrentSession(session).sendMessage(msg2);
	}
	
	ConcurrentWebSocketSessionDecorator concurrentSession(WebSocketSession session) {
		 return new ConcurrentWebSocketSessionDecorator(session, 1000, 1024);
	}

}
