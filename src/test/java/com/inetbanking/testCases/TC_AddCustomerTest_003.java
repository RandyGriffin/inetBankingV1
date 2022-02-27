package com.inetbanking.testCases;

import java.io.IOException;

 
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("Providing customer details......");
		
		
		addcust.custName("Randy");
		addcust.custgender("male");
		addcust.custdob("08","15","1999");
		Thread.sleep(5000);
		addcust.custaddress("USA");
		addcust.custcity("Atlanta");
		addcust.custstate("GA");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed");
		}
		else
		{
			logger.info("test case failed");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	

	
	
}
