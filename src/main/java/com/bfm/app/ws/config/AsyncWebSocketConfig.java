/**
 * 
 */
package com.bfm.app.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.bfm.app.ws.handler.EchoHandler;

/**
 * @author rohsi
 *
 */
@Configuration
@EnableWebSocket
public class AsyncWebSocketConfig implements WebSocketConfigurer {
	
	@Bean
	public EchoHandler echoHandler() {
		return new EchoHandler();
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(echoHandler(), "/echo")
			.addInterceptors(new HttpSessionHandshakeInterceptor());
	}
	
	

}
