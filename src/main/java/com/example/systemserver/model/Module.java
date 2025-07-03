package com.example.systemserver.model;

import java.io.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Module implements Serializable {
    private Integer id;
    private String name;
    private Integer level;
    private String content;

    public Module(String name, Integer level, String content) {
        this.name = name;
        this.level = level;
        this.content = content;
    }

}