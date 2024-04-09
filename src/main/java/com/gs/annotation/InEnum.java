package com.gs.annotation;

import com.gs.constant.enums.RoleEnum;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Constraint(validatedBy = {InEnum.InEnumValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@NotNull
public @interface InEnum {
    Class<? extends Enum<?>> enumClass();
    String message() default "role must be any of enum {enumClass}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @AllArgsConstructor
    public class InEnumValidator implements ConstraintValidator<InEnum, RoleEnum> {

        Set<String> values;

        @Override
        public void initialize(InEnum constraintAnnotation) {
            values = Stream.of(constraintAnnotation.enumClass().getEnumConstants())
                    .map(Enum::name)
                    .collect(Collectors.toSet());
        }

        @Override
        public boolean isValid(RoleEnum value, ConstraintValidatorContext context) {
            return values.contains(String.valueOf(value));
        }
    }
}