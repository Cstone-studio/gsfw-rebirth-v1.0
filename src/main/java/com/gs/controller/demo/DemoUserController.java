package com.gs.controller.demo;

import com.gs.model.entity.jpa.db1.DemoUser;
import com.gs.service.intf.DemoUserService;
import com.gs.utils.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "demoUser")
@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class DemoUserController extends BaseController {

    private DemoUserService demoUserService;

    @Operation(summary = "search demo user", description = "search demo user")
    @GetMapping("/detail")
    public R<DemoUser> detail(Long id) {
        return R.success(demoUserService.findById(id));
    }
}
