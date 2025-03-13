package com.example.lab7.Service;

import com.example.lab72.Model.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher>teachers=new ArrayList<>();
    public ArrayList<Teacher>getTeachers(){
        return teachers;
    }

    public boolean addTeacher(Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(teacher.getId())) {
                return false;
            }
        }
        teachers.add(teacher);
        return true;
    }

    public boolean updateTeacher(String id,Teacher teacher){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId().equals(id)){
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(String id){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId().equals(id)){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Teacher>getTeacherOfExsperience(int Experience) {
        ArrayList<Teacher> teachersOfExpr = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getYearsOfExperience()>Experience){
                teachersOfExpr.add(teachers.get(i));
            }
        }
    return teachersOfExpr;
    }

    public boolean salaryPoint(String id,int amount){
        for(int i=0;i<teachers.size();i++){
            if (teachers.get(i).getId().equals(id)) {
            teachers.get(i).setSalary(teachers.get(i).getSalary() + amount);
            return true;
            }
        }
        return false;
    }


}
