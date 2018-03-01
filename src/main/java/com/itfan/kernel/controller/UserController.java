package com.itfan.kernel.controller;

import com.itfan.analy.domain.Episode;
import com.itfan.crawler.domain.Video;
import com.itfan.kernel.service.AnalyServicePxy;
import com.itfan.kernel.service.IndexService;
import com.itfan.kernel.service.UserServicePxy;
import com.itfan.kernel.utils.UrlUtils;
import com.itfan.user.domain.ItfanUser;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: ralap
 * @date: created at 2018/1/10 22:15
 */
@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServicePxy userServicePxy;

    @Autowired
    private AnalyServicePxy analyServicePxy;

    @Autowired
    private IndexService indexService;

    @RequestMapping("/user/{userId}")
    @ResponseBody
    public ItfanUser getUser(@PathVariable("userId") Integer userId) {
        ItfanUser user = userServicePxy.getByUserId(userId);
        return user;
    }

    /**
     * 首页
     */
    @RequestMapping("/")
    public String index(Map<String, Object> map) {
        map.put("carouselList", indexService.getCarousel());
        map.put("moviesList", indexService.getMovies());
        map.put("hotTVList", indexService.getHotTV());
        map.put("zyList", indexService.getZY());
        return "index";
    }

    /**
     * 解析页
     */
    @GetMapping("/analysis")
    public String analysis() {
        return "analysis";
    }

    /**
     * 播放视频
     */
    @GetMapping("/play")
    public String paly(HttpServletRequest request, HttpServletResponse response, Model model) {
        String url = request.getParameter("u");
        response.setHeader("Access-Control-Allow-Origin", "*");
        Video video = analyServicePxy.analysisLetv(url);
        model.addAttribute("video", video);
        return "video";
    }

    @GetMapping("/episode")
    @ResponseBody
    public List episodes(HttpServletRequest request) {
        String url = request.getParameter("v");
        return analyServicePxy.episodeLetv(url);
    }

    @GetMapping("/video")
    @ResponseBody
    public Video video(HttpServletRequest request) {
        String url = request.getParameter("v");

        Video video = analyServicePxy.analysisLetv(url);
        return video;
    }

    @GetMapping("/searchView")
    public String search() {
        return "search";
    }

}
