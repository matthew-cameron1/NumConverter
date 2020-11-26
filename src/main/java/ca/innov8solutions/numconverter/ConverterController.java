package ca.innov8solutions.numconverter;

import ca.innov8solutions.numconverter.converters.IConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    private @Autowired @Qualifier("intToRomanService")
    IConverterService<Integer> intToRomanService;

    private @Autowired @Qualifier("romanToIntService")
    IConverterService<String> romanToIntService;

    @GetMapping(value = "/conversions/rtoi/{romanLiteral}", produces = "application/json")
    public int getIntFromRoman(@PathVariable String romanLiteral) {
        return (int) romanToIntService.convert(romanLiteral);
    }
    @GetMapping(value = "/conversions/itor/{decimalNumber}", produces = "application/json")
    public String getIntFromRoman(@PathVariable int decimalNumber) {
        return String.valueOf(intToRomanService.convert(decimalNumber));
    }
}
