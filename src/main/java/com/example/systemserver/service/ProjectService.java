package com.example.systemserver.service;

import com.example.systemserver.model.*;
import com.example.systemserver.model.Module;
import com.example.systemserver.provider.*;
import jakarta.annotation.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;
import java.util.stream.*;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final List<Project> projects = new ArrayList<>();

    private final List<Module> modules = new ArrayList<>();

    private final List<User> users = new ArrayList<>();

    private final MockDataProvider provider;

    @PostConstruct
    public void init() {
        modules.addAll(provider.getModules());

        users.addAll(provider.getUsers());

        projects.addAll(provider.getProjects());
    }

    public List<Project> getAllProjects() {
        return projects.stream()
            .collect(Collectors.groupingBy(Project::getId))
            .values().stream()
            .map(group -> group.stream()
                .max(Comparator.comparing(project -> LocalDateTime.parse(project.getDate())))
                .orElse(null))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    public List<Project> getProjectsVersions(int id) {
        return projects.stream()
            .filter(project -> project.getId() == id)
            .toList();
    }

    public Optional<Project> getProjectById(int id) {
        return projects.stream()
            .filter(project -> project.getId() == id)
            .max(Comparator.comparing(project ->
                LocalDateTime.parse(project.getDate())));
    }

    public Optional<Module> getModuleById(int id) {
        return modules.stream()
            .filter(project -> project.getId() == id)
            .findFirst();
    }


    public Project addProject(Project project) {
        project.setId(projects.stream().mapToInt(Project::getId).max().orElse(0) + 1);
        projects.add(project);
        return project;
    }

    public List<Module> getAllModules() {
        return modules;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public Integer saveModule(Module module) {
        int newId = modules.stream()
                        .mapToInt(Module::getId)
                        .max()
                        .orElse(0) + 1;

        Module newModule = new Module(
            newId,
            module.getName(),
            module.getLevel(),
            module.getContent()
        );

        modules.add(newModule);
        return newId;
    }

    public void saveProject(Project project) {
        var last = getProjectById(project.getId());

        if (last.isEmpty()) {
            addProject(project);
        } else {
            var newProject = new Project();

            newProject.setId(last.get().getId());
            newProject.setUsers(last.get().getUsers());
            newProject.setModuls(last.get().getModuls());
            newProject.setName(last.get().getName());
            newProject.setPath(last.get().getPath());
            newProject.setOwner(last.get().getOwner());
            newProject.setCommitName(project.getCommitName());
            newProject.setModuls(project.getModuls());
            newProject.setDate(LocalDateTime.now().toString());
            projects.add(newProject);
        }
    }
}