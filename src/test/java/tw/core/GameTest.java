package tw.core;

import com.google.inject.Inject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    AnswerGenerator answerGenerator;

    @Before
    public void init() throws OutOfRangeAnswerException {
        answerGenerator = Mockito.mock(AnswerGenerator.class);
        Answer answer = Answer.createAnswer("1 2 3 4");
        Mockito.when(answerGenerator.generate()).thenReturn(answer);
    }

    @Test
    public void guessTest() throws OutOfRangeAnswerException {
        Answer inputAnswer = Answer.createAnswer("1 2 3 4");
        Game game = new Game(answerGenerator);
        GuessResult guessResult = game.guess(inputAnswer);
        Assert.assertEquals("4A0B", guessResult.getResult());
    }
}
