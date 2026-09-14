package com.imooc.tag.goods.common.advice;

import com.imooc.tag.goods.controller.vo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class MyControllerAdvice {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseResponse errorHandler(Exception e) {
        log.info("MyControllerAdvice|errorHandler msg={}", e.getMessage(), e);
        return BaseResponse.getFailResult(BaseResponse.class);
    }
}
