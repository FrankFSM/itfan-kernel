package com.itfan.kernel.service;

import com.itfan.crawler.domain.Video;
import java.util.List;

/**
 * IndexService
 *
 * @Author: ralap
 * @Date: created at 2017/8/16 17:29
 */
public interface IndexService {

    /**
     * 获取轮播视频信息
     */
    List<Video> getCarousel();


    /**
     * 获取电影
     * @return
     */
    List<Video> getMovies();

    /**
     * 获取热门电视剧
     * @return
     */
    List<Video> getHotTV();

    /**
     * 获取综艺
     * @return
     */
    List<Video> getZY();
}
