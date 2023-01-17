package com.anuradha.asyncservicecall.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDto {
    List<StudentDto> students;
    List<InstituteDto> institutes;
    List<TeacherDto> teachers;
}
