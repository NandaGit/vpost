package com.singpost.vpost.flow;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.singpost.vpost.common.utils.GeneralActions;
import com.singpost.vpost.common.utils.ReusableActions;
import com.singpost.vpost.pagecomponents.Insurancepage;
import com.singpost.vpost.pagecomponents.MyShopping;

//import com.specomm.adidas.pagecomponents.AdidasHomePage;
import com.singpost.vpost.pagecomponents.Signin;


public class Addvcare extends GeneralActions {
	static WebDriver driver;
	MyShopping MyShopping;
	Signin Signin;
	Insurancepage Insurancepage;
	//AdidasHomePage adidasHomePage;
	//SubCategoriesPage subCategoriesPage;
	//ProductDetailsPage productDetailsPage;
	//ShoppingBucketPage shoppingBucketPage;
	//ShippingDetailsLoginPage shippingDetailsLoginPage;
	//VisaPaymentDetailsPage visapaymentDetailsPage;
	//Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	

	
	
	 @BeforeClass
	  public void setUp() throws IOException {
		  
		  driver = launchBrowser(driver, "firefox");
		  MyShopping = PageFactory.initElements(driver, MyShopping.class);
		  Signin = PageFactory.initElements(driver, Signin.class);
		  Insurancepage= PageFactory.initElements(driver, Insurancepage.class);
		 // adidasHomePage=PageFactory.initElements(driver, AdidasHomePage.class);
		 // subCategoriesPage=PageFactory.initElements(driver, SubCategoriesPage.class);
		 // productDetailsPage=PageFactory.initElements(driver, ProductDetailsPage.class);
		 // shoppingBucketPage=PageFactory.initElements(driver, ShoppingBucketPage.class);
		 // shippingDetailsLoginPage=PageFactory.initElements(driver, ShippingDetailsLoginPage.class);
		 // visapaymentDetailsPage=PageFactory.initElements(driver, VisaPaymentDetailsPage.class);
		    ReusableActions.loadPropFileValues();
		    ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	      
	
	
	
	 }


	/**
	 * Login Checkout Flow Test Script
     */


	
		
	 @Test( priority = 1, dataProviderClass=Signin.class, dataProvider="getData")
		public void checkoutAsRegisteredLoginUserFlow(String username,String password) throws Exception {
			try {
		      //adidasLoginPage.popUp();
			 System.out.println("123"+MyShopping);
			 Signin.clickSignIn();
		      System.out.println("Click siginin");
		      Thread.sleep(5000);
		      Signin.enterUserName(username);
		      Signin.enterPassword(password);
		      Signin.clickLoginButton();
		      MyShopping.Shoppingclick();
		      System.out.println("Shopping click");
		      MyShopping.clickProceedButton();
		      Thread.sleep(5000);
		      Insurancepage.ClickAddvcare();
		      Thread.sleep(4000);
		      //Signin.enterUserName(username);
		     // Signin.enterPassword(password);
		     // Signin.clickLoginButton();
		      log4jlogger.info("##########-------Login application-------##########");
		      //Signin.logIn_Action(username, password);
		     // Signin.verifyLoginLandingPage();
		      log4jlogger.info("##########-------Login Successfully,----------############");
		     
		}
		catch(Exception e){
			e.printStackTrace();
		}
	 }	
	 
	/*@Test(priority = 2 ,dataProviderClass=ShippingDetailsLoginPage.class,dataProvider="getData")
	 public void shipDetailsRegisteredLoginUserFlow(String sFName,String sLName,String sPhone,String sAddress,String sCity,String sRegion,String sPostal,String sDay,String sMonth,String sYear){
		 shippingDetailsLoginPage=new ShippingDetailsLoginPage(driver);
			
		 try{
				ReusableActions.waitForpageToLoad(driver);
				shippingDetailsLoginPage.ship_DetailsLogin(sFName,sLName,sPhone,sAddress,sCity,sRegion,sPostal,sDay,sMonth,sYear);
				//shippingDetailsLoginPage.shippingContinue();
			}
			
			catch (Throwable t) {
				t.printStackTrace();
			}
			
	}
	
	
	
	@Test(priority = 3,dataProviderClass=VisaPaymentDetailsPage.class, dataProvider="getData")
	public void paymentDetailsRegisteredLoginUserFlow(String cType,String cNumber,String cExpiryMonth,String cExpiryYear,String cccvv) throws Exception {
		try {
			
		     
		      
			ReusableActions.waitForpageToLoad(driver);
		//	paymentDetailsPage.verifyPaymentHeading();
			
			visapaymentDetailsPage.selectCardPaymentDetails(cType,cNumber,cExpiryMonth,cExpiryYear,cccvv);
		     
				
				
		     
		} catch (Throwable e) {
			e.printStackTrace();
		}
		}
	*/
	
	@AfterClass
	public static void quitDriver()  {
	 try{
		
		 Thread.sleep(5000);
	 driver.quit();
		 }
		  catch (Exception e) {
		 e.printStackTrace();
		 }
	
}

	 
}
