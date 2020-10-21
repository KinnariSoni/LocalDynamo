package com.testDynamoDB.testDynamoDB.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testDynamoDB.testDynamoDB.dtos.QuestionDTO;
import com.testDynamoDB.testDynamoDB.dtos.StudentDTO;
import com.testDynamoDB.testDynamoDB.service.StudentService;

@RestController
@RequestMapping("/dynamoDb")
public class DynamoDbController {
	@Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public StudentDTO insertIntoDynamoDB(@RequestBody StudentDTO dto) {
    	System.out.print("Student :"+dto);
        return  studentService.insertIntoDynamoDB(dto);
    }
    
    @PostMapping("/retrieve")
    public StudentDTO getData(@RequestBody StudentDTO dto) {
        return  studentService.getStudentData(dto);
    }
    
    @PostMapping("/retrieveAll")
    public List<StudentDTO> getAllData() {
        return  studentService.getAllStudentData();
    }
    
    @PostMapping("/saveQuestion")
    public QuestionDTO insertQnAIntoDynamoDB(@RequestBody QuestionDTO dto) { 
    	System.out.print("Question :"+dto);
        return  studentService.insertQnAIntoDynamoDB(dto);
    }
    
    @PostMapping("/retrieveAllQuestions")
    public List<QuestionDTO> getAllQuestions() {
        return  studentService.getAllQuestionData();
    }
}
