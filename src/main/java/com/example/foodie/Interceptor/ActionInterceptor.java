package com.example.foodie.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.foodie.util.ControllerResult;
import com.example.foodie.util.FilterMatchUtil;
import com.example.foodie.util.SessionKeyValue;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */
@Configuration
public class ActionInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = Logger.getLogger(ActionInterceptor.class);

    private static final List<String> UN_NEED_LOGIN_ACTION = new ArrayList<String>();

    private static List<String> NEED_LOGIN_ACTION = new ArrayList<String>();

//    添加不用过滤的请求
    static {
        UN_NEED_LOGIN_ACTION.add("selectProvince.do");
        UN_NEED_LOGIN_ACTION.add("selectCityByProvince.do");
        UN_NEED_LOGIN_ACTION.add("selectCity.do");
        UN_NEED_LOGIN_ACTION.add("selectStreet.do");
        UN_NEED_LOGIN_ACTION.add("selectAllByStreet.do");

        UN_NEED_LOGIN_ACTION.add("selectByStreet.do");
        UN_NEED_LOGIN_ACTION.add("selectByType.do");
        UN_NEED_LOGIN_ACTION.add("selectByText.do");
        UN_NEED_LOGIN_ACTION.add("selectById.do");

        UN_NEED_LOGIN_ACTION.add("selectType.do");

        UN_NEED_LOGIN_ACTION.add("code");

        UN_NEED_LOGIN_ACTION.add("selectCommentNum.do");
        UN_NEED_LOGIN_ACTION.add("selectComment.do");

        UN_NEED_LOGIN_ACTION.add("selectFollowNum.do");

        UN_NEED_LOGIN_ACTION.add("selectLikeNum.do");

        UN_NEED_LOGIN_ACTION.add("upload");
        UN_NEED_LOGIN_ACTION.add("selectPicture.do");

        UN_NEED_LOGIN_ACTION.add("login.do");
        UN_NEED_LOGIN_ACTION.add("register.do");
    }

    // 添加要过滤的请求：添加购物车、添加收藏
    static {
        NEED_LOGIN_ACTION.add("selectByUserId.do");
        NEED_LOGIN_ACTION.add("selectByComment.do");
        NEED_LOGIN_ACTION.add("selectByFollow.do");
        NEED_LOGIN_ACTION.add("insertArticle.do");
        NEED_LOGIN_ACTION.add("deleteArticle.do");
        NEED_LOGIN_ACTION.add("updateArticle.do");

        NEED_LOGIN_ACTION.add("insertComment.do");
        NEED_LOGIN_ACTION.add("deleteComment.do");
        NEED_LOGIN_ACTION.add("updateComment.do");

        NEED_LOGIN_ACTION.add("insertFollow.do");
        NEED_LOGIN_ACTION.add("deleteFollow.do");

        NEED_LOGIN_ACTION.add("insertLike.do");
        NEED_LOGIN_ACTION.add("deleteLike.do");

        NEED_LOGIN_ACTION.add("selectUser.do");
        NEED_LOGIN_ACTION.add("updateUser.do");
        NEED_LOGIN_ACTION.add("updatePassword.do");
        NEED_LOGIN_ACTION.add("logout.do");

        NEED_LOGIN_ACTION.add("selectAuditArticle.do");
        NEED_LOGIN_ACTION.add("selectPassArticle.do");
        NEED_LOGIN_ACTION.add("insertAuditArticle.do");

        NEED_LOGIN_ACTION.add("selectLikeByDay.do");
        NEED_LOGIN_ACTION.add("selectLikeByMonth.do");

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute(SessionKeyValue.USER_ID);
        String url = request.getRequestURI();

        // 无需校验的请求，如：登录，注册，忘记密码等
        if (FilterMatchUtil.isEndWithListStr(url, UN_NEED_LOGIN_ACTION)) {
            return true;
        }

        // 未登录，直接返回：认证失败
        if (StringUtils.isEmpty(account) && FilterMatchUtil.isEndWithListStr(url, NEED_LOGIN_ACTION)) {
            ControllerResult controllerResult = new ControllerResult();
            controllerResult.setResultCode(ControllerResult.RESULT_CODE_ERROR);
            controllerResult.setMessage("未登陆！");
            returnError(response, JSONObject.toJSONString(controllerResult));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    private void returnError(HttpServletResponse response, String errorMessage)
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try
        {
            out = response.getWriter();
            out.append(errorMessage);
        }
        catch (IOException e)
        {
            logger.error("ActionFilter response error:", e);
        }
        finally
        {
            if (out != null)
            {
                out.close();
            }
        }
    }
}
