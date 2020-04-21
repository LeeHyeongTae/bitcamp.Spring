package com.leeht.web.grade;

public interface GradeService {
	public void add(Grade grade);
	public Grade[] list();
	public Grade detail(String userid);
	public int count();
	public int total(Grade grade);
	public int average(Grade grade);
	public String grade(Grade grade);
	public void update(Grade grade);
	public void delete(Grade grade);
}
