package com.example.day3sms.Service;

import com.example.day3sms.DTO.StudentRequestDto;
import com.example.day3sms.DTO.StudentResponseDto;
import com.example.day3sms.Exception.StudentNotFoundException;
import com.example.day3sms.Model.StudentModel;
import com.example.day3sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {

        this.repository = repository;
    }

    //create
//    public StudentModel addStudent(StudentModel student){
//
//        return repository.save(student);
//    }

    public StudentResponseDto addStudent(StudentRequestDto dto){
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved = repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }
    //Display student
//    public List<StudentModel> getStudents(){
//        return repository.findAll();
//    }

    public List<StudentResponseDto> getStudents(){

        return repository.findAll()
                .stream()
                .map(s -> new StudentResponseDto(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getEmail()

                )).toList();
    }

    //update
    public StudentResponseDto updateStudent(String id, StudentRequestDto dto) {

        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("No Student found"));

        existingStudent.setName(dto.getName());
        existingStudent.setAge(dto.getAge());
        existingStudent.setEmail(dto.getEmail());

        StudentModel updated = repository.save(existingStudent);

        return new StudentResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }
    public StudentResponseDto deleteStudent(String id){
        StudentModel student = repository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("no student found"));

        repository.deleteById(id);
        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail()
        );
    }


}
