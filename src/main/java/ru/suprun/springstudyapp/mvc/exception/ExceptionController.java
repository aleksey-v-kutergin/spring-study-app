package ru.suprun.springstudyapp.mvc.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *  По url-запросу отрабатывает метод контроллера, генерирующий исключение
 */
@Controller
public class ExceptionController
{
    @RequestMapping(value = "/runtimeException", method = RequestMethod.GET)
    public void throwException()
    {
        throw new RuntimeException();
    }
}
