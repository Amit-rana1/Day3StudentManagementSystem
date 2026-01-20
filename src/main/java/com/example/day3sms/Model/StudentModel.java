package com.example.day3sms.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Data //auto getter and setter function
@AllArgsConstructor  //make constructor auto
@NoArgsConstructor
@Document(collation = "students")
public class StudentModel {
    @Id //primary key
    private String id;

    private String name;
    private int age;
    private String email;
}
