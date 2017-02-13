package ru.suprun.springstudyapp.mvc.bean;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 *  Сущность для лога.
 */
public class DBLog implements Serializable
{
    private static final long serialVersionUID = 1L;
    private int IDLOG;
    private String LOGSTRING;

    public DBLog()
    {

    }

    public DBLog(int IDLOG, String LOGSTRING)
    {
        this.IDLOG = IDLOG;
        this.LOGSTRING = LOGSTRING;
    }

    public int getIDLOG()
    {
        return IDLOG;
    }

    @XmlElement
    public void setIDLOG(int IDLOG)
    {
        this.IDLOG = IDLOG;
    }

    public String getLOGSTRING()
    {
        return LOGSTRING;
    }

    @XmlElement
    public void setLOGSTRING(String LOGSTRING)
    {
        this.LOGSTRING = LOGSTRING;
    }
}
