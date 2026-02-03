package com.example.day3sms.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

//@Data //auto getter and setter function(it create all type of method tostinnf hexcode which is not needed
@Getter
@Setter
@AllArgsConstructor  //make constructor auto
@NoArgsConstructor
@Document(collection = "students")
public class StudentModel {
    @Id //primary key
    private String id;

    private String name;
    private int age;
    private String email;
}
