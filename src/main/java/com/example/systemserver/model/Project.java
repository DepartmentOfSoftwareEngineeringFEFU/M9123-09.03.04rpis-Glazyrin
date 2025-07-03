package com.example.systemserver.model;

import lombok.*;

import java.io.*;
import java.time.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project implements Serializable {
    private Integer id;
    private String name;
    private List<User> users;
    private String owner;
    private String date;
    private String path;
    private List<Integer> moduls;
    private String commitName;

    public Project(
        Integer id,
        String name,
        List<User> users,
        String owner,
        List<Integer> moduls
    ) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.date = LocalDateTime.now().toString();
        this.owner = owner;
        this.path = "\\View\\Images\\roles\\roleOwnerIcon.png";
        this.moduls = moduls;
    }

}
