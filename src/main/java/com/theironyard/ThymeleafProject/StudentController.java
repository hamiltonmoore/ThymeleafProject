package com.theironyard.ThymeleafProject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    Student student;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("view_student")
    public String viewStudent(Model model) {
        System.out.println("GOT HERE IN: viewStudent().....");
        model.addAttribute("student", student);
        return "view_student";
    }

    @RequestMapping("/new_student")
    public String newStudent(Model model) {
        Grade.printAll();
        model.addAttribute("grades", Grade.values());

        return "new_student";
    }

    @RequestMapping(path = "/create_student", method = RequestMethod.POST)
    public String createStudent(@RequestParam(value="first_name") String firstName,
                                @RequestParam(value="last_name") String lastName,
                                @RequestParam(value="grade") Grade grade) {
        System.out.println("We;re in createStudent()");

        Student student = new Student();

        /* set student firstName, lastName and grade using the http request parameters */
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setGrade(grade);
        this.student = student;
//
//        /* add the student to the model that will be used by the view_student html file */
//        model.addAttribute("Student", student);

        return "redirect:/view_student.html";
    }
}
