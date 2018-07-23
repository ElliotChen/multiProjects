package tw.elliot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import tw.elliot.conf.ApplicationConfig;

/**
 * Unit test for simple App.
 */
@SpringJUnitConfig(classes = ApplicationConfig.class)
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Value("${environment}")
    private String environment;
    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println(environment);
        Assertions.assertTrue( true );
    }
}
