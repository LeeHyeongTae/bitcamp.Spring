package com.leeht.web.grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leeht.web.util.Credit;
import com.leeht.web.util.Messenger;

@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired GradeService gradeService;
	
	@PostMapping("/register")
	public Messenger add(@RequestBody Grade grade) {
	int current = gradeService.count();
	gradeService.add(grade);
	int count = gradeService.count();
	return (count == current+1)? Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@PostMapping("/report")
	public Credit report(@RequestBody Grade grade) {
		Credit result = Credit.F;
		switch(gradeService.grade(grade)) {
		case "A": result = Credit.A;  break;
		case "B": result = Credit.B;  break;
		case "C": result = Credit.C;  break;
		case "D": result = Credit.D;  break;
		case "E": result = Credit.E;  break;
		}
		
		return result;
	}
}
