package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Issue;
import com.example.demo.model.User;
import com.example.demo.requests.IssueRequest;

public interface IssueService {

	Issue getIssueById(Long issueId) throws Exception;
	List<Issue> getIssueByProjectId(Long projectId) throws Exception;
	Issue createIssue(IssueRequest issue,User user) throws Exception, Exception;
	void deleteIssue(Long issueId, Long userid) throws Exception;
	Issue addUserToIssue(Long issueId, Long userId) throws Exception;
	Issue updateStatus(Long issueId,String status)throws Exception;
}
