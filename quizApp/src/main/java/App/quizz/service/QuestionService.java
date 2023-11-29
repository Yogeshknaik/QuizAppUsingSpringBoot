package App.quizz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import App.quizz.Dao.QuestionDao;
import App.quizz.model.AllQuestions;

@Service // or you can use @Component
public class QuestionService {
	@Autowired
	QuestionDao questionDao;
	public ResponseEntity<List<AllQuestions>> getAllQuestion() {
	try {
		return new ResponseEntity<>( questionDao.findAll(),HttpStatus.OK);
	}
	catch(Exception e) {
		e.printStackTrace();

	}
	return new ResponseEntity<>( new ArrayList<>(),HttpStatus.BAD_REQUEST);
	
	}
	
	
	public ResponseEntity< List<AllQuestions>>getQuestionsByLang(String langName) {
	 
	
	try {
		return new ResponseEntity<>( questionDao.findBycatagary(langName),HttpStatus.OK);
	}
	catch(Exception e) {
		e.printStackTrace();

	}
	return new ResponseEntity<>( new ArrayList<>(),HttpStatus.BAD_REQUEST);
	
	}
	
	
	
	public ResponseEntity<String> addQuestion(AllQuestions question) {
		questionDao.save(question);
		return new ResponseEntity<>("sucess",HttpStatus.CREATED);
		
	}



}