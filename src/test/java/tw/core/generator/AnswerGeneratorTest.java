package tw.core.generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    RandomIntGenerator randomIntGenerator;

    @Before
    public void init() {
        randomIntGenerator = Mockito.mock(RandomIntGenerator.class);
        Mockito.when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
    }

    @Test
    public void generateTest() throws OutOfRangeAnswerException {
        String answerStr = new AnswerGenerator(randomIntGenerator).generate().toString();
        String[] numStrs = answerStr.split(" ");
        Assert.assertEquals(4, numStrs.length);
        boolean result = true;
        try {
            for (int i = 0; i < numStrs.length; i++) {
                int number = Integer.parseInt(numStrs[i]);
                if(number > 9) {
                    result = false;
                }
            }
        } catch (NumberFormatException e) {
            result = false;
        }
        Assert.assertEquals(true, result);
    }

}

