package ca.innov8solutions.numconverter.converters;

import org.springframework.stereotype.Service;

@Service
public interface IConverterService<T> {

    Object convert(T toConvert);

}
