package com.lti;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dto.ApproveDto;
import com.lti.entity.BankDetails;
import com.lti.entity.DisabilityStatus;
import com.lti.entity.Institute;
import com.lti.entity.ScholarshipApplication;
import com.lti.entity.ScholarshipDocuments;
import com.lti.entity.ScholarshipStatus;
import com.lti.entity.ScholarshipType;
import com.lti.entity.StateNodal;
import com.lti.entity.States;
import com.lti.entity.Student;
import com.lti.service.ApproveScholarshipService;
import com.lti.service.BankDetailsService;
import com.lti.service.InstituteService;
import com.lti.service.ScholarshipApplicationService;
import com.lti.service.ScholarshipDocumentsService;
import com.lti.service.ScholarshipStatusService;
import com.lti.service.ScholarshipTypeService;
import com.lti.service.StateNodalService;
import com.lti.service.StudentService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class NationalScholarAppApplicationTests {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ScholarshipStatusService studentStatusService;
	
	@Autowired
	private BankDetailsService bankDetailsService;
	
	@Autowired
	private ScholarshipApplicationService scholarApplicationService;
	
	@Autowired
	private ScholarshipDocumentsService scholarshipDocumentService;
	
	@Autowired
	private InstituteService instituteService;
	
	@Autowired
	private ScholarshipTypeService scholarshipTypeService;
	
	@Autowired
	private StateNodalService stateNodalService;
	
	@Autowired
	private ApproveScholarshipService approveService;
	
	// Institute Entity
	@Test
	@Order(1)
	public void addOrUpdateInstituteTest() {
		Institute i = new Institute();
		i.setEmail("iemail@gmail.com");
		i.setPassword("password");
		i.setName("name");
		i.setInstituteType("ordinary");
		i.setAddress("address");
		i.setState(States.TAMILNADU.toString());
		i.setDistrict("Coimbatore");
		i.setPincode("609108");
		i.setDiseCode("123123");
		i.setLocation("RURAL");
		i.setUniversityName("universityName");
		i.setPrincipalName("princeipalName");
		i.setMobileNumber("99887766554");
		i.setInstituteCategory("category");
		i.setTelephoneNumber("044-2378946");
		i.setApprovalStatus(true);
		assertNotNull(instituteService.addInstitute(i));
	}

	@Test
	@Order(2)
	public void searchInstituteById() {
		assertNotNull(instituteService.findById(13000));
	}
	
	// create student
	
	@Test
	@Order(3)
	void addOrUpdateStudent() {
		Student student = new Student();
		student.setEmail("email2@gmail.com");
		student.setPassword("1234");
		student.setAadharNumber("aadhar");
		student.setName("name");
		student.setDob(LocalDate.now().toString());
		student.setGender("m");
		student.setMobileNumber("9988776655");
		student.setCollegeId(13000);
		Student student1 = studentService.createStudent(student);
		assertNotNull(student1);
	}
	
	// search Student by Id
	@Test
	@Order(4)
	void searchStatusByStudentId() {
		Optional<Student> student = studentService.searchByStudentId(100);
		assertNotNull(student.get());
		assertTrue(student.get().getName().equals("name"));
	}
	
	
	
	// BankDetails Entity
		@Test
		@Order(5)
		public void addOrUpdateBankDetailsTest() {
			BankDetails bd = new BankDetails();
			bd.setAccountNo("696969696969");
			bd.setHolderName("holder name");
			bd.setIfscCode("jsdkf");
			bd.setStudent(studentService.searchByStudentId(100).get());

			assertNotNull(bankDetailsService.addBankDetails(bd));
		}
		
		@Test
		@Order(6)
		public void searchBankDetailsByIDTest() {
			assertNotNull(bankDetailsService.serachById(5000).get());
		}

		@Test
		@Order(7)
		public void searchBankDetailsByStudentIdTest() {
			assertNotNull(bankDetailsService.serachBankDetailsByStudentId(100));
		}
	
	
		// scholarship Type
	
		@Test
		@Order(8)
		public void addScholarshipType() {
			ScholarshipType st = new ScholarshipType();
			ScholarshipType s;
			st.setScholarshipName("Pragathi scholarship");
			st.setEligibilityCriteria("Girls only");
			assertNotNull(s = scholarshipTypeService.addScholarshipType(st));
			System.out.println(s.getScholarshipId());
		}
		
		@Test
		@Order(9)
		public void getScholarshipTypeById() {
			assertNotNull(scholarshipTypeService.searchByScholarshipTypeId(600).get());
		}
	
		//scholarshipApplication
		@Test
		@Order(10)
		public void addScholarshipApplication() {
			ScholarshipApplication schApp = new ScholarshipApplication();
			Student stud = studentService.searchByStudentId(100).get();
			
			schApp.setCaste("not");
			schApp.setReligion("hjk");
			schApp.setDisabilityStatus(DisabilityStatus.valueOf("NONE"));
			schApp.setScholarshipType(scholarshipTypeService.searchByScholarshipTypeId(600).get());
			schApp.setDateApplied(LocalDate.now());
			schApp.setStudent(stud);
			schApp.setAnnualIncome(25000);
			schApp.setTenthPercentage(89);
			schApp.setTwelfthPercentage(97);
			schApp.setFatherName("ssf");
			schApp.setMotherName("gfgf");
			schApp.setFatherOccupation("FARMER");
			schApp.setMotherOccupation("Teacher");
			schApp.setMotherAadhaarNo("784864649805");
			schApp.setFatherAadhaarNo("785643216754");
			
			assertNotNull(scholarApplicationService.addScholarshipForm(schApp));
		}
		
		@Test
		@Order(11)
		public void getAllScholarshipApplications() {
			assertTrue(scholarApplicationService.getAllApplications().size()>0);
		}
		
		@Test 
		@Order(12)
		public void searchApplicationById() {
			assertNotNull(scholarApplicationService.searchScholarshipApplicationById(12500));
		}
		
		@Test
		@Order(13)
		public void getApplicationByStudentId() {
			assertNotNull(scholarApplicationService.searchScholarshipApplicationByStudentId(100));
		}
		
		//add scholarship status
		
		@Test
		@Order(14)
		public void addScholarshipStatus() {
			ScholarshipStatus Ss = new ScholarshipStatus();
			Ss.setScholarshipApplication(scholarApplicationService.searchScholarshipApplicationById(12500));
			assertNotNull(studentStatusService.addScholarshipStatus(Ss));
		}
		
		//ApproveScholarshipApplications
		@Test
		@Order(15)
		public void approve1() {
			ApproveDto at = new ApproveDto();
			at.setApprover(1);
			at.setApproved(true);
			at.setScholarshipId(12500);
			String s = approveService.approve(at);
			assertTrue(s.equals("Success"));
		}
	
		@Test
		@Order(16)
		public void viewApplicationsForStateNodal() {
			List<ScholarshipApplication> list = scholarApplicationService.viewAllScholarshipApplicationsForSo();
			
			list.forEach(li->{
				System.out.println(li.getScholarshipId());
			});
			
			assertNotNull(list);
		}
		
		//ApproveScholarshipApplications
		@Test
		@Order(17)
		public void approve2() {
			ApproveDto at = new ApproveDto();
			at.setApprover(2);
			at.setApproved(true);
			at.setScholarshipId(12500);
			String s = approveService.approve(at);
			assertTrue(s.equals("Success"));
		}
		
		@Test
		@Order(18)
		public void viewApplicationsForMinistry() {
			List<ScholarshipApplication> list = scholarApplicationService.viewAllScholarshipApplicationsForMinistry();
			
			list.forEach(li->{
				System.out.println(li.getScholarshipId());
			});
			
			assertNotNull(list);
		}
	
	
		 // scholarshipDocuments
		@Test
		@Order(19)
		public void addOrUpdateStudentDocumentsTest() {
			ScholarshipDocuments sd = new ScholarshipDocuments();
			sd.setAadharCard("PAadhar");
			sd.setCasteOrIncomeCertificate("Income");
			sd.setDomecile("domecile");
			sd.setFeeReciept("feeReciept");
			sd.setIdCard("id");
			sd.setPassBook("passbook");
			sd.setPhoto("photo");
			sd.setTenthMarksheet("tenth");
			sd.setTwelfthMarksheet("twelft");
			sd.setScholarship(scholarApplicationService.searchScholarshipApplicationById(12500));
			assertNotNull(scholarshipDocumentService.addOrUpdateScholarshipDocuments(sd));
		}
		
		@Test
		@Order(20)
		public void searchStudentDocumentsByIdTest() {
			assertNotNull(scholarshipDocumentService.searchScholarshipDocumentsById(1000));
		}
	
		@Test
		@Order(21)
		public void searchStudentDocumentsByStudentIdTest() {
			assertNotNull(scholarshipDocumentService.searchScholarshipDocumentsByStudentId(100));
		}
		
		@Test
		@Order(22)
		public void searchStudentDocumentsByScholarshipId() {
			assertNotNull(scholarshipDocumentService.searchScholarshipDocumentsByScholarshipId(12500));
		}
		
		@Test
		@Order(23)
		public void viewApplicationsByInstituteId() {
			List<ScholarshipApplication> list = scholarApplicationService.viewAllScholarshipApplicationsByInstituteId(13000);
			list.forEach(li->{
				System.out.println(li.getScholarshipId());
			});
			
			assertNotNull(list);
		}
		

		//scholarshipStatus
		
	
		@Test
		@Order(24)
		public void findScholarshipStatusById() {
			assertNotNull(studentStatusService.findById(4780).get());
		}
		
		@Test
		@Order(25)
		public void getScholarshipStatusByStudentId() {
			assertNotNull(studentStatusService.getScholarshipStatusByStudentId(100));
		}
		
		@Test
		@Order(26)
		public void getScholarshipStatusBySchApplicationId() {
			assertNotNull(studentStatusService.getScholarshipStatusBySchApplicationId(12500));
		}
	
		//State Nodal
		@Test
		@Order(27)
		public void registerStateNodal() {
			StateNodal sn = new StateNodal();
			sn.setEmail("kerala@gmail.com");
			sn.setName("kerala");
			sn.setPassword("1234");
			sn.setState(States.KERALA);
			assertNotNull(stateNodalService.registerSNO(sn));
		}
		
		@Test
		@Order(28)
		public void loginSNO() {
			assertTrue(stateNodalService.login("kerala@gmail.com", "1234"));
		}
}
