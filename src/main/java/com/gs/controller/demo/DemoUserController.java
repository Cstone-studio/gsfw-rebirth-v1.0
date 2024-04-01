package com.gs.controller.demo;

import com.gs.exception.IncorrectParameterException;
import com.gs.model.dto.demo.DemoUserDTO;
import com.gs.model.dto.request.DemoUserAddRequestDTO;
import com.gs.model.dto.request.DemoUserPageRequestDTO;
import com.gs.model.dto.request.DemoUserUpdateRequestDTO;
import com.gs.model.dto.response.DemoUserResponseDTO;
import com.gs.model.entity.jpa.db1.DemoUser;
import com.gs.service.intf.DemoUserService;
import com.gs.utils.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "demoUser")
@RestController
@RequestMapping("api/demouser")
@AllArgsConstructor
@Validated
public class DemoUserController extends BaseController {

    @Autowired
    private DemoUserService demoUserService;

    @Operation(summary = "add demo user")
    @PostMapping
    public R add(@Validated @RequestBody DemoUserAddRequestDTO demoUserAddRequestDTO) {
        demoUserService.create(demoUserAddRequestDTO);
        return R.success();
    }

    @Operation(summary = "edit demo user")
    @PutMapping
    public R update(@Validated @RequestBody DemoUserUpdateRequestDTO demoUserUpdateRequestDTO) throws IncorrectParameterException {
        demoUserService.update(demoUserUpdateRequestDTO);
        return R.success();
    }

    @Operation(summary = "delete demo user")
    @DeleteMapping
    public R del(@RequestParam("id") Long id) {
        demoUserService.delete(id);
        return R.success();
    }

    @Operation(summary = "search demo user", description = "search demo user")
    @GetMapping("/detail")
    public R<DemoUserResponseDTO> detail(@RequestParam("id") Long id) {
        return R.success(demoUserService.findById(id));
    }

    @Operation(summary = "paging query demo user")
    @GetMapping
    public R list(DemoUserPageRequestDTO params) {
        return R.success(demoUserService.list(params, PageRequest.of(
                params.getPage() - 1,
                params.getRows(),
                Sort.by("id").descending()))
        );
    }
}
