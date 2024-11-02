package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Project;
import com.example.demo.model.User;

public interface ProjectRepository extends JpaRepository<Project, Long>{

	//List<Project>findByOwner(User user);
	List<Project> findByNameContainingAndTeamContains(String partialName,User user);
	
	//@Query("SELECT P From Project p join p.team t where t=:user")
	//List<Project> findProjectByTeam(@Param("user") User user);
	List<Project> findByTeamContainingOrOwner(User user,User owner);
}
