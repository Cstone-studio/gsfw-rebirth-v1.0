package com.gs.controller.demo;

import com.gs.constant.enums.CodeEnum;
import com.gs.convert.DemoUserConvert;
import com.gs.model.dto.demo.DemoUserDTO;
import com.gs.model.dto.demo.DemoUserLoginDTO;
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
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "demoUser")
@RestController
@RequestMapping("api/demouser")
@AllArgsConstructor
@Validated
public class DemoUserController extends BaseController {

    @Autowired
    private DemoUserService demoUserService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private DemoUserRepository demoUserRepository;

    @Autowired
    private DemoUserConvert demoUserConvert;

    @Operation(summary = "add demo user")
    @PostMapping
    public R add(@Validated @RequestBody DemoUserDTO userDTO) {
        demoUserService.create(userDTO);
        return R.success();
    }

    @Operation(summary = "edit demo user")
    @PutMapping
    public R update(@Validated @RequestBody DemoUserDTO userDTO) {
        demoUserService.update(userDTO);
        return R.success();
    }

//    @ApiOperation(value = "删除用户")
//    @DeleteMapping
//    public R del(@RequestParam("id") Long id) {
//        userService.delete(id);
//        return R.success();
//    }

    @Operation(summary = "search demo user", description = "search demo user")
    @GetMapping("/detail")
    public R<DemoUser> detail(Long id) {
        return R.success(demoUserService.findById(id));
    }

    @Operation(summary = "user login")
    @PostMapping(value = "/login")
    public R login(@Validated @RequestBody DemoUserLoginDTO demoUserLoginDTO) {

        DemoUser demoUser = demoUserService.login(demoUserLoginDTO);

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
        DemoUserDTO demoUserDTO = demoUserRepository.findByUserName(userDetails.getUsername()).map(demoUser -> demoUserConvert.toDto(demoUser)).orElse(null);
        if (null == demoUserDTO) {
            return R.error(CodeEnum.IS_FAIL.getCode(), "账号不存在");
        }

        Map<String, Object> result = new HashMap<>();
        result.put("user", demoUserDTO);
        return R.success(result);
    }
}
