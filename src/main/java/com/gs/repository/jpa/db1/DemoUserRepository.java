package com.gs.repository.jpa.db1;

import com.gs.model.entity.jpa.db1.DemoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoUserRepository extends JpaRepository<DemoUser, Long>, JpaSpecificationExecutor<DemoUser>  {
}
