package com.singpost.vpost.pagecomponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.singpost.vpost.common.utils.Constants;
import com.singpost.vpost.common.utils.GeneralActions;
import com.singpost.vpost.common.utils.ReusableActions;

public class Signin
{
	WebDriver driver;
	String Title,Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	
	
	@FindBy(xpath ="//*[@id='dashboard_navigation']/div/div[2]/ul/li[1]/a")
	WebElement sigin_click;
	
	@FindBy(xpath="//*[@id='signin_form']/div[2]/p[3]/input[1]") 
	WebElement txt_inp;
	
	@FindBy(xpath="//*[@id='signin_form']/div[2]/p[3]/input[2]") 
	WebElement txt_Password;
	
	@FindBy(xpath="//*[@id='signin_form']/div[2]/p[5]/button") 
	WebElement btn_signin;
	
	
   
//	String logininXpath ="//button[@type='submit']";
	
	
	public Signin(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	   	}
	
	// click Login button 
	public void clickSignIn(){
	//	inAction.linkClick(driver,sigin_click,"Click Login");
		try{
			inAction.linkClick(driver,sigin_click,"Click Login");
		}
		catch(Exception t){
			t.printStackTrace();
		}
		//isElementPresent(sigin_click);
		
	}
	// To verify the element is present or not
		/*public boolean isElementPresent(WebElement element) {

			WebDriverWait wait = new WebDriverWait(driver,60);
			WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
			if (ele != null)
				return true;
			return false;
		}
		// To click the element
		public void click(WebElement element) {
//			if (sync(element))
				//if (isElementPresent(element))
				element.click();
		}*/
		/*public boolean sync(WebElement element){
			long end = 500;
			int count = 0;
			try {
				Thread.sleep(end);

				while(count <= 10){
					if(isElementPresent(element))
						return true;
					Thread.sleep(end);
					count++;

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return false;
		}*/

		// Enter Username
		public void enterUserName(String sUsername) {
			try{
			
			
			inAction.inputText(driver, txt_inp,sUsername , "Enter username : " + sUsername);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
		//Enter Password
		public void enterPassword(String sPassword) {
			try{
				
			
			
			inAction.inputText(driver, txt_Password, sPassword, "Enter password : " + sPassword);
	    }
		catch(Exception e){
			e.printStackTrace();
			
		}
		}
		
		//Click Login button
		public void clickLoginButton() {
			try{
				//Thread.sleep(5000);
				/*inAction.inputText(driver, txt_inp,sUsername , "Enter username : " + sUsername);
				System.out.println("Going to enter pwd");
				inAction.inputText(driver, txt_Password, sPassword, "Enter password : " + sPassword);	*/
				inAction.buttonClick(driver, btn_signin, "Click button : btn_Login");
	    }
			catch(Exception e){
				
				e.printStackTrace();
			}
			
		}
		
		
		/*public void popUp(){
			try{
						
				inAction.buttonClick(driver, btn_popupclose, "Click button : btn_popupclose");
				String delimiter = ":";
				Title=driver.getTitle();
		    	  // given string will be split by the argument delimiter provided. 
		    	  String [] temp = Title.split(delimiter);
		    	  // print substrings 
		    	  for(int i =0; i < temp.length ; ++i){
		    		  
		    		  Value=temp[++i];
		    		  System.out.println(Value);
		    	  }
				 Assert.assertEquals(constants.URL_LOADING_PAGE_TITLE, Value);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		*/
		
		@DataProvider
		public static Object[][] getData(){
			
			return GeneralActions.getData("Login");
		}
	}
