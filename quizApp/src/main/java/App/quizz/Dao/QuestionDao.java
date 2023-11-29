package App.quizz.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import App.quizz.model.AllQuestions;

@Repository
public interface QuestionDao extends JpaRepository<AllQuestions, Integer> {
   List<AllQuestions> findBycatagary(String catagary);
   
   @Query(value = "SELECT * FROM all_questions q Where q.catagary=:catagary ORDER BY RANDOM() LIMIT :numOfQue", nativeQuery = true)
   List<AllQuestions> findRandomQuestionsByCatagory(@Param("catagary") String catagary, @Param("numOfQue") int numOfQue);
}
