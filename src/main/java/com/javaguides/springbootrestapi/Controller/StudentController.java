package com.javaguides.springbootrestapi.Controller;

import com.javaguides.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {



    // http://localhost:8080/student
//    @GetMapping("student")
//    public Student getStudent(){
//
//        Student student= new Student(45 , "Asu" , " the Winner");
//        return student;
//    }


    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){

        Student student= new Student(45 , "Asu" , " the Winner");
//        return new ResponseEntity<>(student , HttpStatus.OK) ;
        return ResponseEntity.ok().header("custom-header" , "ramesh").body(student);
    }



    @GetMapping()
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(23 , "Asu" , "Sahoo"));
        students.add(new Student(33 , "AsuMunu" , "Sahoo"));
        students.add(new Student(13 , "Asutosh" , "Sahoo"));
        return  students;
    }

//Springboot resdt-Api with path Variables
//{id} - uri template variable
//    http://localhost:8080/student/4/asu/sahoo
   @GetMapping("student/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable int id , @PathVariable("first-name") String firstName ,
                                       @PathVariable("last-name") String lastName){

        Student student = new Student(id , firstName , lastName);
        return student;
    }

//    Springboot resdt-Api with  request Param

    @GetMapping("query")
    public Student requestParamStudentVariable(@RequestParam int id , @RequestParam String firstName ,
                                              @RequestParam String lastName){
        Student student = new Student( id , firstName , lastName);
        return student;
    }

    //Spring boot Rest API that handeles HTTP post request - creating new Resourses
//    @PostMapping and @RequestBody

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
     public Student createStudent(@RequestBody Student student ){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
     }

     //Spring boot Rest Api that updating the put request - updating the existing resourses

    @PutMapping("{id}/update")
    public Student updateStudent(@RequestBody Student student , @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }
   @DeleteMapping("student/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){

       System.out.println(studentId);
        return "successfully deleted";
    }
}
