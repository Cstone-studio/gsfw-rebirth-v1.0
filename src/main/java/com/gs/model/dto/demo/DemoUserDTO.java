package com.gs.model.dto.demo;

import com.gs.annotation.IsEmailExist;
import com.gs.annotation.IsPhone;
import com.gs.annotation.IsPhoneExist;
import com.gs.annotation.PasswordEqual;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@PasswordEqual
public class DemoUserDTO {

    private Long id;

    /**
     * 用户名
     */
    @NotBlank(message = "userName is not empty")
    @Schema(name = "userName", description = "user name", example = "")
    private String userName;

    /**
     * 密码
     */
    @NotBlank(message = "password is not empty")
    @Schema(name = "password", description = "password", example = "")
    private String password;

    /**
     * 确认密码
     */
    @NotBlank(message = "confirm password is not empty")
    @Schema(name = "confirmPassword", description = "confirm password", example = "")
    private String confirmPassword;

    /**
     * 邮箱
     */
    @NotBlank(message = "email is not empty")
    @Email(message = "this email format is incorrect")
    @IsEmailExist
    @Schema(name = "email", description = "email", example = "")
    private String email;

    /**
     * 手机号
     */
    @NotBlank(message = "mobile is not empty")
    @IsPhone
    @IsPhoneExist
    @Schema(name = "mobile", description = "mobile", example = "")
    private String mobile;
}
