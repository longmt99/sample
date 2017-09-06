package com.saas.model;

import java.sql.Timestamp;
import java.util.Date;

import com.saas.model.student.Student;

/**
 * @longmt99
 */
public class StudentResponse {
	private long id;
	private long schoolId;
	private long parentId;
	private String phone;
	private String email;
	private String admissionNo;
	private String classRollNo;
	private Date admissionDate;
	private String firstName;
	private String middleName;
	private String lastName;
	private int batchId;
	private Date dob;
	private String gender;
	private String bloodGroup;
	private String birthPlace;
	private int nationalityId;
	private String language;
	private String religion;
	private int categoryId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String pinCode;
	private String countryId;
	private int imediateContactId;
	
	private String photoFileName;
	private String photoContentType;
	private String photoData;
	private String status;
	private String smsStatus;
	private String payStatus;
	private String emailStatus;
	private int photoFileSize;
	private int siblingId;
	private Timestamp photoUpdateAt;
	private String rollNumber;
	private String libraryCard;
	

	public String toString() {
		return this.id + "," + this.firstName + "," + this.lastName;
	}

	public StudentResponse() {
	}

	public StudentResponse(long id) {
		this.id = id;
	}

	public StudentResponse(Student student) {
		this.id = student.getId();
		this.schoolId = student.getSchoolId();
		this.parentId = student.getParentId();
		this.admissionNo = student.getAdmissionNo();
		this.classRollNo = student.getClassRollNo();
		this.firstName = student.getFirstName();
		this.middleName = student.getMiddleName();
		this.lastName = student.getLastName();
		this.batchId = student.getBatchId();
		this.gender = student.getGender();
		this.bloodGroup = student.getBloodGroup();
		this.dob = student.getDob();
		this.birthPlace = student.getBirthPlace();
		this.nationalityId = student.getNationalityId();
		this.language = student.getLanguage();
		this.religion = student.getReligion();
		this.categoryId = student.getCategoryId();
		this.addressLine1 = student.getAddressLine1();
		this.addressLine2 = student.getAddressLine2();
		this.city = student.getCity();
		this.state = student.getState();
		this.pinCode = student.getPinCode();
		this.countryId = student.getCountryId();
		this.phone = student.getPhone();
		this.email = student.getEmail();
		this.imediateContactId = student.getImediateContactId();
		this.smsStatus = student.getSmsStatus();
		this.payStatus = student.getPayStatus();
		this.emailStatus = student.getEmailStatus();
		this.siblingId = student.getSiblingId();
		this.rollNumber = student.getRollNumber();
		this.libraryCard = student.getLibraryCard();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdmissionNo() {
		return admissionNo;
	}

	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	public String getClassRollNo() {
		return classRollNo;
	}

	public void setClassRollNo(String classRollNo) {
		this.classRollNo = classRollNo;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public int getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone1) {
		this.phone = phone1;
	}


	public int getImediateContactId() {
		return imediateContactId;
	}

	public void setImediateContactId(int imediateContactId) {
		this.imediateContactId = imediateContactId;
	}

	public String getSmsStatus() {
		return smsStatus;
	}

	public void setSmsStatus(String smsStatus) {
		this.smsStatus = smsStatus;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getPhotoData() {
		return photoData;
	}

	public void setPhotoData(String photoData) {
		this.photoData = photoData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public int getPhotoFileSize() {
		return photoFileSize;
	}

	public void setPhotoFileSize(int photoFileSize) {
		this.photoFileSize = photoFileSize;
	}

	public String getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	public int getSiblingId() {
		return siblingId;
	}

	public void setSiblingId(int siblingId) {
		this.siblingId = siblingId;
	}

	public Timestamp getPhotoUpdateAt() {
		return photoUpdateAt;
	}

	public void setPhotoUpdateAt(Timestamp photoUpdateAt) {
		this.photoUpdateAt = photoUpdateAt;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}

	public String getLibraryCard() {
		return libraryCard;
	}

	public void setLibraryCard(String libraryCard) {
		this.libraryCard = libraryCard;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long userId) {
		this.parentId = userId;
	}
}
