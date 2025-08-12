package com.edu.uptc.handlingstudent.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

import com.edu.uptc.handlingstudent.constants.CommonConstants;
import com.edu.uptc.handlingstudent.enums.ETypeFileEnum;
import com.edu.uptc.handlingstudent.interfaces.IActionsFile;
import com.edu.uptc.handlingstudent.model.Student;

public class HandlingPersistenceStudent extends FilePlain 
	implements IActionsFile  {
	
	private List<Student> listStudent;
	
	public HandlingPersistenceStudent() {
		listStudent = new ArrayList<>();
	}
	
	public Boolean addStudent(Student student) {
		if(Objects.isNull(this.findStudentByCode(student.getCode()))) {
			this.listStudent.add(student);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public Student findStudentByCode(String code) {
		for(Student student: this.listStudent) {
			if(student.getCode().contentEquals(code)) {
				return student;
			}
		}
		return null;
	}
	
	@Override
	public void loadFile(ETypeFileEnum eTypeFileEnum) {
		if(ETypeFileEnum.PLAIN.equals(eTypeFileEnum)) {
			this.loadFilePlain();
		}
		
	}
	
	@Override
	public void dumpFile(ETypeFileEnum eTypeFileEnum) {
		if(ETypeFileEnum.PLAIN.equals(eTypeFileEnum)) {
			this.dumpFilePlain();
		}
		
	}
	private void dumpFilePlain() {
		StringBuilder rutaArchivo = new StringBuilder();
		rutaArchivo.append(config.getPathFile());
		rutaArchivo.append(config.getNameFile());
		List<String> records = new ArrayList<>();
		 for(Student student : this.listStudent){
			 StringBuilder contentStudent = new StringBuilder();
			 contentStudent.append(student.getCode()).append(CommonConstants.SEMICOLON);
			 contentStudent.append(student.getName()).append(CommonConstants.SEMICOLON);
			 contentStudent.append(student.getCareer()).append(CommonConstants.SEMICOLON);
			 contentStudent.append(student.getNumberSemester()).append(CommonConstants.SEMICOLON);
			 contentStudent.append(student.getAge()).append(CommonConstants.SEMICOLON);
			 contentStudent.append(student.getGender());
			 records.add(contentStudent.toString());
		 }
		 this.writer(rutaArchivo.toString(), records);
	}
	
	private void loadFilePlain() {
		List<String> contentInLine = this.reader(
				config.getPathFile().concat(
						config.getNameFile()));
		contentInLine.forEach(row -> {
			StringTokenizer tokens = new StringTokenizer(
					row, CommonConstants.SEMICOLON);
			while(tokens.hasMoreElements()){
				String code = tokens.nextToken();
				String name = tokens.nextToken();
				String career = tokens.nextToken();
				int numberSemester = Integer.parseInt(tokens.nextToken());
				int age = Integer.parseInt(tokens.nextToken());
				String gender = tokens.nextToken();
				this.listStudent.add(new Student(code, name, career, numberSemester, 
						age, gender));
			}
		});
	}

	

}
