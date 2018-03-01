package com.itfan.kernel.service;

import com.itfan.user.service.UserService;
import com.itfan.kernel.fallback.UserFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author: ralap
 * @date: created at 2018/1/11 16:35
 */
@FeignClient(name = "itfan-user-provider", fallbackFactory = UserFallbackFactory.class)
public interface UserServicePxy extends UserService {

}
