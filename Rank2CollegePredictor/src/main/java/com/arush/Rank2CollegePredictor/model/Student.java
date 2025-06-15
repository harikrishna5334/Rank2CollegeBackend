package com.arush.Rank2CollegePredictor.model;




import jakarta.persistence.*;


@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String instCode;
    private String instituteName;
    private String place;
    private String distCode;
    private String coEducation;
    private String collegeType;
    private String yearOfEstab;
    private String branchCode;
    private String branchName;
    private String ocBoys;
    private String ocGirls;
    private String bcABoys;
    private String bcAGirls;
    private String bcBBoys;
    private String bcBGirls;
    private String bcCBoys;
    private String bcCGirls;
    private String bcDBoys;
    private String bcDGirls;
    private String bcEBoys;
    private String bcEGirls;
    private String scBoys;
    private String scGirls;
    private String stBoys;
    private String stGirls;
    private String ewsGenOu;
    private String ewsGirlsOu;
    private String tuitionFee;
    private String affiliatedTo;


    public Student(Long id, String instCode, String instituteName, String place, String distCode, String coEducation, String collegeType, String yearOfEstab, String branchCode, String branchName, String ocBoys, String ocGirls, String bcABoys, String bcAGirls, String bcBBoys, String bcBGirls, String bcCBoys, String bcCGirls, String bcDBoys, String bcDGirls, String bcEBoys, String bcEGirls, String scBoys, String scGirls, String stBoys, String stGirls, String ewsGenOu, String ewsGirlsOu, String tuitionFee, String affiliatedTo) {
        this.id = id;
        this.instCode = instCode;
        this.instituteName = instituteName;
        this.place = place;
        this.distCode = distCode;
        this.coEducation = coEducation;
        this.collegeType = collegeType;
        this.yearOfEstab = yearOfEstab;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.ocBoys = ocBoys;
        this.ocGirls = ocGirls;
        this.bcABoys = bcABoys;
        this.bcAGirls = bcAGirls;
        this.bcBBoys = bcBBoys;
        this.bcBGirls = bcBGirls;
        this.bcCBoys = bcCBoys;
        this.bcCGirls = bcCGirls;
        this.bcDBoys = bcDBoys;
        this.bcDGirls = bcDGirls;
        this.bcEBoys = bcEBoys;
        this.bcEGirls = bcEGirls;
        this.scBoys = scBoys;
        this.scGirls = scGirls;
        this.stBoys = stBoys;
        this.stGirls = stGirls;
        this.ewsGenOu = ewsGenOu;
        this.ewsGirlsOu = ewsGirlsOu;
        this.tuitionFee = tuitionFee;
        this.affiliatedTo = affiliatedTo;
    }

    //empty constructor:
    public Student() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstCode() {
        return instCode;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDistCode() {
        return distCode;
    }

    public void setDistCode(String distCode) {
        this.distCode = distCode;
    }

    public String getCoEducation() {
        return coEducation;
    }

    public void setCoEducation(String coEducation) {
        this.coEducation = coEducation;
    }

    public String getCollegeType() {
        return collegeType;
    }

    public void setCollegeType(String collegeType) {
        this.collegeType = collegeType;
    }

    public String getYearOfEstab() {
        return yearOfEstab;
    }

    public void setYearOfEstab(String yearOfEstab) {
        this.yearOfEstab = yearOfEstab;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getOcBoys() {
        return ocBoys;
    }

    public void setOcBoys(String ocBoys) {
        this.ocBoys = ocBoys;
    }

    public String getOcGirls() {
        return ocGirls;
    }

    public void setOcGirls(String ocGirls) {
        this.ocGirls = ocGirls;
    }

    public String getBcABoys() {
        return bcABoys;
    }

    public void setBcABoys(String bcABoys) {
        this.bcABoys = bcABoys;
    }

    public String getBcAGirls() {
        return bcAGirls;
    }

    public void setBcAGirls(String bcAGirls) {
        this.bcAGirls = bcAGirls;
    }

    public String getBcBBoys() {
        return bcBBoys;
    }

    public void setBcBBoys(String bcBBoys) {
        this.bcBBoys = bcBBoys;
    }

    public String getBcBGirls() {
        return bcBGirls;
    }

    public void setBcBGirls(String bcBGirls) {
        this.bcBGirls = bcBGirls;
    }

    public String getBcCBoys() {
        return bcCBoys;
    }

    public void setBcCBoys(String bcCBoys) {
        this.bcCBoys = bcCBoys;
    }

    public String getBcCGirls() {
        return bcCGirls;
    }

    public void setBcCGirls(String bcCGirls) {
        this.bcCGirls = bcCGirls;
    }

    public String getBcDBoys() {
        return bcDBoys;
    }

    public void setBcDBoys(String bcDBoys) {
        this.bcDBoys = bcDBoys;
    }

    public String getBcDGirls() {
        return bcDGirls;
    }

    public void setBcDGirls(String bcDGirls) {
        this.bcDGirls = bcDGirls;
    }

    public String getBcEBoys() {
        return bcEBoys;
    }

    public void setBcEBoys(String bcEBoys) {
        this.bcEBoys = bcEBoys;
    }

    public String getBcEGirls() {
        return bcEGirls;
    }

    public void setBcEGirls(String bcEGirls) {
        this.bcEGirls = bcEGirls;
    }

    public String getScBoys() {
        return scBoys;
    }

    public void setScBoys(String scBoys) {
        this.scBoys = scBoys;
    }

    public String getScGirls() {
        return scGirls;
    }

    public void setScGirls(String scGirls) {
        this.scGirls = scGirls;
    }

    public String getStBoys() {
        return stBoys;
    }

    public void setStBoys(String stBoys) {
        this.stBoys = stBoys;
    }

    public String getStGirls() {
        return stGirls;
    }

    public void setStGirls(String stGirls) {
        this.stGirls = stGirls;
    }

    public String getEwsGenOu() {
        return ewsGenOu;
    }

    public void setEwsGenOu(String ewsGenOu) {
        this.ewsGenOu = ewsGenOu;
    }

    public String getEwsGirlsOu() {
        return ewsGirlsOu;
    }

    public void setEwsGirlsOu(String ewsGirlsOu) {
        this.ewsGirlsOu = ewsGirlsOu;
    }

    public String getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(String tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public String getAffiliatedTo() {
        return affiliatedTo;
    }

    public void setAffiliatedTo(String affiliatedTo) {
        this.affiliatedTo = affiliatedTo;
    }
}


