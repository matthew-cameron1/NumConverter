package ca.innov8solutions.numconverter;

import ca.innov8solutions.numconverter.converters.IConverterService;
import ca.innov8solutions.numconverter.converters.IntToRomanConverter;
import org.junit.Test;
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
public class IntToRomanTest {

    @Configuration
    static class ContextConfig {
        @Bean
        public IConverterService<Integer> converterService() {
            return new IntToRomanConverter();
        }
    }

    private @Autowired
    IConverterService<Integer> converterService;

    @Test
    public void test1() {
        int num = 1;
        assertNotNull("Converter service cannot be null", converterService);

        String expected = "I";
        String actual = (String) converterService.convert(num);

        assertEquals("Expected: " + expected + " but got: " + actual, expected, actual);
    }

    @Test
    public void test349() {
        int num = 349;
        assertNotNull("Converter service cannot be null", converterService);

        String expected = "CCCXLIX";
        String actual = (String) converterService.convert(num);

        assertEquals("Expected: " + expected + " but got: " + actual, expected, actual);
    }
}
