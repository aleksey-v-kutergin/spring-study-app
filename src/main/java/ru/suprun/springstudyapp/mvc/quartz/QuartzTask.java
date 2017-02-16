package ru.suprun.springstudyapp.mvc.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

/**
 *     И так, работа с планировщиком задач Quartz Scheduler.
 *     Класс задачи, чапускаемой по простому триггеру.
 *     Простой триггер с врменной задержкой.
 **/
public class QuartzTask
{
    private static final Logger logger = LoggerFactory.getLogger(QuartzTask.class);


    public void simpleTaskMethod()
    {
        // Здесь можно заломится в БД при помощи simpletasktrigger
        logger.info("Test Simple Quartz Time: " + Calendar.getInstance().getTime());
        //System.out.println("Test Simple Quartz Time: " + Calendar.getInstance().getTime());
    }
}
