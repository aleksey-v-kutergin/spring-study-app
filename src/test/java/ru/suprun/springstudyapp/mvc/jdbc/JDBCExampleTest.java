package ru.suprun.springstudyapp.mvc.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.suprun.springstudyapp.mvc.bean.DBLog;
import ru.suprun.springstudyapp.mvc.bean.User;

import java.util.List;

/**
 *   Тестирование методов репозитория JDBCExample.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mvc-context.xml", "classpath:application-context.xml"})
public class JDBCExampleTest
{
    //IMPORTANT - DISABLE THIS <bean class="org.springframework.web.servlet.view.XmlViewResolver"> in mvc-config.xml

    @Autowired
    private JDBCExample jdbcExample;


    @Test
    public void insertLogTest()
    {
        DBLog dbLog = new DBLog(10, "test Log 10");
        Assert.assertTrue( jdbcExample.insertLog(dbLog) );
    }


    @Test
    public void queryAllLogsTest()
    {
        List<DBLog> dbLogs = jdbcExample.queryAllLogs();
        Assert.assertNotNull(dbLogs);

        for (DBLog dbLog : jdbcExample.queryAllLogs())
        {
            System.out.println("DBLog id: "+ dbLog.getIDLOG() + " DBLog logString: "+ dbLog.getLOGSTRING());
        }

    }


    @Test
    public void queryAllUsersTest()
    {
        List<User> users = jdbcExample.queryAllUsers();
        Assert.assertNotNull(users);

        for (User user : jdbcExample.queryAllUsers())
        {
            System.out.println("User id: "+ user.getIdUser() + " User username: "+ user.getUsername());
        }
    }


    @Test
    public void deleteUSERTest()
    {
        Assert.assertTrue( jdbcExample.deleteUSER(5) );
    }


    @Test
    public void updateUserEnableTest()
    {
        User user = new User();
        user.setUsername("test1@outlook.com");
        Assert.assertTrue( jdbcExample.updateUserEnable(user, false) );
    }
}
