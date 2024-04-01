package com.gs.service.intf;

import com.gs.exception.IncorrectParameterException;
import com.gs.model.dto.base.IPageModel;
import com.gs.model.dto.demo.DemoUserDTO;
import com.gs.model.dto.request.DemoUserAddRequestDTO;
import com.gs.model.dto.request.DemoUserLoginRequestDTO;
import com.gs.model.dto.request.DemoUserPageRequestDTO;
import com.gs.model.dto.request.DemoUserUpdateRequestDTO;
import com.gs.model.dto.response.DemoUserResponseDTO;
import com.gs.model.entity.jpa.db1.DemoUser;
import org.springframework.data.domain.Pageable;

public interface DemoUserService {

    /**
     * 创建用户
     */
    DemoUserResponseDTO create(DemoUserAddRequestDTO demoUserAddRequestDTO);

    /**
     * 更新用户
     */
    void update(DemoUserUpdateRequestDTO demoUserUpdateRequestDTO) throws IncorrectParameterException;

    /**
     * 删除用户
     * @param Long id 用户id
     */
    void delete(Long id);

    /**
     * 分页查询
     */
    IPageModel<DemoUserResponseDTO> list(DemoUserPageRequestDTO param, Pageable pageable);

    /**
     * 根据id查找用户
     * @param Long id 主键id
     * @return DemoUserDTO
     */
    DemoUserResponseDTO findById(Long id);

    /**
     * 用户登录
     * @param DemoUserLoginRequestDTO demoUserLoginRequestDTO 登录参数dto
     */
    DemoUser login(DemoUserLoginRequestDTO demoUserLoginRequestDTO);

    /**
     * 登录成功后保存token,用来检验重复登录
     * @param User 用户新信息
     */
    void loginSuccess(DemoUser demoUser);
}
