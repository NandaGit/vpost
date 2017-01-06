package com.singpost.vpost.pagecomponents;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.singpost.vpost.common.utils.Constants;
import com.singpost.vpost.common.utils.GeneralActions;
import com.singpost.vpost.common.utils.ReusableActions;

public class Paymentpage
{
	WebDriver driver;
	String Title,Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	
@FindBy(xpath="//*[@id='payment-method']/div[1]/div/label[2]/input")
WebElement radio_btn;

@FindBy(xpath="//*[@id='payment-method']/div[1]/div/label[1]/input")
WebElement saved_radio_btn;



@FindBy(xpath="//*[@id='payment-method']/div[1]/div/div[1]/div/label/input")
WebElement visa_radio_btn;


@FindBy(xpath="//*[@id='form-new-cc']/div[1]/div/input")
WebElement txt_name;

@FindBy(xpath="//*[@id='form-new-cc']/div[2]/div/input")
WebElement txt_cardno;

@FindBy(xpath="//*[@id='cc_month']")
WebElement sel_month_click;

@FindBy(xpath="//*[@id='cc_month']")
List<WebElement> sel_month;

@FindBy(xpath="//*[@id='cc_year']")
WebElement sel_year_click;

@FindBy(xpath="//*[@id='cc_year']")
List<WebElement> sel_year;

@FindBy(xpath="//*[@id='form-new-cc']/div[4]/div/input")
WebElement ver_code;

@FindBy(xpath="//*[@id='payment-method']/div[3]/button")
WebElement pay_btn;




	public Paymentpage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
}

public void clickradiobtn() {
	try{
		//Thread.sleep(5000);
		/*inAction.inputText(driver, txt_inp,sUsername , "Enter username : " + sUsername);
		System.out.println("Going to enter pwd");
		inAction.inputText(driver, txt_Password, sPassword, "Enter password : " + sPassword);	*/
		inAction.buttonClick(driver,  saved_radio_btn, "Click button :  pay_btn");
		inAction.buttonClick(driver, visa_radio_btn, "Click visa radi: : Pay");
	}
		catch(Exception e){
			
			e.printStackTrace();
		}
		}


//Enter Cardname
public void Cardname(String sCard){
	try{
	
	
	inAction.inputText(driver, txt_name,sCard, "enter month: " + sCard);
}
catch(Exception e){
	e.printStackTrace();
}
}


//Enter Cardnumber

public void Cardnumber(String scardno){
	try{
	
		
	inAction.inputText(driver, txt_cardno,scardno , "enter month: " + scardno);
}
catch(Exception e){
	e.printStackTrace();
}
}
/*public void Clickmonth(){
	
inAction.buttonClick(driver,  sel_month, "Click button :  pay_btn");
}
*/
// Enter Month
public void entermonth(String sEntermonth) {
	try{
		//inAction.buttonClick(driver,  sel_month_click, "Click button :  pay_btn");
		ReusableActions.selectItemFromDropdown(driver, sel_month_click,sEntermonth,"enter month : " + sEntermonth);
}
catch(Exception e){
	e.printStackTrace();
}
}
/*public void Clickyear(){
inAction.buttonClick(driver, sel_year, "Click button :  pay_btn");
}*/
//Enter Year
public void enteryear(String sYear) {
	try{
		//inAction.buttonClick(driver, sel_year_click, "Click button :  pay_btn");
		
		ReusableActions.selectItemFromDropdown(driver, sel_year_click,sYear,"enter year : " + sYear);
}
catch(Exception e){
	e.printStackTrace();
	
}
}

//Enter CVVcode
public void vercode(String sverycode) {
	try{
	
	
	inAction.inputText(driver, ver_code,sverycode , "Enter username : " + sverycode);
}
catch(Exception e){
	e.printStackTrace();
}
}


public void clickpaybtn() {
	try{
		//Thread.sleep(5000);
		/*inAction.inputText(driver, txt_inp,sUsername , "Enter username : " + sUsername);
		System.out.println("Going to enter pwd");
		inAction.inputText(driver, txt_Password, sPassword, "Enter password : " + sPassword);	*/
		inAction.buttonClick(driver,  pay_btn, "Click button :  pay_btn");
}
	catch(Exception e){
		
		e.printStackTrace();
	}
	
}


@DataProvider
public static Object[][] getData(){
	
	return GeneralActions.getData("Payment");
}
}