package com.example.lab7.Controller;

import com.example.lab7.Api.ApiResponse;
import com.example.lab7.Model.Student;
import com.example.lab7.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
   private final StudentService studentService;
   @GetMapping("/get")
   public ResponseEntity getAllStudent(){
       ArrayList<Student> students=studentService.getStudent();
       return ResponseEntity.status(200).body(students);
   }
   @PostMapping("/add")
   public ResponseEntity addAllStudent(@RequestBody @Valid Student student, Errors errors){
       if(errors.hasErrors()){
           String message=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(message);
       }
       boolean istrue=studentService.addStudent(student);
       if(istrue){
           return ResponseEntity.status(200).body(new ApiResponse("success"));
       }
       return ResponseEntity.status(404).body(new ApiResponse("The student is already there."));
   }
   @PutMapping("/update/{id}")
public ResponseEntity updateStudent(@PathVariable String id,@RequestBody @Valid Student student,Errors errors){
if(errors.hasErrors()){
    String message=errors.getFieldError().getDefaultMessage();
    return ResponseEntity.status(400).body(message);
}
boolean istrue=studentService.updateStudent(id,student);
if(istrue){
    return ResponseEntity.status(200).body(new ApiResponse("success"));
}
return ResponseEntity.status(404).body(new ApiResponse("The id of Student is not Exist"));

}
@DeleteMapping("/delete/{id}")
 public ResponseEntity deleteStudent(@PathVariable String id){
       boolean istrue=studentService.deleteStudent(id);
       if (istrue){
           return ResponseEntity.status(200).body(new ApiResponse("success"));
       }
       return ResponseEntity.status(400).body(new ApiResponse("The id of Student is not Exist "));
 }
 @GetMapping("getBy")
public ResponseEntity AllStudentByAge(){
       ArrayList<Student>Arraystudents=studentService.StudentByAvarge();
       return ResponseEntity.status(200).body(Arraystudents);
}

@GetMapping("/getByAge/{age}")
    public ResponseEntity getAllByAge(@PathVariable int age){
       ArrayList<Student>studentAge=studentService.StudentByAge(age);
 return ResponseEntity.status(200).body(studentAge);
   }



}
