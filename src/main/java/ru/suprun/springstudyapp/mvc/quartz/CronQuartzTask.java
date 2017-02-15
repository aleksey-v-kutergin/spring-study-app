package ru.suprun.springstudyapp.mvc.quartz;

import java.util.Calendar;

/**
 *     И так, работа с планировщиком задач Quartz Scheduler.
 *     Класс задачи, стартуемой по выражению Cron.
 **/
public class CronQuartzTask
{
    public void cronTaskMethod()
    {
        //you can send emails to users here
        System.out.println("Cron Time: " + Calendar.getInstance().getTime());
    }
}
