package com.gs.model.dto.base;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BasePage {

    private Integer page;

    private Integer rows;
}
