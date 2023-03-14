package com.lti.utils;

import java.util.Arrays;

import com.lti.entity.Gender;

public class Eligibility {
	
	public boolean meritBasedScholarship(
			double tenthMark,double twlethMark,
			int numberOfMemebersAlreadyAppliedThisScholarship
			) {
		if(tenthMark>= 60.0 && twlethMark>=60.0 )
			if(numberOfMemebersAlreadyAppliedThisScholarship<=1)
				return true;
		return false;
	}
	
	public boolean pragathiScholarship(
			Gender gender,int annualIncome,int numberOfGirlChildrens,
			double currentCoursePercent
			) {
		if(gender == Gender.FEMALE) 
			if(annualIncome<=8_00_000)
				if(currentCoursePercent>=60.0)
					if(numberOfGirlChildrens<=2)
						return true;
		return false;
	}
	
	public boolean meritNIST(double markAtNineth,String category) {
		String categories[] = {"SC","ST","PH"};
		if(markAtNineth > 60.0)
			return true;
		boolean result = Arrays.stream(categories).
		anyMatch(cate -> cate.equals(category.toUpperCase()));
		return result;
	}
}
