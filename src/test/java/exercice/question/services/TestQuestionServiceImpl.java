package exercice.question.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.platform.commons.annotation.Testable;

import exercice.question.dto.NouvelleQuestion;
import exercice.question.entities.Question;
import exercice.question.repositories.QuestionRepository;
import exercice.question.repositories.fake.FakeQuestionRepository;
import exercice.question.services.impl.QuestionServiceImpl;

@Testable
public class TestQuestionServiceImpl {
	
	private QuestionRepository  repository  = new FakeQuestionRepository();
	private QuestionService questionService = new QuestionServiceImpl(repository);

	
	@Nested
	@TestInstance(Lifecycle.PER_CLASS)
	@DisplayName("Exercice 1")
	public class Exercice1 {
		NouvelleQuestion nouvelleQuestion = new NouvelleQuestion();
		Question question = new Question();
		List<String> reponses = new ArrayList<String>();
		
		@BeforeAll
		public void init() {
			nouvelleQuestion.setQuestion("TitreDeLaQuestion");
			reponses.add("Reponse 1");
			reponses.add("Reponse 2");
			reponses.add("Reponse 3");
			nouvelleQuestion.setReponses(reponses);

			question = questionService.nouvelleQuestion(this.nouvelleQuestion);
		}
		
		@Test
		@DisplayName("1.1 -> Quand on créer une Nouvellequestion, on récupère une Question possédant le même titre que la NouvelleQuestion")
		public void recuperationQuestionAvecTitreIdentiqueANouvelleQuestion() {
			
			assertEquals(nouvelleQuestion.getQuestion(), question.getTitre());
		}
		
		@Test
		@DisplayName("1.2 -> Quand on créer une Nouvellequestion, on récupère une Question possédant autant de reponses que la NouvelleQuestion")
		public void recuperationQuestionAvecCountReponseIdentiqueANouvelleQuestion() {
			
			assertEquals(nouvelleQuestion.getReponses().size(), question.getReponses().size());
		}
	}
}
