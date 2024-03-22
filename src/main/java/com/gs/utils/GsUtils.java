package com.gs.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import com.gs.model.dto.base.IPageModel;
import org.springframework.data.domain.Page;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GsUtils {

    /**
     * 生成随机数
     *
     * @param int l 随机数长度
     */
    public static String generateRandomNumber(int l) {
        String tmp = String.format("%.".concat(String.valueOf(l)).concat("f"), Math.random());
        return tmp.substring(tmp.length() - l);
    }

    /**
     * 制作PrimaryKey
     *
     * @param List  复制元
     * @param Class 类
     */
    public static Set<String> generatePrimaryKeySet(List lists, String keyName) {
        Set<String> set = new HashSet<>();
        for (Object obj : lists) {
            Map<String, Object> map = BeanUtil.beanToMap(obj);
            if (MapUtil.getStr(map, keyName) != null) {
                set.add(MapUtil.getStr(map, keyName));
            }
        }
        return set;
    }

    public static <T> IPageModel<T> pageConvert(Page<T> page) {
        IPageModel<T> result = IPageModel.<T>builder()
                .records(page.stream().collect(Collectors.toList()))
                .total(page.getTotalElements())
                .size(page.getSize())
                .current(page.getNumber() + 1)
                .build();
        return result;
    }
}
