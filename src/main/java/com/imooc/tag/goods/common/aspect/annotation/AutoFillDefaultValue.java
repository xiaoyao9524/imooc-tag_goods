package com.imooc.tag.goods.common.aspect.annotation;
import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AutoFillDefaultValue {
}
