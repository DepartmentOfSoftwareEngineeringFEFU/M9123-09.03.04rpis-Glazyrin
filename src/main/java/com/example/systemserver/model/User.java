package com.example.systemserver.model;

import java.io.*;

import lombok.*;

@Data
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String name;
    private String login;
    private String password;
    private String picture;

}