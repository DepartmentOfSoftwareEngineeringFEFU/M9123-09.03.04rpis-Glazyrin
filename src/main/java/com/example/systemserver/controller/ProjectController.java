package com.example.systemserver.controller;

import com.example.systemserver.model.*;
import com.example.systemserver.model.Module;
import com.example.systemserver.service.ProjectService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/modules")
    public Integer createModule(@RequestBody Module module) {
        return projectService.saveModule(module);
    }

    @PostMapping("/project")
    public void saveProject(@RequestBody Project project) {
        projectService.saveProject(project);
    }

    @GetMapping("/modules")
    public List<Module> getModules() {
        return projectService.getAllModules();
    }

    @GetMapping("/modules/{id}")
    public Optional<Module> getModuleById(@PathVariable int id) {
        return projectService.getModuleById(id);
    }

    @GetMapping("/projects")
    public List<Project> getProjects() {
        return projectService.getAllProjects();
    }

//    @GetMapping("/projects")
//    public void postProjects(@RequestBody SavedProject savedProject) {
//        return projectService;
//    }

    @GetMapping("/projects/{id}")
    public Optional<Project> getProjectById(@PathVariable int id) {
        return projectService.getProjectById(id);
    }

    @GetMapping("/projects/{id}/versions")
    public List<Project> getProjectVersionsById(@PathVariable int id) {
        return projectService.getProjectsVersions(id);
    }

    @PostMapping("/projects")
    public Project addProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return projectService.getAllUsers();
    }


}