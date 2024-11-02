package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.model.Chat;
import com.example.demo.repositories.ChatRepository;

@Service
public class ChatServiceImpl implements ChatService{

	private ChatRepository chatRepository;
	@Override
	public Chat createdChat(Chat chat) {
		return chatRepository.save(chat);
	}

}
