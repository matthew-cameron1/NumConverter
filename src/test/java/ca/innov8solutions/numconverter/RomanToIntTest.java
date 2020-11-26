package ca.innov8solutions.numconverter;

import ca.innov8solutions.numconverter.converters.IConverterService;
import ca.innov8solutions.numconverter.converters.RomanToIntConverter;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class RomanToIntTest {

    @Configuration
    static class ContextConfig {
        @Bean
        public IConverterService<String> converterService() {
            return new RomanToIntConverter();
        }
    }

    private @Autowired
    IConverterService<String> converterService;

    @Test
    public void testXI() {
        String romanLiteral = "XI";
        assertNotNull("Converter service cannot be null", converterService);

        int expected = 11;
        int actual = (int) converterService.convert(romanLiteral);

        assertEquals("Expected: " + expected + " but got: " + actual, expected, actual);
    }

    @Test
    public void testI() {
        String romanLiteral = "I";
        assertNotNull("Converter service cannot be null", converterService);

        int expected = 1;
        int actual = (int) converterService.convert(romanLiteral);

        assertEquals("Expected: " + expected + " but got: " + actual, expected, actual);
    }

    @Test
    public void testMD() {
        String romanLiteral = "MD";
        assertNotNull("Converter service cannot be null", converterService);

        int expected = 1500;
        int actual = (int) converterService.convert(romanLiteral);

        assertEquals("Expected: " + expected + " but got: " + actual, expected, actual);
    }
}
