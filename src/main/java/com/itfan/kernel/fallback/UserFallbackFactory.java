package com.itfan.kernel.fallback;

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
public class UserFallbackFactory implements FallbackFactory<UserServicePxy> {

    @Override
    public UserServicePxy create(Throwable throwable) {
        log.info("ITFAN-USER-PROVIDER Request FAIL,Cause: " + throwable.getMessage());
        throwable.printStackTrace();
        return new UserServicePxy() {
            @Override
            public List<ItfanUser> getAll() {
                return null;
            }

            @Override
            public ItfanUser getByUserName(@RequestParam("userName") String s) {
                return new ItfanUser();
            }

            @Override
            public ItfanUser getByUserId(@RequestParam("userId") Integer integer) {
                ItfanUser user = new ItfanUser();
                user.setUserName("Admin");
                user.setPassword("*****");
                user.setRoles("ROLES_ADMIN");
                user.setUserId(-1);
                return user;
            }

            @Override
            public Integer addByUserId(@RequestParam("user") ItfanUser itfanUser) {
                return null;
            }

            @Override
            public Integer delByUserId(@RequestParam("userId") Integer integer) {
                return null;
            }
        };
    }
}
