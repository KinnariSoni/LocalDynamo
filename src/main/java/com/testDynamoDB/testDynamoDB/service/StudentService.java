package com.testDynamoDB.testDynamoDB.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.testDynamoDB.testDynamoDB.dtos.QuestionDTO;
import com.testDynamoDB.testDynamoDB.dtos.StudentDTO;
import com.testDynamoDB.testDynamoDB.entity.Question;
import com.testDynamoDB.testDynamoDB.entity.Student;

@Service
public class StudentService {
	@Autowired
    private DynamoDBMapper mapper;

    public StudentDTO insertIntoDynamoDB(StudentDTO dto) {
        Student student = new Student();
        student.setStudentId(Long.parseLong(dto.getStudentId()));
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        mapper.save(student);
        return convertDto(student);
    }
    
    public StudentDTO getStudentData(StudentDTO dto) {
    	 Student student = mapper.load(Student.class,new Long(dto.getStudentId()),dto.getFirstName());
        return convertDto(student);
    }
    
    public List<StudentDTO> getAllStudentData() {
    	
    	List<StudentDTO> listStudent = new ArrayList<StudentDTO>();
    	
    	DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
    	List<Student> scanResult = mapper.scan(Student.class, scanExpression);
    	
    	for (Student student : scanResult) {
    		listStudent.add(convertDto(student));
    	}
       return listStudent;
   }
    
    public QuestionDTO insertQnAIntoDynamoDB(QuestionDTO dto) {
    	String strOption = String.join(",", dto.getOptions());
    	
        Question question = new Question();
        question.setQuestionId(Long.parseLong(dto.getQuestionId()));
        question.setQuestionText(dto.getQuestionText());
        question.setOptions(strOption);
        mapper.save(question);
        return convertQnADto(question);
    }
    
    public StudentDTO convertDto(Student student){
        return new StudentDTO(
                student.getStudentId().toString(),
                student.getFirstName(),
                student.getLastName()
        );
    }
    
	public List<QuestionDTO> getAllQuestionData() {
    	
		List<QuestionDTO> listQuestion = new ArrayList<QuestionDTO>();
	   	
	   	DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
	   	List<Question> scanResult = mapper.scan(Question.class, scanExpression);
	   	
    	for (Question question : scanResult) {
    		listQuestion.add(convertQnADto(question));
	    }
	    return listQuestion;
   }
    
    public QuestionDTO convertQnADto(Question question){
    	List<String> options = Arrays.asList(question.getOptions().split("\\s*,\\s*"));
    	System.out.println("options:"+options);
        return new QuestionDTO(
        		question.getQuestionId().toString(),
        		question.getQuestionText(),
        		options
        );
    }

}
