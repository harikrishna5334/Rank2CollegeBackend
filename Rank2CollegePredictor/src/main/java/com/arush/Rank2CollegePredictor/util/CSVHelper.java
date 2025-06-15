package com.arush.Rank2CollegePredictor.util;

import com.arush.Rank2CollegePredictor.model.Student;
import com.opencsv.CSVReader;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

    public static List<Student> csvToStudents(MultipartFile file) {
        List<Student> students = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            String[] line;
            int lineNumber = 0;
            while ((line = reader.readNext()) != null) {
                if (lineNumber == 0 || line[0].equalsIgnoreCase("Inst Code")) {
                    lineNumber++;
                    continue; // Skip header
                }

                Student s = new Student();
                s.setInstCode(line[0]);
                s.setInstituteName(line[1]);
                s.setPlace(line[2]);
                s.setDistCode(line[3]);
                s.setCoEducation(line[4]);
                s.setCollegeType(line[5]);
                s.setYearOfEstab(line[6]);
                s.setBranchCode(line[7]);
                s.setBranchName(line[8]);
                s.setOcBoys(line[9]);
                s.setOcGirls(line[10]);
                s.setBcABoys(line[11]);
                s.setBcAGirls(line[12]);
                s.setBcBBoys(line[13]);
                s.setBcBGirls(line[14]);
                s.setBcCBoys(line[15]);
                s.setBcCGirls(line[16]);
                s.setBcDBoys(line[17]);
                s.setBcDGirls(line[18]);
                s.setBcEBoys(line[19]);
                s.setBcEGirls(line[20]);
                s.setScBoys(line[21]);
                s.setScGirls(line[22]);
                s.setStBoys(line[23]);
                s.setStGirls(line[24]);
                s.setEwsGenOu(line[25]);
                s.setEwsGirlsOu(line[26]);
                s.setTuitionFee(line[27]);
                s.setAffiliatedTo(line[28]);

                students.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

}

