package ru.suprun.springstudyapp.mvc.rest.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

@Entity //use for JPA. For JDBC you can clear this
@Table(name = "LOG")
public class DBLogXML implements Serializable
{

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "IDLOG")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int IDLOG;

  @Column(name = "LOGSTRING")
  private String LOGSTRING;

  public DBLogXML()
  {

  }

  public DBLogXML(int idLog, String logString)
  {
    this.IDLOG = idLog;
    this.LOGSTRING = logString;
  }

  public int getIDLOG()
  {
    return IDLOG;
  }

  @XmlElement
  public void setIDLOG(int iDLOG)
  {
    IDLOG = iDLOG;
  }

  public String getLOGSTRING()
  {
    return LOGSTRING;
  }

  @XmlElement
  public void setLOGSTRING(String lOGSTRING)
  {
    LOGSTRING = lOGSTRING;
  }
}
