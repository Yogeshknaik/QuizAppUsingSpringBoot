# QuizAppUsingSpringBoot
Steps->
1)create database and replase that database name  and password in  application.property  file and ALL SET
------------------Endpoints------------------
Add questions -> http://localhost:8080/question/add                      //(post)
Get all questions -> localhost:8080/question/allQuestions               //(get)
fetching ALL by Category -> localhost:8080/question/catagary/{category}    //(get)
fetching  limited questions  ->   http://localhost:8080/quiz/create?catagary=python Programming&numOfQue=1&questonTitel=What does the  //(get)
score-> http://localhost:8080/quiz/submit/1                              //(post)

