package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_object_class.HomePageClass;
import page_object_class.LoginPageClass;
import page_object_class.MyAccountPageClass;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass
{
   @Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
   public void test_Login(String email,String pwd,String exp)
   {
	   try
	   {
		loggers.info("********TC003_LoginDDT Execution Started*********");
	   HomePageClass hp = new HomePageClass(driver);
	   hp.clickMyAccount();
	   hp.ClickLogin();
	   
	   loggers.info("********Successfully Landed on Login Page*********");
	   LoginPageClass lp = new LoginPageClass(driver);
	   lp.Enteremail_id(email);
	   lp.Enter_Login_Password(pwd);
	   lp.Click_Login_Button();
	   
	   loggers.info("********Successfully landed on My Account Page*********");
	   MyAccountPageClass acc = new MyAccountPageClass(driver);
	   boolean target_page = acc.isMyAccountPageExists();
	   Assert.assertTrue(target_page);
	   
	   //NOW PERFORM DATADRIVEN TESTING WRITE SOME LOGIC FOR THAT WITH VALID AND INVALID COMBINATION
	   /*
	    * IF DATA IS VALID ->LOGIN PASS->TEST CASE PASS->CLICK ON LOGOUT
	    *                  -> LOGIN FAIL-> TEST CASE FAIL
	    *                  
	    *  IF DATA IS NOT VALID -> LOGIN FAIL -> TEST CASE PASS
	    *                       -> LOGIN PASS -> TEST CASE FAIL
	    */
	   /*
	    * we are performing this from excel data so write that exp here
	    */
	   
	   loggers.info("********pERFORMING DDT ACTION*********");
	   
	   if (exp.equalsIgnoreCase("Valid")) {
		    if (target_page) {
		        acc.ClickLogout();
		        Assert.assertTrue(true);
		    } else {
		        Assert.fail("Expected login to succeed, but it failed.");
		    }
		} else if (exp.equalsIgnoreCase("Invalid")) {
		    if (target_page) {
		        Assert.fail("Expected login to fail, but it succeeded.");
		    } else {
		        Assert.assertTrue(true);
		    }
		}

	   
	 /*  if(exp.equalsIgnoreCase("Valid"))
	   {
		   if(target_page==true)
		   {
			   acc.ClickLogout();
		   }
		   else
		   {
			   Assert.assertTrue(false);
		   }
	   }
	   if(exp.equalsIgnoreCase("Invalid"))
	   {
		   if(target_page == true)
		   {
			   Assert.assertTrue(false);
		   }
		   else
		   {
			   Assert.assertTrue(true);
		   }
	   }*/
	   }
	   catch(Exception e)
	   {
		   Assert.fail();
	   }
	   
	   loggers.info("********TC003_LoginDDT Executed Successfully*********");
	   
	  
	  
	   
   }
}
