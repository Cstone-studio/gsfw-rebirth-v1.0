package com.gs.convert;

import com.gs.model.dto.demo.DemoUserDTO;
import com.gs.model.entity.jpa.db1.DemoUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DemoUserConvert {
    DemoUserConvert INSTANCE = Mappers.getMapper( DemoUserConvert.class );

    @Mapping(target = "userName", source = "username")
    DemoUserDTO toDto(DemoUser source);

    DemoUser toEntity(DemoUserDTO source);
}
