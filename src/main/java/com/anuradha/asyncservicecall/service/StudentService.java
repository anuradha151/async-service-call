package com.anuradha.asyncservicecall.service;


import com.anuradha.asyncservicecall.dto.InstituteDto;
import com.anuradha.asyncservicecall.dto.ResponseDto;
import com.anuradha.asyncservicecall.dto.StudentDto;
import com.anuradha.asyncservicecall.dto.TeacherDto;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface StudentService {

    StudentDto save(StudentDto studentDto);

    CompletableFuture<List<StudentDto>> findAllStudents();

    CompletableFuture<List<TeacherDto>> findAllTeachers();

    CompletableFuture<List<InstituteDto>> findAllInstitutes();

    ResponseDto findAll();
}
