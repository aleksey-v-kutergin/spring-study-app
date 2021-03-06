package ru.suprun.springstudyapp.mvc.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component(value = "sampleBean")
public class SampleBean
{
    private String stringValue;
    private int number;


    @PostConstruct
    public void init()
    {
        stringValue = "postConstructValue";
        number = 666;
    }


    public String getStringValue()
    {
        return stringValue;
    }

    public void setStringValue(String stringValue)
    {
        this.stringValue = stringValue;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }
}
