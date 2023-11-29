package App.quizz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class AllQuestions{
	
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)// auto generates id
private Integer id;
private String questonTitel;
private String option1;
private String option2;
private String option3;
private String option4;
private String rightnswer;
private String diffLevel;
private String catagary;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getQuestonTitel() {
	return questonTitel;
}
public void setQuestonTitel(String questonTitel) {
	this.questonTitel = questonTitel;
}
public String getOption1() {
	return option1;
}
public void setOption1(String option1) {
	this.option1 = option1;
}
public String getOption2() {
	return option2;
}
public void setOption2(String option2) {
	this.option2 = option2;
}
public String getOption3() {
	return option3;
}
public void setOption3(String option3) {
	this.option3 = option3;
}
public String getOption4() {
	return option4;
}
public void setOption4(String option4) {
	this.option4 = option4;
}
public String getRightnswer() {
	return rightnswer;
}
public void setRightnswer(String rightnswer) {
	this.rightnswer = rightnswer;
}
public String getDiffLevel() {
	return diffLevel;
}
public void setDiffLevel(String diffLevel) {
	this.diffLevel = diffLevel;
}
public String getCatagary() {
	return catagary;
}
public void setCatagary(String catagary) {
	this.catagary = catagary;
}

public AllQuestions() {
	// constructor
}

public AllQuestions(Integer id, String questonTitel, String option1, String option2, String option3, String option4,
		String rightnswer, String diffLevel, String catagary) {
	super();
	this.id = id;
	this.questonTitel = questonTitel;
	this.option1 = option1;
	this.option2 = option2;
	this.option3 = option3;
	this.option4 = option4;
	this.rightnswer = rightnswer;
	this.diffLevel = diffLevel;
	this.catagary = catagary;
}




}
