package com.student.student.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.student.beans.student.StudentVo;

@Service
public class StudentService {
	List<StudentVo> studentVos;
	{
//		Getting all Student list
		studentVos = new ArrayList<>();
		StudentVo studentVo = new StudentVo(1, "Sumit", "new Delhi", "sadasa@dsjd.com", "+9183309309");
		StudentVo studentVo1 = new StudentVo(2, "Zafar", "new Delhi", "sadasa@dsjd.com", "+9183309309");
		StudentVo studentVo2 = new StudentVo(3, "piyush", "new Delhi", "sadasa@dsjd.com", "+9183309309");

		studentVos.add(studentVo);
		studentVos.add(studentVo1);
		studentVos.add(studentVo2);
	}
	
//	Getting all Student list
	public List<StudentVo> getAllStudentDetails() {
		return studentVos;
	}

//	Getting list by id 
	public StudentVo getStudentVo(long id) {
		for (StudentVo obj : studentVos) {
			if (obj.getId() == id) {
				return obj;
			}
		}
		return null;
	}

//	adding student using postman
	
//	public void addStudent(StudentVo studentvo) {
//		studentVos.add(studentvo);
//	}
	
	
//	adding student by one id one list will create validation in postman
	
	public boolean addStudent(StudentVo studentVo) {
		boolean check=false;
		Iterator<StudentVo>iterator=studentVos.iterator();
		int flag=0;
		while(iterator.hasNext()) {
			StudentVo stud1=iterator.next();
			if(stud1.getId()==studentVo.getId()) {
				flag++;
			}
		}
		if(flag==0) {
			studentVos.add(studentVo);
			check=true;
		}
		return check;
	}
	
	
	
	
}
