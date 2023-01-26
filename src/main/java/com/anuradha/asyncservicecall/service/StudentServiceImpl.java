package com.anuradha.asyncservicecall.service;


import com.anuradha.asyncservicecall.dto.InstituteDto;
import com.anuradha.asyncservicecall.dto.ResponseDto;
import com.anuradha.asyncservicecall.dto.StudentDto;
import com.anuradha.asyncservicecall.dto.TeacherDto;
import com.anuradha.asyncservicecall.entity.Student;
import com.anuradha.asyncservicecall.repo.InstituteRepository;
import com.anuradha.asyncservicecall.repo.StudentRepository;
import com.anuradha.asyncservicecall.repo.TeacherRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final TeacherRepository teacherRepository;
    private final InstituteRepository instituteRepository;

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Async
    @Override
    public CompletableFuture<List<TeacherDto>> findAllTeachers() {
        List<TeacherDto> list = teacherRepository.findAll().stream()
                .map(t -> modelMapper.map(t, TeacherDto.class))
                .toList();

        return CompletableFuture.completedFuture(list);

    }

    @Async
    @Override
    public CompletableFuture<List<InstituteDto>> findAllInstitutes() {
        List<InstituteDto> list = instituteRepository.findAll().stream()
                .map(i -> modelMapper.map(i, InstituteDto.class))
                .toList();

        return CompletableFuture.completedFuture(list);
    }

    @Async
    @Override
    public CompletableFuture<List<StudentDto>> findAllStudents() {
        List<StudentDto> list = studentRepository.findAll().stream()
                .map(s -> modelMapper.map(s, StudentDto.class))
                .toList();

        return CompletableFuture.completedFuture(list);
    }

    @Override
    public ResponseDto findAll() {

        ResponseDto response = new ResponseDto();

        List<StudentDto> collect = studentRepository.findAll().stream()
                .map(s -> modelMapper.map(s, StudentDto.class))
                .toList();
        response.setStudents(collect);

        List<TeacherDto> teacherDtos = teacherRepository.findAll().stream()
                .map(t -> modelMapper.map(t, TeacherDto.class))
                .toList();

        response.setTeachers(teacherDtos);

        List<InstituteDto> instituteDtos = instituteRepository.findAll().stream()
                .map(i -> modelMapper.map(i, InstituteDto.class))
                .toList();

        response.setInstitutes(instituteDtos);

        return response;


    }

}
