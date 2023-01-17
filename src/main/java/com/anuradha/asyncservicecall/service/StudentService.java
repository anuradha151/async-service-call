package com.anuradha.asyncservicecall.service;


import com.anuradha.asyncservicecall.dto.ResponseDto;
import com.anuradha.asyncservicecall.dto.StudentDto;

public interface StudentService {

    StudentDto save(StudentDto studentDto);

    ResponseDto findAll();
}
