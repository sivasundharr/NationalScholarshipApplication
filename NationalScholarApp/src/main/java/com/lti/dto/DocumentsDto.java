package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class DocumentsDto {
	
	int scholarshipId;
	
	MultipartFile aadharCard;
	MultipartFile tenthMarksheet;
	MultipartFile twelfthMarksheet;
	MultipartFile photo;
	MultipartFile idCard;
	MultipartFile casteOrIncomeCertificate;
	MultipartFile feeReciept;
	MultipartFile passBook;
	MultipartFile domecile;
	
	public int getScholarshipId() {
		return scholarshipId;
	}
	
	public void setScholarshipId(int scholarshipId) {
		this.scholarshipId = scholarshipId;
	}
	public MultipartFile getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(MultipartFile aadharCard) {
		this.aadharCard = aadharCard;
	}
	public MultipartFile getTenthMarksheet() {
		return tenthMarksheet;
	}
	public void setTenthMarksheet(MultipartFile tenthMarksheet) {
		this.tenthMarksheet = tenthMarksheet;
	}
	public MultipartFile getTwelfthMarksheet() {
		return twelfthMarksheet;
	}
	public void setTwelfthMarksheet(MultipartFile twelfthMarksheet) {
		this.twelfthMarksheet = twelfthMarksheet;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public MultipartFile getIdCard() {
		return idCard;
	}
	public void setIdCard(MultipartFile idCard) {
		this.idCard = idCard;
	}
	public MultipartFile getCasteOrIncomeCertificate() {
		return casteOrIncomeCertificate;
	}
	public void setCasteOrIncomeCertificate(MultipartFile casteOrIncomeCertificate) {
		this.casteOrIncomeCertificate = casteOrIncomeCertificate;
	}
	public MultipartFile getFeeReciept() {
		return feeReciept;
	}
	public void setFeeReciept(MultipartFile feeReciept) {
		this.feeReciept = feeReciept;
	}
	public MultipartFile getPassBook() {
		return passBook;
	}
	public void setPassBook(MultipartFile passBook) {
		this.passBook = passBook;
	}
	public MultipartFile getDomecile() {
		return domecile;
	}
	public void setDomecile(MultipartFile domecile) {
		this.domecile = domecile;
	}
	
	
}
