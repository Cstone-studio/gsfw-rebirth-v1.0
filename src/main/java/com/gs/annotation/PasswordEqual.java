package com.gs.annotation;

import com.gs.model.dto.demo.DemoUserDTO;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 两次输入密码是否一致验证规则
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = {PasswordEqual.PasswordUserValidator.class})
public @interface PasswordEqual {

    // 校验未通过时的返回信息
    String message() default "The two passwords are different";

    // 以下两行为固定模板
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class PasswordUserValidator implements ConstraintValidator<PasswordEqual, DemoUserDTO> {

        @Override
        public boolean isValid(DemoUserDTO changePasswordDto, ConstraintValidatorContext constraintValidatorContext) {
            String newPassword = changePasswordDto.getPassword();
            String confirmPassword = changePasswordDto.getConfirmPassword();
            return newPassword.equals(confirmPassword);
        }

        @Override
        public void initialize(PasswordEqual constraintAnnotation) {
        }
    }
}
