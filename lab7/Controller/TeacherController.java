package com.example.lab7.Controller;

import com.example.lab72.Api.ApiResponse;
import com.example.lab72.Model.Teacher;
import com.example.lab72.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/get")
    public ResponseEntity getAllTeacher(){
        ArrayList<Teacher>teachers=teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers);
    }
    @PostMapping("/add")
    public ResponseEntity addAllTeacher(@RequestBody @Valid Teacher teacher, Errors errors){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean istrue=teacherService.addTeacher(teacher);
        if(istrue){
            return ResponseEntity.status(200).body(new ApiResponse("success"));
        }

        return ResponseEntity.status(404).body(new ApiResponse("The teacher is Al-ready there"));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable String id, @RequestBody @Valid Teacher teacher,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean istrue=teacherService.updateTeacher(id,teacher);
        if(istrue){
            return ResponseEntity.status(200).body(new ApiResponse("success"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("The id of teacher id not Exist"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id){
        boolean istrue=teacherService.deleteTeacher(id);
        if(istrue){
            return ResponseEntity.status(200).body(new ApiResponse("success"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("The id of Teacher is not Exist"));
    }
@GetMapping("/getBy/{Experience}")
    public ResponseEntity getByYearsOfExperience(@PathVariable int Experience){
        ArrayList<Teacher> Arrayteachers=teacherService.getTeacherOfExsperience(Experience);
        if(Arrayteachers==null){
            return ResponseEntity.status(400).body(new ApiResponse("There is no employee with more than 5 years of experience."));
        }
        return ResponseEntity.status(200).body(Arrayteachers);
}
    @PutMapping("/salary/{id}/{amount}")
    public ResponseEntity addSalaryPoint(@PathVariable String id,@PathVariable int amount){
        boolean istrue=teacherService.salaryPoint(id,amount);
        if(istrue){
        return ResponseEntity.status(200).body(new ApiResponse("success"));}
        return ResponseEntity.status(200).body(new ApiResponse("the id of teacher not Exist"));
    }

}
