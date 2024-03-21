package com.gs.model.dto.demo;

import lombok.Data;

@Data
public class DemoUserLoginDTO {

//    @NotBlank(message = "账号不能为空")
    private String userName;

//    @NotBlank(message = "密码不能为空")
    private String password;
}
