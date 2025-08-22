package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_object_class.HomePageClass;
import page_object_class.RegisterPageClass;
import testBase.BaseClass;

public class TC001_RegisterPageTest extends BaseClass
{
    @Test(groups= {"Regression","Master"})
    public void Test_Login_Registration()
    {
    	try
    	{
    	loggers.info("*******TC001_RegisterPageTest Execution Started******");
    	HomePageClass hp = new HomePageClass(driver);
    	hp.clickMyAccount();
    	hp.ClickRegister();
    	
    	
    	loggers.info("*******Register Page******");
    	RegisterPageClass rp = new RegisterPageClass(driver);
    	rp.EnterFirstName(randomString());
    	rp.EnterLastName(randomString());
    	rp.EnterEmail(randomString()+"@gmail.com");
    	rp.Entertelephone(randomNumber());
    	
    	String password_field = Alphanumeric();
    	rp.EnterPassword(password_field);
    	rp.EnterConfirmPassword(password_field);
    	
    	
    	rp.clickCheckbox();
    	rp.ClickButton();
    	
    	loggers.info("*******Getting Confirmation Message******");
    	if(rp.getConfirmationMsg().equals("Your Account Has Been Created!"))
    			{
    		Assert.assertTrue(true);
    			}
    	else
    	{
    		Assert.assertTrue(false);
    	}
    	}
    	
    	catch(Exception e)
    	{
    		Assert.fail();
    	}
    	
    	loggers.info("*******TC001_RegisterPageTest Execution Completed Successfully******");
    			
    }
}
