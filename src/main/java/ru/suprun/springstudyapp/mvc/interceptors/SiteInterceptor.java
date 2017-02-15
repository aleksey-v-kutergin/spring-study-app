package ru.suprun.springstudyapp.mvc.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *   Бин-перехватчик.
 *   Выполняет дополнительную обработку запросов:
 *   1. Перед вызовом метода соотвествующего контроллера
 *   2. После вызовом метода соотвествующего контроллера
 *   3. После завершения обработки запроса
 */
public class SiteInterceptor implements HandlerInterceptor
{

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception
    {
        System.out.println("SiteInterceptor preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception
    {
        System.out.println("SiteInterceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception
    {
        System.out.println("SiteInterceptor afterCompletion");
    }
}
