package App.quizz.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	@ManyToMany
	private List<AllQuestions> question;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<AllQuestions> getQuestion() {
		return question;
	}
	public void setQuestion(List<AllQuestions> question) {
		this.question = question;
	}
	
	public Quiz() {
		
	}
	
	public Quiz(Integer id, String title, List<AllQuestions> question) {
		super();
		this.id = id;
		this.title = title;
		this.question = question;
	}
	

}
