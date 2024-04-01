package com.gs.service.impl;

import com.gs.convert.DemoUserConvert;
import com.gs.exception.IncorrectParameterException;
import com.gs.model.dto.base.IPageModel;
import com.gs.model.dto.demo.DemoUserDTO;
import com.gs.model.dto.request.DemoUserAddRequestDTO;
import com.gs.model.dto.request.DemoUserLoginRequestDTO;
import com.gs.model.dto.request.DemoUserPageRequestDTO;
import com.gs.model.dto.request.DemoUserUpdateRequestDTO;
import com.gs.model.dto.response.DemoUserResponseDTO;
import com.gs.model.entity.jpa.db1.DemoUser;
import com.gs.repository.jpa.db1.DemoUserRepository;
import com.gs.repository.jpa.db1.spec.DemoUserSpecification;
import com.gs.service.intf.DemoUserService;
import com.gs.utils.GsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, transactionManager = "transactionManager" , readOnly = true, rollbackFor = Exception.class)
public class DemoUserServiceImpl implements DemoUserService {

    @Autowired
    private DemoUserRepository demoUserRepository;

    @Autowired
    private DemoUserSpecification<DemoUser> demoUserSpecification;

    @Autowired
    private DemoUserConvert demoUserConvert;

    @Override
    public DemoUserResponseDTO create(DemoUserAddRequestDTO demoUserAddRequestDTO) {
        DemoUser demoUser = demoUserRepository.save(demoUserConvert.toEntity(demoUserAddRequestDTO));
        return demoUserConvert.toDto(demoUser);
    }

    @Override
    public void update(DemoUserUpdateRequestDTO demoUserUpdateRequestDTO) throws IncorrectParameterException {

        if (demoUserUpdateRequestDTO.getId() == null) {
            throw new IncorrectParameterException("id must not be null");
        }

        Optional<DemoUser> optional = demoUserRepository.findById(demoUserUpdateRequestDTO.getId());
        if (optional.isPresent()) {
            DemoUser demoUser = optional.get();

            if (demoUserUpdateRequestDTO.getMobile() != null) {
                demoUser.setMobile(demoUserUpdateRequestDTO.getMobile());
            }
            if (demoUserUpdateRequestDTO.getEmail() != null) {
                demoUser.setEmail(demoUserUpdateRequestDTO.getEmail());
            }

            demoUserRepository.save(demoUser);
        } else {
            throw new IncorrectParameterException(
                    "update target User(id:" + String.valueOf(demoUserUpdateRequestDTO.getId()) + ") is not exist");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<DemoUser> optionalNews = demoUserRepository.findById(id);
        if(optionalNews.isPresent()){
            DemoUser demoUser = optionalNews.get();
            demoUser.setDeleted(true);
            demoUserRepository.save(demoUser);
            // userRepository.deleteById(id);
        }
    }

    @Override
    public IPageModel<DemoUserResponseDTO> list(DemoUserPageRequestDTO param, Pageable pageable) {
        Page<DemoUser> demoUserPage = demoUserRepository.findAll(
                Specification.where(demoUserSpecification.mobileLike(param.getMobile()))
                        .and(demoUserSpecification.userNameEqualsTo(param.getUserName())
                        .and(demoUserSpecification.emailNotEqualsTo(param.getEmail()))), pageable
        );

        return GsUtils.pageConvert(demoUserPage.map(entity -> demoUserConvert.toDto(entity)));
    }

    @Override
    public DemoUserResponseDTO findById(Long id) {
        return demoUserRepository.findById(id).map(demoUser -> demoUserConvert.toDto(demoUser)).orElse(null);
    }

    @Override
    public DemoUser login(DemoUserLoginRequestDTO demoUserLoginRequestDTO) {
        return demoUserRepository.findByUserNameAndPassword(demoUserLoginRequestDTO.getUserName(), DigestUtils.md5DigestAsHex(demoUserLoginRequestDTO.getPassword().getBytes()));
    }

    @Override
    public void loginSuccess(DemoUser demoUser) {
        demoUserRepository.save(demoUser);
    }
}
