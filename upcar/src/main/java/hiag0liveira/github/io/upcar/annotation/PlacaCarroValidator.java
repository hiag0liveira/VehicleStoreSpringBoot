package hiag0liveira.github.io.upcar.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlacaCarroValidator implements ConstraintValidator<PlacaCarroValidation, String>  {

        private Pattern padrao = Pattern.compile("^[a-zA-Z]{3}d[a-zA-Z]d{2}$");

    @Override
    public void initialize(PlacaCarroValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null || "".equals(value)) {
            return true;
        }

        Matcher matcher = padrao.matcher(value);
        return matcher.matches();
    }

}