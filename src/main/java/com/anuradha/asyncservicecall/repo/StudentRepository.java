package com.anuradha.asyncservicecall.repo;

import com.anuradha.asyncservicecall.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
