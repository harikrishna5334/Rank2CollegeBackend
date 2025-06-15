package com.arush.Rank2CollegePredictor.controller;

import com.arush.Rank2CollegePredictor.model.Student;
import com.arush.Rank2CollegePredictor.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/hello")
    public String print() {
        return "Hey there welcome to spring boot world..!";
    }

    @PostMapping("/import")
    public String importCSV(@RequestParam("file") MultipartFile file) {
        service.importStudentsFromCSV(file);
        return "CSV data imported successfully!";
    }

    @GetMapping("/list")
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @GetMapping("/filter")
    public List<Map<String, Object>> filterByRankGenderCaste(
            @RequestParam int rank,
            @RequestParam String gender,
            @RequestParam String caste) {
        return service.getCollegesByRankGenderCaste(rank, gender, caste);
    }

    @GetMapping("/filterByBranch")
    public List<Map<String, Object>> filterByBranchCode(
            @RequestParam int rank,
            @RequestParam String gender,
            @RequestParam String caste,
            @RequestParam String branchCode) {
        return service.getCollegesByRankGenderCasteAndBranch(rank, gender, caste, branchCode);
    }


}
