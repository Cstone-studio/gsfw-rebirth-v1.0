package com.gs.model.dto.request;

import com.gs.annotation.IsEmailExist;
import com.gs.annotation.IsPhone;
import com.gs.annotation.IsPhoneExist;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DemoUserUpdateRequestDTO {

    @NotNull(message = "id is not null")
    private Long id;

    /**
     * 邮箱
     */
    @NotBlank(message = "email is not empty")
    @Email(message = "this email format is incorrect")
    @Schema(name = "email", description = "email", example = "")
    private String email;

    /**
     * 手机号
     */
    @NotBlank(message = "mobile is not empty")
    @IsPhone
    @Schema(name = "mobile", description = "mobile", example = "")
    private String mobile;
}
