package com.itfan.kernel.service.impl;

import com.itfan.crawler.domain.Video;
import com.itfan.crawler.global.Constant.RedisKey;
import com.itfan.crawler.global.Constant.VideTag;
import com.itfan.crawler.redis.RedisManager;
import com.itfan.kernel.service.IndexService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * IndexServiceImpl
 *
 * @Author: ralap
 * @Date: created at 2017/8/16 17:31
 */
@Slf4j
@Service("indexService")
public class IndexServiceImpl implements IndexService {

    @Autowired
    private RedisManager redisManager;

    @Override
    public List<Video> getCarousel() {
        List<Video> viewList = redisManager
                .getViewList(RedisKey.VIDEO_PREFIX_HOME_CAROUSEL_KEY, VideTag.LETV_TAG);
        log.info("-----------------" + viewList.size());
        return viewList;
    }

    @Override
    public List<Video> getMovies() {
        List<Video> viewList = redisManager
                .getViewList(RedisKey.VIDEO_PREFIX_HOME_MOVIE_KEY, VideTag.LETV_TAG);
        log.info("-----------------" + viewList.size());
        return viewList;
    }

    @Override
    public List<Video> getHotTV() {
        List<Video> viewList = redisManager
                .getViewList(RedisKey.VIDEO_PREFIX_HOME_TV_HOT_KEY, VideTag.LETV_TAG);
        log.info("-----------------" + viewList.size());
        return viewList;
    }

    @Override
    public List<Video> getZY() {
        List<Video> viewList = redisManager
                .getViewList(RedisKey.VIDEO_PREFIX_HOME_RECOMMEND_KEY, VideTag.LETV_TAG);
        log.info("-----------------" + viewList.size());
        return viewList;
    }


}
