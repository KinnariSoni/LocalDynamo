package com.testDynamoDB.testDynamoDB.entity;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "question_table")
public class Question {

	private Long questionId;
    private String questionText;
    private String options;
    
    public Question() {
		super();
	}
	public Question(Long questionId, String questionText, String options) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.options = options;
	}
	
	@DynamoDBHashKey(attributeName = "questionId")
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	
	@DynamoDBRangeKey(attributeName = "questionText")
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
	@DynamoDBAttribute(attributeName = "options")
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
    
    
}
