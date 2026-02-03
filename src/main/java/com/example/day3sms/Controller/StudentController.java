package com.example.day3sms.Controller;

import com.example.day3sms.DTO.StudentRequestDto;
import com.example.day3sms.DTO.StudentResponseDto;
import com.example.day3sms.Model.StudentModel;
import com.example.day3sms.Service.StudentService;
import jakarta.validation.Valid;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {

        this.service = service;
    }

    //create function API

    @PostMapping("/add-student")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student){

        return service.addStudent(student);
    }

    //Display Students
    @GetMapping("/students")
    public List<StudentResponseDto> getStudents(){
        return service.getStudents();
    }

    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(@PathVariable String id,@RequestBody StudentRequestDto dto){
        return service.updateStudent(id,dto);
    }
    @DeleteMapping("/delete/{id}")
    public StudentResponseDto deleteStudent(@PathVariable String id){
        return service.deleteStudent(id);
    }
}
