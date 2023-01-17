package com.anuradha.asyncservicecall.service;


import com.anuradha.asyncservicecall.dto.ResponseDto;
import com.anuradha.asyncservicecall.dto.StudentDto;
import com.anuradha.asyncservicecall.entity.Student;
import com.anuradha.asyncservicecall.repo.StudentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public ResponseDto findAll() {
        return null;
    }
}
