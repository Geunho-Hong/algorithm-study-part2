package min;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class CharacterArrayConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && char[].class.isAssignableFrom(targetType)) {
            return ((String) source).toCharArray();
        }
        throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                + targetType + " not supported.");
    }
}
