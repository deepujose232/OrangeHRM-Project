package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseHRMClass;
import pompackage.POMLogin;
import testdata.Excelsheet;

public class LoginTestcases extends BaseHRMClass {
	
	POMLogin log;
	
	public LoginTestcases() {
		super();//To call the constructor of parent class
	}
	
	@BeforeMethod
	public void initsetup() throws InterruptedException {
		intiate();
		Thread.sleep(2000);
		screenshots("login");
		 log=new POMLogin();
	}
	
	@Test(priority=1)
	public void title() {
		String actual=log.checktitle(); //since we created object of POMLogin class we can call the methods with log variable
		Assert.assertEquals(actual,"OrangeHRM");
	}
	
	@DataProvider
	public Object[][] Details(){
		
	Object result[][]=Excelsheet.readdata("Sheet1");
	return result;	
		
	}
	@Test(priority=2,dataProvider="Details")
	public void login(String name,String password) throws InterruptedException {
		log.typeusername(name);
		log.typepassword(password);
		Thread.sleep(2000);
		screenshots("logindata");
		
		//Thread.sleep(2000);
		//log.typeusername(prop.getProperty("username"));
		//log.typepassword(prop.getProperty("password"));
		//log.clicklogin();
		}
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
}
