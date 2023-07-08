package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseHRMClass;

public class POMLogin extends BaseHRMClass {
//create object repository- all the elements in the login page with its element locator and value

	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input") WebElement Username;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input") WebElement Password;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button") WebElement Loginbtn;
	
	//Initiate page elements using constructor
	public POMLogin() {
		PageFactory.initElements(driver,this);
/*To make the driver valid make this POMLogin Class a child of BaseHRMClass and import it and 
 this keyword used to make local and global variable are same*/
 }
	public void typeusername(String name) throws InterruptedException {
		Username.sendKeys(name);
		Thread.sleep(2000);
	}
	public void typepassword(String pass) throws InterruptedException {
		Password.sendKeys(pass);
		//Thread.sleep(2000);
	}
	public void clicklogin() throws InterruptedException {
		Loginbtn.click();
		//Thread.sleep(2000);
		System.out.println("abcd");
	}
	public String checktitle() {
		return driver.getTitle();
		
		
	}
	
}
