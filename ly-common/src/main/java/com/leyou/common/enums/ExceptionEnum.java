package com.leyou.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    BRAND_NOT_FONUND(404,"价格不能为空"),
    CATEGORY_NOT_FOND(404,"匹配分类没找到"),
    ;
    private int code;
    private String msg;

}
