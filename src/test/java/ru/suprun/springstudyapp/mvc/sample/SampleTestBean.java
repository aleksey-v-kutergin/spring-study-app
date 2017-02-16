package ru.suprun.springstudyapp.mvc.sample;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.suprun.springstudyapp.mvc.bean.SampleBean;

/**
 *    RunWith - антоцая из фрэймворка JUnit.
 *    В ней мы указываем как будет запускаться наш тест.
 *    Класс, передаваемый в эту аннотацию, должен быть унаследован от Runner.
 **/
@RunWith(SpringJUnit4ClassRunner.class)
/**
 *     ContextConfiguration - аннотация позволяет задать расположение контекста для тестов.
 **/
@ContextConfiguration(locations = {"classpath:mvc-context.xml", "classpath:application-context.xml"})
public class SampleTestBean
{
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void sampleTest()
    {
        SampleBean bean = applicationContext.getBean("sampleBean", SampleBean.class);
        Assert.assertNotNull(bean);

        bean = (SampleBean) applicationContext.getBean("sampleBean");
        Assert.assertNotNull(bean);

        Assert.assertEquals(bean.getStringValue(), "postConstructValue");
        Assert.assertEquals(bean.getNumber(), 666);
    }
}
