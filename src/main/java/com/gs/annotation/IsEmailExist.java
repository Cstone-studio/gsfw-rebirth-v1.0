package com.gs.annotation;



import com.gs.model.entity.jpa.db1.DemoUser;
import com.gs.repository.jpa.db1.DemoUserRepository;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import lombok.AllArgsConstructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 邮箱是否注册验证规则
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IsEmailExist.IsEmailExistValidator.class})
@Target({ElementType.METHOD,
         ElementType.FIELD,
         ElementType.ANNOTATION_TYPE,
         ElementType.CONSTRUCTOR,
         ElementType.PARAMETER})
public @interface IsEmailExist {

    String message() default "this email already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @AllArgsConstructor
    public class IsEmailExistValidator implements ConstraintValidator<IsEmailExist, String> {

        private final DemoUserRepository demoUserRepository;

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {

            if ("".equals(value) || null == value) {
                return false;
            }else{
                DemoUser emailExist = demoUserRepository.findByEmail(value);
                if (null == emailExist) {
                    return true;
                }else {
                    return false;
                }
            }
        }

        @Override
        public void initialize(IsEmailExist constraintAnnotation) {

        }
    }
}
