package com.example.day3sms.Service;

import com.example.day3sms.Model.StudentModel;
import com.example.day3sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {

        this.repository = repository;
    }

    //create
    public StudentModel addStudent(StudentModel student){

        return repository.save(student);
    }

    //Display student
    public List<StudentModel> getStudents(){
        return repository.findAll();
    }

    //update
    public StudentModel updateStudent(String id,StudentModel student){
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student found"));

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());

        return repository.save(existingStudent);
    }
    public StudentModel deleteStudent(String id){
        StudentModel student = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("no student found"));

        repository.deleteById(id);
        return student;
    }


}
