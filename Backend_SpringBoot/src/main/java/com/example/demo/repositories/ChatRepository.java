package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long>{

}
