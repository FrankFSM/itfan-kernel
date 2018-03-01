package com.itfan.kernel.service;

import com.itfan.analy.service.AnalyService;
import com.itfan.kernel.fallback.AnalyFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author: ralap
 * @date: created at 2018/1/13 14:28
 */
@FeignClient(name = "itfan-analy-provider", fallbackFactory = AnalyFallbackFactory.class)
public interface AnalyServicePxy extends AnalyService {

}
