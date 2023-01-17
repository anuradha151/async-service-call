package com.anuradha.asyncservicecall.repo;

import com.anuradha.asyncservicecall.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
