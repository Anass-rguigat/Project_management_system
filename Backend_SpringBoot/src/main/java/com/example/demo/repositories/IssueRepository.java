package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Issue;

public interface IssueRepository extends JpaRepository<Issue , Long> {

	public List<Issue>findByProjectId(Long id);
}
