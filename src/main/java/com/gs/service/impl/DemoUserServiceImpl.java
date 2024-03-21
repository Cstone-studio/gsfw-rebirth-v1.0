package com.gs.service.impl;

import com.gs.convert.DemoUserConvert;
import com.gs.model.dto.demo.DemoUserDTO;
import com.gs.model.dto.demo.DemoUserLoginDTO;
import com.gs.model.entity.jpa.db1.DemoUser;
import com.gs.repository.jpa.db1.DemoUserRepository;
import com.gs.service.intf.DemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Service
@Transactional(propagation = Propagation.SUPPORTS, transactionManager = "transactionManager" , readOnly = true, rollbackFor = Exception.class)
public class DemoUserServiceImpl implements DemoUserService {

    @Autowired
    private DemoUserRepository demoUserRepository;

    @Autowired
    private DemoUserConvert demoUserConvert;

    @Override
    public DemoUserDTO findById(Long id) {
        return demoUserRepository.findById(id).map(demoUser -> demoUserConvert.toDto(demoUser)).orElse(null);
    }

    @Override
    public DemoUser login(DemoUserLoginDTO demoUserLoginDTO) {
        return demoUserRepository.findByUserNameAndPassword(demoUserLoginDTO.getUserName(), DigestUtils.md5DigestAsHex(demoUserLoginDTO.getPassword().getBytes()));
    }

    @Override
    public void loginSuccess(DemoUser demoUser) {
        demoUserRepository.save(demoUser);
    }
}
