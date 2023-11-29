package App.quizz.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import App.quizz.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
