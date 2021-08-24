/**
 * 拦截器拦截除了登入登出页面的其他页面，检验是否这个session里的用户登录过，没登录过返回登录页面进行登录，登录放行
 */
package com.bondsales.backend.Interceptor;

import com.bondsales.backend.dao.entity.User;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        String user = (String)session.getAttribute(ConstantUtils.SESSION_KEY);
        //如果session中没有logname，表示没登陆
        if (user != null){
            //已登录
            request.getSession().setAttribute(ConstantUtils.SESSION_KEY,user);
            return true;    //如果session里有user，表示该用户已经登陆，放行，用户即可继续调用自己需要的接口
        }else {
            //这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
            //当然你可以利用response给用户返回一些提示信息，告诉他没登陆
            request.getSession().invalidate();
            response.sendError(302,"请先登录");
            return false;
        }
    }
}
