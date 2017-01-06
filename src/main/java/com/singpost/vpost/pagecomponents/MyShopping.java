package com.singpost.vpost.pagecomponents;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.singpost.vpost.common.utils.Constants;
import com.singpost.vpost.common.utils.GeneralActions;
import com.singpost.vpost.common.utils.ReusableActions;

public class MyShopping
{
	WebDriver driver;
	String Title,Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	
	@FindBy(xpath="//*[@id='dashboard_navigation']/div/div[1]/ul/li[1]/a")
	 WebElement Shopping_btn;
	
	@FindBy(xpath="//*[@id='app_container']/div[2]/div/div[3]/div/button")
	WebElement Proceed_button;
	@FindBy(xpath="//*[@id='app_container']/div[2]/div/div[3]")
	WebElement Proceed_button1;
	
	
	
	public MyShopping(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	   	}
	//@FindBy(xpath="//*[@id='nav-destination-country']/li[2]/a")
	//WebElement Europe_btn;
	

	// click Shopping button 
		public void Shoppingclick(){
		
			try{
				inAction.linkClick(driver,Shopping_btn,"Shoppingclick");
			}
			catch(Exception t){
				t.printStackTrace();
			}
		}
		public void packagesclick(){
			  ArrayList<String> pIncludedList = new ArrayList<String>();
			  WebElement table=driver.findElement(By.className("ng-scope"));
              List<WebElement> row=table.findElements(By.tagName("tr"));
              
              for(WebElement rowElement:row){
                              List<WebElement> column=rowElement.findElements(By.tagName("td"));
                              for(WebElement columnElement:column){
                                              try{
                                              if(columnElement.getText().contains("Package included")){
                                                              
                                                              pIncludedList.add(columnElement.toString());
                                                               // System.out.println("*******Text Found " + columnElement.getText());
//                                                            columnElement.click();
                                              }                                                                                                                              
                                                              
                                            
                                              
                                              for(int j=(pIncludedList.size()-1);pIncludedList.size()>=j;j++){
                                                              
                                                              try{
                                                                              
                                                                              if(j==1){               
                                                                                             
                                                                                              break;
                                                                              }else{
                                                                                  //Thread.sleep(2000);            
                                                                              	columnElement.click();
                                                                              }
                                              
                              }
                                                              catch(Exception e){
                                                                              
                                                              }
                                              }
                                              }
                              
              catch(Exception e){
//                          e.printStackTrace();
              } 


              
                              }
              
              
              
}

}

//Click Login button
		public void clickProceedButton() {
			//try{
				 System.out.println("Shopping click1212");
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				 js.executeScript("window.scrollBy(0,450)", "");
				inAction.buttonClick(driver,Proceed_button1, "Click button : Proceed_button");
				inAction.buttonClick(driver,Proceed_button, "Click button : Proceed_button");
				
	    /*}
			catch(Exception e){
				
				e.printStackTrace();
			}
			*/
		}
}