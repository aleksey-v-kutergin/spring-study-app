package ru.suprun.springstudyapp.mvc.interceptors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *    Обычный контроллер, обрабатывающий запрос в стандартном порядке.
 **/
@Controller
public class InterceptorController
{
    @RequestMapping(value = "/interceptorCall/subLevel", method = RequestMethod.GET)
    public ModelAndView interceptorCall()
    {
        System.out.println("interceptorCall() is called");
        return new ModelAndView("/index");
    }
}
