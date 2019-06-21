package tw.core;

import org.junit.Assert;
import org.junit.Test;
import tw.validator.InputValidator;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    @Test
    public void validateTest() {
        InputValidator inputValidator = new InputValidator();
        //验证小于10的数字数量是否为4
        Assert.assertEquals(true, inputValidator.validate("1 3 4 6"));
        Assert.assertEquals(false, inputValidator.validate("1 2 3 4 5"));
        Assert.assertEquals(false, inputValidator.validate("1 2 11 12"));
    }
}
