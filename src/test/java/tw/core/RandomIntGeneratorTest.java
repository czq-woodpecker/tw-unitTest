package tw.core;


import org.junit.Assert;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {

    @Test
    public void generateNumsTest() {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        String numsStr = randomIntGenerator.generateNums(9, 4);
        String[] numsArray = numsStr.split(" ");
        Assert.assertEquals(4, numsArray.length);
        boolean result = true;
        for (int i = 0; i < numsArray.length; i++) {
            try {
                int number = Integer.parseInt(numsArray[i]);
                if (number > 9) {
                    result = false;
                }
            } catch (NumberFormatException e) {
                result = false;
            }
        }
        Assert.assertEquals(true, result);
    }
}