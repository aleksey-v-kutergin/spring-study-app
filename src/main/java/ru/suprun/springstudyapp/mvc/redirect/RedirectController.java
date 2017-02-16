package ru.suprun.springstudyapp.mvc.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RedirectController
{
    // Redirect to external url
    @RequestMapping(value = "/redirectExample", method = RequestMethod.GET)
    public String redirectExample(HttpServletRequest request)
    {
        // request.getScheme() - нужно использовать, если не известно какой протокол используется: http, https, ftp
        return "redirect:" + request.getScheme() + "://javastudy.ru";
    }
}
