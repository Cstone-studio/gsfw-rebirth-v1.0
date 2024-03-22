package com.gs.model.dto.demo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(name = "DemoUserLoginDTO", description = "検索条件")
public class DemoUserLoginDTO {

    @NotBlank(message = "账号不能为空")
    @Schema(name = "userName", description = "用户名", example = "")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Schema(name = "password", description = "密码", example = "")
    private String password;
}
