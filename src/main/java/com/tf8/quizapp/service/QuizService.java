
package com.tf8.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.tf8.quizapp.model.dto.QuestionDTO;
import com.tf8.quizapp.model.dto.QuizDTO;
import com.tf8.quizapp.model.dto.QuizDetailDTO;
import com.tf8.quizapp.model.entity.*;

/*
 * @author SEWANOU OZA Ruben
 */
public interface QuizService {
	
	/**
     * Récupère la liste de tous les quiz prévus pour les jeux depuis la BDD
     * @return La liste des DTO de quiz.
     */
	public List<QuizDTO> quizGet();
	
	
	
	
	/**
	 * Récupère les questions associées à un quiz
	 * @param quizId L'ID du quiz
	 * @return La liste des DTO des questions du quiz correspondant
	 */
	public List<QuestionDTO> quizQuizIdQuestionsGet(Long quizId);
	
	
	/**
	 * Envoie un nouveau quiz dans la BDD
	 * @param newQuiz DTO du nouveau quiz à ajouter
	 * @return La DTO du quiz à ajouter dans la BDD
	 */
	public QuizEntity quizPost(QuizEntity body);
	
	
	/**
	 * Lier une question existante à un quiz
	 * @param quizId L'ID du quiz
	 * @return La DTO du quiz mis à jour
	 */
	/*
	public QuestionEntity quizQuizIdQuestionsPost(Long quizId);
	*/
	
	/**
	 * Supprime un quiz
	 * @param quizId L'ID du quiz à supprimer
	 */
	/*
	public void quizQuizIdDelete(Long quizId);
	*/
	
	/**
	 * Délier une question d'un quiz
	 * @param quizId L'ID du quiz
	 * @param questionId L'ID de la question
	 */
	
	
	/**
	 * Mettre à jour un quiz
	 * @param quizId L'ID d'un quiz
	 * @return La DTO pour le quiz à modifier
	 */
	public QuizEntity quizQuizIdPut(Long quizId, QuizEntity body);


	QuizDetailDTO quizQuizIdGetDetail(Long id);




	QuizDTO quizStart(Long id);




	QuizDTO quizFinish(Long id);




	QuestionDTO getCurrentQuestion(Long quizId);




	QuestionDTO getNextQuestion(Long id);
	
	
	/**
	 * Terminer un quiz
	 * @param quizId L'ID d'un quiz
	 * @return La DTO de l'état modifié du quiz
	 */
	/*
	public QuizEntity quizQuizIdControlFinishPost(Long quizId);
	*/
	
	/**
	 * Lancer un quiz
	 * @param quizId L'ID d'un quiz
	 * @return La DTO de l'état modifié du quiz
	 */
	/*
	public QuizEntity quizQuizIdControlStartPostt(Long quizId);
	*/
	
}
