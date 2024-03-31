package com.gs.service.intf;

import com.gs.exception.IncorrectParameterException;
import com.gs.model.dto.base.IPageModel;
import com.gs.model.dto.demo.DemoUserDTO;
import com.gs.model.dto.demo.DemoUserLoginDTO;
import com.gs.model.dto.demo.DemoUserPageDTO;
import com.gs.model.entity.jpa.db1.DemoUser;
import org.springframework.data.domain.Pageable;

public interface DemoUserService {

    /**
     * 创建用户
     * @param DemoUserDTO dto 用户dto
     * @return DemoUserDTO 创建成功后的dto
     */
    DemoUserDTO create(DemoUserDTO dto);

    /**
     * 更新用户
     * @param DemoUserDTO dto 用户dto
     */
    void update(DemoUserDTO dto) throws IncorrectParameterException;

    /**
     * 删除用户
     * @param Long id 用户id
     */
    void delete(Long id);

    /**
     * 分页查询
     * @param param DrugOrderSearchParam
     */
    IPageModel<DemoUserDTO> list(DemoUserPageDTO param, Pageable pageable);

    /**
     * 根据id查找用户
     * @param Long id 主键id
     * @return DemoUserDTO
     */
    DemoUserDTO findById(Long id);

    /**
     * 用户登录
     * @param DemoUserLoginDTO demoUserLoginDTO 登录参数dto
     */
    DemoUser login(DemoUserLoginDTO demoUserLoginDTO);

    /**
     * 登录成功后保存token,用来检验重复登录
     * @param User 用户新信息
     */
    void loginSuccess(DemoUser demoUser);
}
