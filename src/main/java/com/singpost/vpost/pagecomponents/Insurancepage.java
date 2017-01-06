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


public class Insurancepage
{
	WebDriver driver;
	String Title,Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	


@FindBy(xpath="//*[@id='insurance_reminder']/div[2]/div/div[3]/div[2]/button")
WebElement add_vcare;

public Insurancepage(WebDriver driver){ 
    this.driver = driver; 
    PageFactory.initElements(driver, this);
}
    
    public void ClickAddvcare() {
		try{
			//Thread.sleep(5000);
			/*inAction.inputText(driver, txt_inp,sUsername , "Enter username : " + sUsername);
			System.out.println("Going to enter pwd");
			inAction.inputText(driver, txt_Password, sPassword, "Enter password : " + sPassword);	*/
			inAction.buttonClick(driver, add_vcare, "Click button : add_Vcare");
		}
    
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		}
    }
   	


