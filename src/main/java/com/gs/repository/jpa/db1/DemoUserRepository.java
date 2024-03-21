package com.gs.repository.jpa.db1;

import com.gs.model.entity.jpa.db1.DemoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface DemoUserRepository extends JpaRepository<DemoUser, Long>, JpaSpecificationExecutor<DemoUser>  {
    Optional<DemoUser> findByUserName(String userName);
}
