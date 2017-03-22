package ru.suprun.springstudyapp.mvc.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "LOGS")
public class DBLogsXML
{
  private List<DBLogXML> logList;

  @XmlElement(name = "LOG")
  public List<DBLogXML> getLogList()
  {
    return logList;
  }

  public void setLogList(List<DBLogXML> logList)
  {
    this.logList = logList;
  }
}
