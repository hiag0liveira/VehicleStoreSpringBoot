package hiag0liveira.github.io.upcar.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Documented
@Constraint(validatedBy = PlacaCarroValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PlacaCarroValidation
{

    String message() default "Formato de placa inválido, digite por exemplo ABC1A23";
    Class[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}

