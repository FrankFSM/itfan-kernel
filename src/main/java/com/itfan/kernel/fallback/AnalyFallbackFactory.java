package com.itfan.kernel.fallback;

import com.itfan.analy.domain.Episode;
import com.itfan.crawler.domain.Video;
import com.itfan.kernel.service.AnalyServicePxy;
import com.itfan.kernel.service.UserServicePxy;
import com.itfan.user.domain.ItfanUser;
import feign.hystrix.FallbackFactory;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: ralap
 * @date: created at 2018/1/11 23:18
 */
@Log4j2
@Component
public class AnalyFallbackFactory implements FallbackFactory<AnalyServicePxy> {


    @Override
    public AnalyServicePxy create(Throwable throwable) {
        log.info("ITFAN-ANALY-PROVIDER Request FAIL,Cause: " + throwable.getMessage());
        throwable.printStackTrace();
        return new AnalyServicePxy() {
            @Override
            public Video analysisLetv(String s) {
                Video video = new Video();
                return video;
            }

            @Override
            public List<Episode> episodeLetv(String s) {
                return null;
            }

        };

    }
}
