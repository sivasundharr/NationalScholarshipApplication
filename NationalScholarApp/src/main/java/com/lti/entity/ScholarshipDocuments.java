package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ScholarshipDocuments {
	
	@Id
	@GeneratedValue(generator = "scholar_docs_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "scholar_docs_seq",initialValue=1000 ,allocationSize = 1)
	private int scholarshipDocumentsId;
	
	private String domecile;
	private String aadharCard;
	private String tenthMarksheet;
	private String twelfthMarksheet;
	private String photo;
	private String idCard;
	private String casteOrIncomeCertificate;
	private String feeReciept;
	private String passBook;
	
	@OneToOne
	@JoinColumn(name="scholarshipId")
	private ScholarshipApplication scholarship;
	
	public ScholarshipDocuments() {
		
	}
	
	public ScholarshipDocuments(String domecile, String aadharCard, String tenthMarksheet, String twelfthMarksheet,
			String photo, String idCard, String casteOrIncomeCertificate, String feeReciept, String passBook) {
		this.domecile = domecile;
		this.aadharCard = aadharCard;
		this.tenthMarksheet = tenthMarksheet;
		this.twelfthMarksheet = twelfthMarksheet;
		this.photo = photo;
		this.idCard = idCard;
		this.casteOrIncomeCertificate = casteOrIncomeCertificate;
		this.feeReciept = feeReciept;
		this.passBook = passBook;
	}
	
	public int getScholarshipDocumentsId() {
		return scholarshipDocumentsId; 
	}
	public void setScholarshipDocumentsId(int scholarshipDocumentsId) {
		this.scholarshipDocumentsId = scholarshipDocumentsId;
	}
	public String getDomecile() {
		return domecile;
	}
	public void setDomecile(String domecile) {
		this.domecile = domecile;
	}
	public String getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}
	public String getTenthMarksheet() {
		return tenthMarksheet;
	}
	public void setTenthMarksheet(String tenthMarksheet) {
		this.tenthMarksheet = tenthMarksheet;
	}
	public String getTwelfthMarksheet() {
		return twelfthMarksheet;
	}
	public void setTwelfthMarksheet(String twelfthMarksheet) {
		this.twelfthMarksheet = twelfthMarksheet;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getCasteOrIncomeCertificate() {
		return casteOrIncomeCertificate;
	}
	public void setCasteOrIncomeCertificate(String casteOrIncomeCertificate) {
		this.casteOrIncomeCertificate = casteOrIncomeCertificate;
	}
	public String getFeeReciept() {
		return feeReciept;
	}
	public void setFeeReciept(String feeReciept) {
		this.feeReciept = feeReciept;
	}
	public String getPassBook() {
		return passBook;
	}
	public void setPassBook(String passBook) {
		this.passBook = passBook;
	}

	public ScholarshipApplication getScholarship() {
		return scholarship;
	}

	public void setScholarship(ScholarshipApplication scholarship) {
		this.scholarship = scholarship;
	}
	
	
}
