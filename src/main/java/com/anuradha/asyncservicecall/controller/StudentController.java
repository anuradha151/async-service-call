package com.anuradha.asyncservicecall.controller;

import com.anuradha.asyncservicecall.dto.ResponseDto;
import com.anuradha.asyncservicecall.dto.StudentDto;
import com.anuradha.asyncservicecall.entity.Institute;
import com.anuradha.asyncservicecall.entity.Student;
import com.anuradha.asyncservicecall.entity.Teacher;
import com.anuradha.asyncservicecall.repo.InstituteRepository;
import com.anuradha.asyncservicecall.repo.StudentRepository;
import com.anuradha.asyncservicecall.repo.TeacherRepository;
import com.anuradha.asyncservicecall.service.DashboardService;
import com.anuradha.asyncservicecall.service.StudentService;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {


    private final StudentService studentService;
    private final StudentRepository studentRepository;
    private final InstituteRepository instituteRepository;
    private final TeacherRepository teacherRepository;
    private final DashboardService dashboardService;

    public StudentController(StudentService studentService, StudentRepository studentRepository, InstituteRepository instituteRepository, TeacherRepository teacherRepository, DashboardService dashboardService) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
        this.instituteRepository = instituteRepository;
        this.teacherRepository = teacherRepository;
        this.dashboardService = dashboardService;
    }

    @PostMapping
    public StudentDto save(@RequestBody StudentDto request) {
        return studentService.save(request);
    }

    @GetMapping
    public ResponseDto findAll() {
        return studentService.findAll();
    }
    @GetMapping("all/async")
    public ResponseDto findAllAsync() {
        return dashboardService.findAll();
    }


    @GetMapping("gen")
    public void generate() {
        System.out.println("Bulk gen start");
        Faker faker = new Faker();

        List<Student> students = new ArrayList<>();
        List<Institute> ins = new ArrayList<>();
        List<Teacher> te = new ArrayList<>();

        for (int i = 11000; i < 100000; i++) {
            Student student = new Student();
            student.setId(i);
            student.setName(faker.name().name());
            student.setEmail(faker.internet().emailAddress());
            student.setAddress(faker.address().fullAddress());
            students.add(student);

            Institute institute = new Institute();
            institute.setId(i);
            institute.setName(faker.name().name());
            institute.setEmail(faker.internet().emailAddress());
            institute.setAddress(faker.address().fullAddress());
            ins.add(institute);

            Teacher teacher = new Teacher();
            teacher.setId(i);
            teacher.setName(faker.name().name());
            teacher.setEmail(faker.internet().emailAddress());
            teacher.setAddress(faker.address().fullAddress());
            teacher.setSubject(faker.educator().course());
            teacher.setContactNumber(faker.phoneNumber().cellPhone());
            te.add(teacher);
        }
        studentRepository.saveAll(students);
        teacherRepository.saveAll(te);
        instituteRepository.saveAll(ins);
        System.out.println("Bulk gen over");
    }
}
