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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import App.quizz.model.AllQuestions;
import App.quizz.model.Response;
import App.quizz.model.questionWrapper;
import App.quizz.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;

	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String catagary,@RequestParam int numOfQue,@RequestParam String questonTitel){
	return  quizService.createQuiz(catagary,numOfQue,questonTitel);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<questionWrapper>> getQuizQuetions(@PathVariable Integer id ){
		return quizService.getQuizQuestions(id);
		
		
	}
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response){
		return quizService.calculateResult(id,response);
		
	}
	  
}
