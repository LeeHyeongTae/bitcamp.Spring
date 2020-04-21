package com.leeht.web.grade;

import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService{
	private Grade[] grades;
	private int count;
	public GradeServiceImpl() {
		grades = new Grade[5];
		count = 0;
	}
	@Override
	public void add(Grade grade) {
		grades[count] = grade;
		count++;
	}
	@Override
	public Grade[] list() {
		return grades;
	}
	@Override
	public Grade detail(String userid) {
		Grade returnGrade = null;
		for(int i=0; i<count; i++) {
			if(userid.equals(grades[i].getUserid())) {
				returnGrade = grades[i];
				break;
			}
		}
		return returnGrade;
	}
	@Override
	public void update(Grade grade) {
		for(int i=0; i<count; i++) {
			if(grade.getUserid().equals(grades[i].getUserid())) {
				grades[i] = grade;
				break;
			}
		}
	}
	@Override
	public void delete(Grade grade) {
		for(int i=0; i<count; i++) {
			if(grade.getUserid().equals(grades[i].getUserid())) {
				grades[i] = grades[count-1];
				grades[count-1] = null;
				count--;
				break;
			}
		}
	}
	@Override
	public int total(Grade grade) {
		int total = 
		Integer.parseInt(grade.getKorean()) 
		+Integer.parseInt(grade.getEnglish())
		+Integer.parseInt(grade.getMath())
		+Integer.parseInt(grade.getJava());
		return total;
	}
	@Override
	public int average(Grade grade) {
		int average = total(grade)/4;
		return average;
	}
	@Override
	public String grade(Grade grade) {
		String resultgrade = "F";
//		for(int i=0; i<count; i++) {
//			if(grade.getUserid().equals(grades[i].getUserid())) {
				switch(average(grade)/10) {
				case 9: resultgrade = "A"; break;
				case 8: resultgrade = "B"; break;
				case 7: resultgrade = "C"; break;
				case 6: resultgrade = "D"; break;
				case 5: resultgrade = "E"; break;
//				}
//			}
		}
				System.out.println(resultgrade);
		return resultgrade;
	}
	@Override
	public int count() {
		
		return count;
	}

}
