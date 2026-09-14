package com.imooc.tag.goods.common.aspect.impl;

import com.imooc.tag.goods.entity.BaseEntity;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;

@Aspect
@Component
public class AutoFillDefaultValueAspect {
    @Pointcut(value = "@annotation(com.imooc.tag.goods.common.aspect.annotation.AutoFillDefaultValue)")
    public void pointCut() {

    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes =  (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = servletRequestAttributes.getRequest();
        if ("POST".equals(request.getMethod())) {
            if (joinPoint.getArgs().length > 0) {
                Object[] args = joinPoint.getArgs();
                for (Object arg : args) {
                    if (arg instanceof BaseEntity baseEntity) {
                        baseEntity.setCreator(0);
                        baseEntity.setModifier(0);
                        baseEntity.setCreateTime(new Date());
                        baseEntity.setModifyTime(new Date());
                    }
                }
            }
        }
    }
}
