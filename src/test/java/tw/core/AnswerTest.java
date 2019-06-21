package tw.core;

import org.junit.Assert;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;

import java.util.Arrays;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {

    @Test
    public void createAnswerTest() {
        Assert.assertEquals("1 2 3 4", Answer.createAnswer("1 2 3 4").toString());
        Assert.assertEquals("2 1 6 5", Answer.createAnswer("2 1 6 5").toString());
    }


    @Test(expected = OutOfRangeAnswerException.class)
    public void validateTest() throws OutOfRangeAnswerException {
        Answer answer = new Answer();
        answer.setNumList(Arrays.asList("1", "2", "3", "11"));
        answer.validate();
    }

    @Test
    public void checkTest() {
        Answer expectedAnswer = Answer.createAnswer("1 2 3 4");
        Answer answer1 = Answer.createAnswer("1 5 6 7");
        Answer answer2 = Answer.createAnswer("2 4 7 8");
        Answer answer3 = Answer.createAnswer("0 3 2 4");
        Answer answer4 = Answer.createAnswer("5 6 7 8");
        Answer answer5 = Answer.createAnswer("4 3 2 1");
        Answer answer6 = Answer.createAnswer("1 2 3 4");
        Answer answer7 = Answer.createAnswer("1 1 2 3");
        Answer answer8 = Answer.createAnswer("1 2");
        Assert.assertEquals("1A0B", expectedAnswer.check(answer1).getValue());
        Assert.assertEquals("0A2B", expectedAnswer.check(answer2).getValue());
        Assert.assertEquals("1A2B", expectedAnswer.check(answer3).getValue());
        Assert.assertEquals("0A0B", expectedAnswer.check(answer4).getValue());
        Assert.assertEquals("0A4B", expectedAnswer.check(answer5).getValue());
        Assert.assertEquals("4A0B", expectedAnswer.check(answer6).getValue());

        Assert.assertEquals("1A2B", expectedAnswer.check(answer7).getValue());
        Assert.assertEquals("2A0B", expectedAnswer.check(answer8).getValue());
    }
}