package com.gs.controller;

import com.gs.constant.enums.CodeEnum;
import com.gs.convert.DemoUserConvert;
import com.gs.model.dto.demo.DemoUserDTO;
import com.gs.model.dto.request.DemoUserLoginRequestDTO;
import com.gs.model.dto.response.DemoUserResponseDTO;
import com.gs.model.entity.jpa.db1.DemoUser;
import com.gs.repository.jpa.db1.DemoUserRepository;
import com.gs.service.impl.JwtService;
import com.gs.service.intf.DemoUserService;
import com.gs.utils.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "login")
@RestController
@RequestMapping("api/")
@AllArgsConstructor
@Validated
public class LoginController {

    @Autowired
    private DemoUserService demoUserService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private DemoUserRepository demoUserRepository;

    @Autowired
    private DemoUserConvert demoUserConvert;

    @Operation(summary = "user login")
    @PostMapping(value = "/login")
    public R login(@Validated @RequestBody DemoUserLoginRequestDTO demoUserLoginRequestDTO) {

        DemoUser demoUser = demoUserService.login(demoUserLoginRequestDTO);

        if (null == demoUser || demoUser.getDeleted()) {
            return R.error(CodeEnum.IS_FAIL.getCode(), "用户名或密码错误");
        }

        // 创建token
        String token = jwtService.generateToken(demoUser);

        demoUser.setToken(token);
        demoUserService.loginSuccess(demoUser);

        Map<String, String> result = new HashMap<>();
        result.put("token", token);
        result.put("userId", String.valueOf(demoUser.getId()));

        return R.success(result);
    }

    @Operation(summary = "get demo user info by token")
    @PostMapping(value = "/getUserInfo")
    public R getUserInfo() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        DemoUserResponseDTO demoUserDTO = demoUserRepository.findByUserName(userDetails.getUsername()).map(demoUser -> demoUserConvert.toDto(demoUser)).orElse(null);
        if (null == demoUserDTO) {
            return R.error(CodeEnum.IS_FAIL.getCode(), "账号不存在");
        }

        Map<String, Object> result = new HashMap<>();
        result.put("user", demoUserDTO);
        return R.success(result);
    }
}
