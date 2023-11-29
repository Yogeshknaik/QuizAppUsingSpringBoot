package App.quizz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import App.quizz.Dao.QuestionDao;
import App.quizz.Dao.QuizDao;
import App.quizz.model.AllQuestions;
import App.quizz.model.Quiz;
import App.quizz.model.Response;
import App.quizz.model.questionWrapper;
@Component
public class QuizService {
	@Autowired
	QuizDao quizDao;
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz( String catagary, int numOfQue, String questonTitel) {
	
		List<AllQuestions> questions = questionDao.findRandomQuestionsByCatagory(catagary,numOfQue);
		Quiz quiz=new Quiz();
		quiz.setTitle(questonTitel);
		quiz.setQuestion(questions);
		
		quizDao.save(quiz);
		return new  ResponseEntity<>("sucess",HttpStatus.CREATED);
		
		
	}

	public  ResponseEntity<List<questionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz=	quizDao.findById(id);
		List<AllQuestions> questionsFromDb=quiz.get().getQuestion();
		List<questionWrapper> questionForUsers =new ArrayList<questionWrapper>();
		for(AllQuestions q :questionsFromDb) {
			
			questionWrapper qw =new questionWrapper(q.getId(),q.getQuestonTitel(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionForUsers.add(qw);
		}
	return new ResponseEntity<List<questionWrapper>>(questionForUsers,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
		Quiz quiz=quizDao.findById(id).get();
		List<AllQuestions> questions =quiz.getQuestion();
		int right =0;
		int i=0;
		for(Response respons:response) {
		if(respons.getResponse().equals(questions.get(i).getRightnswer()))
			right++;
		i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
}
