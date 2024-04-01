package com.gs.model.dto.request;

import com.gs.model.dto.base.BasePage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DemoUserPageRequestDTO extends BasePage {

    @Schema(name = "userName", description = "user name", example = "")
    private String userName;

    @Schema(name = "email", description = "email", example = "")
    private String email;

    @Schema(name = "mobile", description = "mobile", example = "")
    private String mobile;
}