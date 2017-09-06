package com.saas.model;

import java.util.Date;

import com.saas.model.BaseBean;

/**
 * @author arunkumar.edvalpatti
 */

public class Student extends BaseBean {
	private long id;
	private long schoolId;
	private long parentId;
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
	private String phone;
	private String email;
	private int imediateContactId;
	
	private String photoFileName;
	private String photoContentType;
	private String photoData;
	private String status;
	private String payStatus;
	private String emailStatus;
	private String smsStatus;
	
	private int photoFileSize;
	private int siblingId;
	private Date photoUpdateAt;
	private String rollNumber;
	private String libraryCard;
	 @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append(getClass().getSimpleName());
	        sb.append(" [");
	        sb.append(" id=").append(id);
	        sb.append(", schoolId=").append(schoolId);
	        sb.append(", admissionNo=").append(admissionNo);
	        sb.append(", email=").append(email);
	        sb.append(", firstName=").append(firstName);
	        sb.append("]");
	        return sb.toString();
	    }
	public Student() {
	}

	public Student(long id) {
		this.id = id;
	}

	public Student(long id, String email) {
		this.id = id;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the admissionNo
	 */
	public String getAdmissionNo() {
		return admissionNo;
	}

	/**
	 * @param admissionNo the admissionNo to set
	 */
	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	/**
	 * @return the classRollNo
	 */
	public String getClassRollNo() {
		return classRollNo;
	}

	/**
	 * @param classRollNo the classRollNo to set
	 */
	public void setClassRollNo(String classRollNo) {
		this.classRollNo = classRollNo;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the admissionDate
	 */
	public Date getAdmissionDate() {
		return admissionDate;
	}

	/**
	 * @param admissionDate the admissionDate to set
	 */
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	/**
	 * @return the batchId
	 */
	public int getBatchId() {
		return batchId;
	}

	/**
	 * @param batchId the batchId to set
	 */
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the bloodGroup
	 */
	public String getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * @param bloodGroup the bloodGroup to set
	 */
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * @return the birthPlace
	 */
	public String getBirthPlace() {
		return birthPlace;
	}

	/**
	 * @param birthPlace the birthPlace to set
	 */
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	/**
	 * @return the nationalityId
	 */
	public int getNationalityId() {
		return nationalityId;
	}

	/**
	 * @param nationalityId the nationalityId to set
	 */
	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @param religion the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}

	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	/**
	 * @return the countryId
	 */
	public String getCountryId() {
		return countryId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the imediateContactId
	 */
	public int getImediateContactId() {
		return imediateContactId;
	}

	/**
	 * @param imediateContactId the imediateContactId to set
	 */
	public void setImediateContactId(int imediateContactId) {
		this.imediateContactId = imediateContactId;
	}

	/**
	 * @return the smsStatus
	 */
	public String getSmsStatus() {
		return smsStatus;
	}

	/**
	 * @param smsStatus the smsStatus to set
	 */
	public void setSmsStatus(String isSmsEnabled) {
		this.smsStatus = isSmsEnabled;
	}

	/**
	 * @return the photoFileName
	 */
	public String getPhotoFileName() {
		return photoFileName;
	}

	/**
	 * @param photoFileName the photoFileName to set
	 */
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	/**
	 * @return the photoContentType
	 */
	public String getPhotoContentType() {
		return photoContentType;
	}

	/**
	 * @param photoContentType the photoContentType to set
	 */
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	/**
	 * @return the photoData
	 */
	public String getPhotoData() {
		return photoData;
	}

	/**
	 * @param photoData the photoData to set
	 */
	public void setPhotoData(String photoData) {
		this.photoData = photoData;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param statusDescription the statusDescription to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the payStatus
	 */
	public String getPayStatus() {
		return payStatus;
	}

	/**
	 * @param payStatus the payStatus to set
	 */
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	/**
	 * @return the photoFileSize
	 */
	public int getPhotoFileSize() {
		return photoFileSize;
	}

	/**
	 * @param photoFileSize the photoFileSize to set
	 */
	public void setPhotoFileSize(int photoFileSize) {
		this.photoFileSize = photoFileSize;
	}

	/**
	 * @return the emailStatus
	 */
	public String getEmailStatus() {
		return emailStatus;
	}

	/**
	 * @param emailStatus the emailStatus to set
	 */
	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	/**
	 * @return the siblingId
	 */
	public int getSiblingId() {
		return siblingId;
	}

	/**
	 * @param siblingId the siblingId to set
	 */
	public void setSiblingId(int siblingId) {
		this.siblingId = siblingId;
	}

	/**
	 * @return the photoUpdateAt
	 */
	public Date getPhotoUpdateAt() {
		return photoUpdateAt;
	}

	/**
	 * @param photoUpdateAt the photoUpdateAt to set
	 */
	public void setPhotoUpdateAt(Date photoUpdateAt) {
		this.photoUpdateAt = photoUpdateAt;
	}

	/**
	 * @return the rollNumber
	 */
	public String getRollNumber() {
		return rollNumber;
	}

	/**
	 * @param rollNumber the rollNumber to set
	 */
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	/**
	 * @return the schoolId
	 */
	public long getSchoolId() {
		return schoolId;
	}

	/**
	 * @param schoolId the schoolId to set
	 */
	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}

	/**
	 * @return the libraryCard
	 */
	public String getLibraryCard() {
		return libraryCard;
	}

	/**
	 * @param libraryCard the libraryCard to set
	 */
	public void setLibraryCard(String libraryCard) {
		this.libraryCard = libraryCard;
	}

	/**
	 * @return the parentId
	 */
	public long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
}
