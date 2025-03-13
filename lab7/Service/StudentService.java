package com.example.lab7.Service;

import com.example.lab7.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students=new ArrayList<>();
    public ArrayList<Student> getStudent(){
            return students;}

    public boolean addStudent(Student student){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId().equals(student.getId())){
                return false;
            }
        }
        students.add(student);
        return true;
    }
public boolean updateStudent(String id,Student student){
        for (int i=0;i<students.size();i++){
            if(students.get(i).getId().equals(id)){
                students.set(i,student);
                return true;
            }
        }
        return false;
}
public boolean deleteStudent(String id){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId().equals(id)){
                students.remove(i);
                return true;
            }
        }
        return false;
}

public ArrayList<Student> StudentByAvarge(){
        ArrayList<Student> studentByAge=new ArrayList<>();
        int sum=0;
        int avg=0;
        for(int i=0;i<students.size();i++){
            sum+=i;
            avg=sum/students.size();
        }
        for(int i=0;i<students.size();i++){
            if(students.get(i).getGPA()>avg){
                studentByAge.add(students.get(i));
            }
        }
        return studentByAge;
}
public ArrayList<Student>StudentByAge(int age){
        ArrayList<Student>studentAge=new ArrayList<>();
        for(int i=0;i<students.size();i++){
            if(students.get(i).getAge()>age && students.get(i).getGPA()>80){
                studentAge.add(students.get(i));
            }
        }

        return studentAge;
}

}
