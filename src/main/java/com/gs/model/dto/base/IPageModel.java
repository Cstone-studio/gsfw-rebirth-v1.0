package com.gs.model.dto.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IPageModel<T> {

    public Integer current;

    public Long total;

    public List<T> records;

    public Integer size;
}
