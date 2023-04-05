package hiag0liveira.github.io.upcar.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValidation {
    String message() default "Email inválido.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}