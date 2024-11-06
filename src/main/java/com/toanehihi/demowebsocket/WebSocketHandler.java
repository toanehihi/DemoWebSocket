package com.toanehihi.demowebsocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("WebSocket đã được thiết lập" + session.getId());
        session.sendMessage(new TextMessage("Chào mừng bạn đến với WebSocket server!"));
    }
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Nhận tin nhắn từ client: " + message.getPayload());
        session.sendMessage(new TextMessage("Server đã nhận được: " + message.getPayload()));
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("Kết nối WebSocket đã đóng: " + session.getId());
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("Có lỗi trong kết nối WebSocket: " + exception.getMessage());
    }
}
