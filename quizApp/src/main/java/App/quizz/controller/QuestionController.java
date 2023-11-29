package App.quizz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import App.quizz.model.AllQuestions;
import App.quizz.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<AllQuestions>> getAllQuestion() {
		
		return questionService.getAllQuestion();
		
	}
	
	@GetMapping("catagary/{langName}")
	public ResponseEntity<List<AllQuestions>>getQuestionsByLang(@PathVariable String langName) {
		
		return  questionService.getQuestionsByLang(langName);
		
	}
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody AllQuestions question) {
		
		return questionService.addQuestion(question);
	}

	
} 
