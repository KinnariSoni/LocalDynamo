package com.testDynamoDB.testDynamoDB.dtos;

import java.util.List;

public class QuestionDTO {
	
	private String questionId;
    private String questionText;
    private List<String> options;
    
	public QuestionDTO() {
		super();
	}
	
	public QuestionDTO(String questionId, String questionText, List<String> options) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.options = options;
	}
	
	public String getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
	public String getQuestionText() {
		return questionText;
	}
	
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
	public List<String> getOptions() {
		return options;
	}
	
	public void setOptions(List<String> options) {
		this.options = options;
	}
	
	@Override
	public String toString() {
		return "QuestionDTO [questionId=" + questionId + ", questionText=" + questionText + ", options=" + options
				+ "]";
	}
}
