package com.gs.service.intf;

import com.gs.model.dto.demo.DemoUserDTO;

public interface DemoUserService {

    /**
     * 根据id查找用户
     * @param Long id 主键id
     * @return DemoUserDTO
     */
    DemoUserDTO findById(Long id);
}
