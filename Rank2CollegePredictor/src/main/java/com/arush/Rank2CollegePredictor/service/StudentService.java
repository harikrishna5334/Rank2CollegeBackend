//package com.arush.Rank2CollegePredictor.service;
//
//import com.arush.Rank2CollegePredictor.model.Student;
//import com.arush.Rank2CollegePredictor.repository.StudentRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class StudentService {
//    @Autowired
//    private StudentRepo repo;
//
//    public void importStudentsFromCSV(MultipartFile file) {
//        List<Student> students = com.arush.Rank2CollegePredictor.util.CSVHelper.csvToStudents(file);
//        repo.saveAll(students);
//    }
//
//    public List<Student> getStudents() {
//        return repo.findAll();
//    }
//
//    public List<Student> getCollegesByRankGenderCaste(int rank, String gender, String caste) {
//        return repo.findAll().stream()
//                .filter(s -> isEligible(s, rank, gender, caste))
//                .collect(Collectors.toList());
//    }
//
//
//    private boolean isEligible(Student s, int rank, String gender, String caste) {
//        try {
//            String value = getRankByCasteAndGender(s, caste.toLowerCase(), gender.toLowerCase());
//            if (value == null || value.trim().isEmpty() || value.toLowerCase().contains("code")) return false;
//
//            int cutoffRank = Integer.parseInt(value.trim());
//            System.out.println("Checking eligibility: StudentRank=" + rank + ", Cutoff=" + value);
//
//            return rank <= cutoffRank; // Student is eligible if their rank is better than or equal to cutoff
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//
//    private String getRankByCasteAndGender(Student s, String caste, String gender) {
//        return switch (caste) {
//            case "oc" -> gender.equals("male") ? s.getOcBoys() : s.getOcGirls();
//            case "bca" -> gender.equals("male") ? s.getBcABoys() : s.getBcAGirls();
//            case "bcb" -> gender.equals("male") ? s.getBcBBoys() : s.getBcBGirls();
//            case "bcc" -> gender.equals("male") ? s.getBcCBoys() : s.getBcCGirls();
//            case "bcd" -> gender.equals("male") ? s.getBcDBoys() : s.getBcDGirls();
//            case "bce" -> gender.equals("male") ? s.getBcEBoys() : s.getBcEGirls();
//            case "sc" -> gender.equals("male") ? s.getScBoys() : s.getScGirls();
//            case "st" -> gender.equals("male") ? s.getStBoys() : s.getStGirls();
//            case "ews" -> gender.equals("male") ? s.getEwsGenOu() : s.getEwsGirlsOu();
//            default -> null;
//        };
//    }
//}

package com.arush.Rank2CollegePredictor.service;

import com.arush.Rank2CollegePredictor.model.Student;
import com.arush.Rank2CollegePredictor.repository.StudentRepo;
import com.arush.Rank2CollegePredictor.util.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    public void importStudentsFromCSV(MultipartFile file) {
        List<Student> students = CSVHelper.csvToStudents(file);
        repo.saveAll(students);
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }

    // ✅ Main method to filter colleges
    public List<Map<String, Object>> getCollegesByRankGenderCaste(int rank, String gender, String caste) {
        return repo.findAll().stream()
                .filter(s -> isEligible(s, rank, gender, caste))
                .sorted(Comparator.comparingInt(s -> getCutoffRank(s, caste, gender)))
                .map(s -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("id", s.getId());
                    map.put("instCode", s.getInstCode());
                    map.put("instituteName", s.getInstituteName());
                    map.put("place", s.getPlace());
                    map.put("distCode", s.getDistCode());
                    map.put("coEducation", s.getCoEducation());
                    map.put("collegeType", s.getCollegeType());
                    map.put("yearOfEstab", s.getYearOfEstab());
                    map.put("branchCode", s.getBranchCode());
                    map.put("branchName", s.getBranchName());

                    // Only include the relevant cutoff for the given caste
                    map.put(caste.toLowerCase() + (gender.equalsIgnoreCase("male") ? "Boys" : "Girls"),
                            getRankValue(s, caste, gender));

                    map.put("tuitionFee", s.getTuitionFee());
                    map.put("affiliatedTo", s.getAffiliatedTo());
                    return map;
                })
                .collect(Collectors.toList());
    }

    private boolean isEligible(Student s, int rank, String gender, String caste) {
        try {
            String cutoffStr = getRankValue(s, caste, gender);
            if (cutoffStr == null || cutoffStr.trim().isEmpty() || cutoffStr.toLowerCase().contains("code"))
                return false;

            int cutoff = Integer.parseInt(cutoffStr.trim());
            return rank <= cutoff;
        } catch (Exception e) {
            return false;
        }
    }

    private String getRankValue(Student s, String caste, String gender) {
        caste = caste.toLowerCase();
        gender = gender.toLowerCase();
        return switch (caste) {
            case "oc" -> gender.equals("male") ? s.getOcBoys() : s.getOcGirls();
            case "bca" -> gender.equals("male") ? s.getBcABoys() : s.getBcAGirls();
            case "bcb" -> gender.equals("male") ? s.getBcBBoys() : s.getBcBGirls();
            case "bcc" -> gender.equals("male") ? s.getBcCBoys() : s.getBcCGirls();
            case "bcd" -> gender.equals("male") ? s.getBcDBoys() : s.getBcDGirls();
            case "bce" -> gender.equals("male") ? s.getBcEBoys() : s.getBcEGirls();
            case "sc" -> gender.equals("male") ? s.getScBoys() : s.getScGirls();
            case "st" -> gender.equals("male") ? s.getStBoys() : s.getStGirls();
            case "ews" -> gender.equals("male") ? s.getEwsGenOu() : s.getEwsGirlsOu();
            default -> null;
        };
    }

    private int getCutoffRank(Student s, String caste, String gender) {
        try {
            String value = getRankValue(s, caste, gender);
            return Integer.parseInt(value.trim());
        } catch (Exception e) {
            return Integer.MAX_VALUE; // Sort to bottom if invalid
        }
    }

    public List<Map<String, Object>> getCollegesByRankGenderCasteAndBranch(int rank, String gender, String caste, String branchCode) {
        return repo.findAll().stream()
                .filter(s -> s.getBranchCode().equalsIgnoreCase(branchCode))  // filter by branch code
                .filter(s -> isEligible(s, rank, gender, caste))             // filter by eligibility
                .sorted(Comparator.comparingInt(s -> getCutoffRank(s, caste, gender)))  // sort by cutoff
                .map(s -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("instCode", s.getInstCode());
                    map.put("instituteName", s.getInstituteName());
                    map.put("branchCode", s.getBranchCode());
                    map.put("branchName", s.getBranchName());
                    map.put("place", s.getPlace());
                    map.put("distCode", s.getDistCode());
//                    map.put("tuitionFee", s.getTuitionFee());
//                    map.put("affiliatedTo", s.getAffiliatedTo());
//
//                    // dynamic cutoff rank based on caste + gender
//                    String cutoffKey = caste.toLowerCase() + (gender.equalsIgnoreCase("male") ? "Boys" : "Girls");
//                    map.put("cutoffRank", getRankValue(s, caste, gender));

                    map.put(caste.toLowerCase() + (gender.equalsIgnoreCase("male") ? "Boys" : "Girls"),
                            getRankValue(s, caste, gender));

                    map.put("tuitionFee", s.getTuitionFee());
                    map.put("affiliatedTo", s.getAffiliatedTo());
                    return map;

//                    return map;
                })
                .collect(Collectors.toList());
    }

}



