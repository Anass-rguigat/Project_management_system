package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Chat;
import com.example.demo.model.Project;
import com.example.demo.model.User;
import com.example.demo.responses.MessageResponse;
import com.example.demo.services.ProjectService;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<Project>>getProjects(@RequestParam(required=false) String category, @RequestParam(required=false) String tag,@RequestHeader("Authorization") String jwt  ) throws Exception{
		 User user = userService.findUerProfileByJwt(jwt);
		 List<Project> projects= projectService.getProjectByTeam(user,category,tag);
		return new ResponseEntity(projects, HttpStatus.OK);
	}
	@GetMapping("/{projectId}")
	public ResponseEntity<Project>getProjectById(@PathVariable Long projectId, @RequestHeader("Authorization") String jwt  ) throws Exception{
		 User user = userService.findUerProfileByJwt(jwt);
		 Project project= projectService.getProjectById(projectId);
		return new ResponseEntity(project, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Project>createProject(@RequestHeader("Authorization") String jwt, @RequestBody Project project  ) throws Exception{
		 User user = userService.findUerProfileByJwt(jwt);
		 Project createdproject= projectService.createProject(project,user);
		return new ResponseEntity(createdproject, HttpStatus.OK);
	}
	@PatchMapping("/{projectId}")
	public ResponseEntity<Project>updateProject(@PathVariable Long projectId, @RequestHeader("Authorization") String jwt, @RequestBody Project project  ) throws Exception{
		 User user = userService.findUerProfileByJwt(jwt);
		 Project updatedproject= projectService.updateProject(project,projectId);
		return new ResponseEntity(updatedproject, HttpStatus.OK);
	}
	@DeleteMapping("/{projectId}")
	public ResponseEntity<MessageResponse>deleteProject(@PathVariable Long projectId, @RequestHeader("Authorization") String jwt) throws Exception{
		 User user = userService.findUerProfileByJwt(jwt);
		 projectService.deleteProject(projectId,user.getId());
		 MessageResponse res = new MessageResponse("Project deleted successfully");
		return new ResponseEntity(res, HttpStatus.OK);
	}
	@GetMapping("/search ")
	public ResponseEntity<List<Project>>searchProjects(@RequestParam(required=false) String keyword,@RequestHeader("Authorization") String jwt  ) throws Exception{
		 User user = userService.findUerProfileByJwt(jwt);
		 List<Project> projects= projectService.searchProjects(keyword,user);
		return new ResponseEntity(projects, HttpStatus.OK);
	}
	@GetMapping("/{projectId}/chat")
	public ResponseEntity<Chat>getChatByProjectId(@PathVariable Long projectId, @RequestHeader("Authorization") String jwt  ) throws Exception{
		 User user = userService.findUerProfileByJwt(jwt);
		 Chat chat= projectService.getChatByProjectId(projectId);
		return new ResponseEntity(chat, HttpStatus.OK);
	}
}
