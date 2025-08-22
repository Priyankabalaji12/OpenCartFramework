package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_object_class.HomePageClass;
import page_object_class.LoginPageClass;
import page_object_class.MyAccountPageClass;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{
   @Test(groups= {"Sanity","Master"})
   public void test_Login()
   {
	   try
	   {
		loggers.info("********TC002_LoginPageTest Execution Started*********");
	   HomePageClass hp = new HomePageClass(driver);
	   hp.clickMyAccount();
	   hp.ClickLogin();
	   
	   loggers.info("********Successfully Landed on Login Page*********");
	   LoginPageClass lp = new LoginPageClass(driver);
	   lp.Enteremail_id(p.getProperty("email"));
	   lp.Enter_Login_Password(p.getProperty("password"));
	   lp.Click_Login_Button();
	   
	   loggers.info("********Successfully landed on My Account Page*********");
	   MyAccountPageClass acc = new MyAccountPageClass(driver);
	   boolean target_page = acc.isMyAccountPageExists();
	   Assert.assertTrue(target_page);
	   }
	   catch(Exception e)
	   {
		   Assert.fail();
	   }
	   
	   loggers.info("********TC002_LoginPageTest Executed Successfully*********");
	   
	   
   }
}
