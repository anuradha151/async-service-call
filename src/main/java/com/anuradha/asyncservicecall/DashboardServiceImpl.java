package com.anuradha.asyncservicecall;

import com.anuradha.asyncservicecall.dto.InstituteDto;
import com.anuradha.asyncservicecall.dto.ResponseDto;
import com.anuradha.asyncservicecall.dto.StudentDto;
import com.anuradha.asyncservicecall.dto.TeacherDto;
import com.anuradha.asyncservicecall.service.DashboardService;
import com.anuradha.asyncservicecall.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final StudentService studentService;

    public DashboardServiceImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public ResponseDto findAll() {

        CompletableFuture<List<StudentDto>> allStudents = studentService.findAllStudents();
        CompletableFuture<List<InstituteDto>> allInstitutes = studentService.findAllInstitutes();
        CompletableFuture<List<TeacherDto>> allTeachers = studentService.findAllTeachers();

        CompletableFuture.allOf(allStudents, allInstitutes, allTeachers);

        ResponseDto response = new ResponseDto();
        try {
            response.setStudents(allStudents.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        try {
            response.setTeachers(allTeachers.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        try {
            response.setInstitutes(allInstitutes.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return response;

    }
}
