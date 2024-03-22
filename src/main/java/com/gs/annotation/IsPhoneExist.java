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
 * 手机号是否已经注册验证规则
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IsPhoneExist.IsPhoneExistValidator.class})
@Target({ElementType.METHOD,
         ElementType.FIELD,
         ElementType.ANNOTATION_TYPE,
         ElementType.CONSTRUCTOR,
         ElementType.PARAMETER})
public @interface IsPhoneExist {

    String message() default "the phone number is registered";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @AllArgsConstructor
    public class IsPhoneExistValidator implements ConstraintValidator<IsPhoneExist, String> {

        private DemoUserRepository demoUserRepository;

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {

            if ("".equals(value) || null == value) {
                return false;
            }else{
                DemoUser mobileExist = demoUserRepository.findByMobile(value);
                if (null == mobileExist) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        @Override
        public void initialize(IsPhoneExist constraintAnnotation) {

        }
    }
}
