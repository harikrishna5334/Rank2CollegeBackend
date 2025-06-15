package com.arush.Rank2CollegePredictor.repository;

import com.arush.Rank2CollegePredictor.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
    // No custom methods required for filtering as we'll use Java stream
}

