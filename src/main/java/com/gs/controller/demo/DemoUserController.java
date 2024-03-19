package com.gs.controller.demo;

import com.gs.service.intf.DemoUserService;
import com.gs.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class DemoUserController {

    private DemoUserService demoUserService;

    @GetMapping("/detail")
    public R page(Long id) {
        return R.success(demoUserService.findById(id));
    }
}
