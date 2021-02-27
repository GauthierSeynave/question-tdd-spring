package exercice.question.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
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
	@DisplayName("Exercice 1")
	public class Exercice1 {
		
		@Test
		@DisplayName("1.1 -> Quand on créer une Nouvellequestion, on récupère une Question possédant le même titre que la NouvelleQuestion")
		public void recuperationQuestionAvecTitreIdentiqueANouvelleQuestion() {
			NouvelleQuestion nouvelleQuestion = new NouvelleQuestion();
			nouvelleQuestion.setQuestion("TitreDeLaQuestion");
			
			Question question = questionService.nouvelleQuestion(nouvelleQuestion);
			assertEquals(nouvelleQuestion.getQuestion(), question.getTitre());
		}
	}
}
