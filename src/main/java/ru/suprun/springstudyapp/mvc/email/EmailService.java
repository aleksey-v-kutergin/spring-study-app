package ru.suprun.springstudyapp.mvc.email;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class EmailService
{
    /* Email From */
    public static final String FROM = "from";

    /* Email To */
    public static final String TO = "to";

    /* Email Subject */
    public static final String SUBJECT = "subject";

    /* Email BBC */
    public static  final String BBC_LIST = "bccList";

    /* Email CCC */
    public static final String CCC_LIST = "ccList";


    @Autowired
    private JavaMailSender mailSender; // Сюда будет инжектирован бин id = mailSender, опсаный в контексте.

    @Autowired
    private VelocityEngine velocityEngine; // Сюда будет инжектирован бин id = velocityEngine, опсаный в контексте.


    public boolean sendEmail(final String templateName, final Map<String, Object> model)
    {
        boolean result = false;
        try
        {
            MimeMessagePreparator preparator = new MimeMessagePreparator()
            {
                @Override
                public void prepare(MimeMessage mimeMessage) throws Exception
                {
                    String from = (String) model.get(FROM);
                    String to = (String) model.get(TO);
                    String subject = (String) model.get(SUBJECT);

                    List<String> bccList = (List<String>) model.get(BBC_LIST);

                    // ВАЖНО!!! В конструкторе ОБЯЗАТЕЛЬНО нужно выставить кодировку!!!
                    // Иначе сообщения превратятся в кракозябры!!!
                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");

                    message.setFrom(from);
                    message.setTo(to);
                    message.setSubject(subject);
                    message.setSentDate(new Date());

                    if(bccList != null && !bccList.isEmpty())
                    {
                        for(String bcc : bccList)
                        {
                            message.setBcc(bcc);
                        }
                    }

                    model.put("noArgs", new Object());
                    String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateName, "UTF-8", model);
                    message.setText(text);
                }
            };

            mailSender.send(preparator);
            result = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }
}
