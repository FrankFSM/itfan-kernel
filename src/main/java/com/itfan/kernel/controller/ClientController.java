package com.itfan.kernel.controller;

/**
 * @author: ralap
 * @date: created at 2018/1/28 11:46
 */

import com.itfan.analy.domain.Episode;
import com.itfan.crawler.domain.Video;
import com.itfan.kernel.service.AnalyServicePxy;
import com.itfan.kernel.service.IndexService;
import com.itfan.kernel.service.UserServicePxy;
import com.itfan.user.domain.ItfanUser;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ralap
 * @date: created at 2018/1/10 22:15
 */
@RestController
@RequestMapping("/client")
public class ClientController {

    Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private UserServicePxy userServicePxy;

    @Autowired
    private AnalyServicePxy analyServicePxy;

    @Autowired
    private IndexService indexService;

    @RequestMapping("/getUserByUserName")
    public ItfanUser getUserByUserName(String userName) {
        ItfanUser user = userServicePxy.getByUserName(userName);
        return user;
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public Integer insertUser(ItfanUser user) {
        return userServicePxy.addByUserId(user);
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public List<ItfanUser> getAllUser() {
        return userServicePxy.getAll();
    }

    @RequestMapping("/carouselList")
    public List<Video> carouselList() {
        return indexService.getCarousel();

    }

    @RequestMapping("/moviesList")
    public List<Video> moviesList() {
        return indexService.getMovies();

    }

    @RequestMapping("/hotTVList")
    public List<Video> hotTVList() {
        return indexService.getHotTV();

    }

    @RequestMapping("/zyList")
    public List<Video> zyList() {
        return indexService.getZY();

    }

    /**
     * 播放视频
     */
    @GetMapping("/play")
    public Video paly(String url) {
        Video video = analyServicePxy.analysisLetv(url);
        return video;

    }

    @GetMapping("/episode")
    public List<Episode> episodes(String url) {
        return analyServicePxy.episodeLetv(url);
    }

    @GetMapping("/video")
    public Video video(String url) {
        Video video = analyServicePxy.analysisLetv(url);
        return video;
    }


}

