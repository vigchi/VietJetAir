package com.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Viet {
	private static String getData(int rowNo, int cellno) throws Throwable {
		String v = null;
		File loc = new File("C:\\Users\\Vignesh Chinnappa\\eclipse-workspace\\Shopee\\Testdata\\Data.xlsx");
		FileInputStream stream = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellno);
		int type = c.getCellType();
		if(type==1) {
			v = c.getStringCellValue();
		}
		else if(type==0) {
			if(DateUtil.isCellDateFormatted(c)) {
				Date dateCellValue = c.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd-MMM-yyyy");
				v = sim.format(dateCellValue);			
			}
			else {
			double numericCellValue = c.getNumericCellValue();
			long l=(long)numericCellValue;
			v = String.valueOf(l);
			}
		}
	return v;
	}
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vignesh Chinnappa\\eclipse-workspace\\Integration\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//ChromeOptions options = new ChromeOptions();
		driver.get("https://www.vietjetair.com/Sites/Web/en-US/Home");
		driver.manage().window().maximize();
		
		WebElement option1 = driver.findElement(By.xpath("//*[@id=\"ctl00_UcRightV31_RbOneWay\"]"));
		option1.click();
		
		WebElement drop1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/span/span[1]/span"));
		drop1.click();
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		WebElement drop2 = driver.findElement(By.xpath("//*[@id=\"select2-selectDestination-container\"]"));
		drop2.click();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		WebElement cal = driver.findElement(By.xpath("//*[@id=\"ctl00_UcRightV31_TxtDepartDate\"]"));
		cal.click();
		WebElement cal_val = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[3]/a"));
		cal_val.click();
		
		WebElement search = driver.findElement(By.xpath("//*[@id=\"ctl00_UcRightV31_BtSearch\"]"));
		search.click();
		
		Thread.sleep(10000);
		WebElement option2 = driver.findElement(By.xpath("//*[@id=\"gridTravelOptDep\"]"));
		option2.click();
		
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		Actions actions = new Actions(driver);
		WebElement continue1 = driver.findElement(By.xpath("//*[@id=\"contentwsb\"]/div[5]/a[1]"));
		actions.moveToElement(continue1).perform();
		
		//WebElement continue1 = driver.findElement(By.xpath("//*[@id=\"contentwsb\"]/div[5]/a[1]"));
		continue1.click();
		Thread.sleep(3000);
		
		WebElement drop3 = driver.findElement(By.xpath("//*[@id=\"txtPax1_Gender\"]"));
		Select dr = new Select(drop3);
		dr.selectByValue("M");
		
		WebElement txtFname = driver.findElement(By.xpath("//*[@id=\"txtPax1_LName\"]"));
		txtFname.sendKeys("Senthil");
		
		WebElement txtLname = driver.findElement(By.xpath("//*[@id=\"txtPax1_FName\"]"));
		txtLname.sendKeys("Prabu");
		
		WebElement txtaddress = driver.findElement(By.xpath("//*[@id=\"txtPax1_Addr1\"]"));
		txtaddress.sendKeys("42, A Vasantham");
		
		WebElement txtcity = driver.findElement(By.xpath("//*[@id=\"txtPax1_City\"]"));
		txtcity.sendKeys("Chennai");
		
		WebElement drop4 = driver.findElement(By.xpath("//*[@id=\"txtPax1_Ctry\"]"));
		Select dr1 = new Select(drop4);
		dr1.selectByValue("102");
		
		WebElement drop5 = driver.findElement(By.xpath("//*[@id=\"txtPax1_Prov\"]"));
		Select dr2 = new Select(drop5);
		dr2.selectByValue("10099");
		
		WebElement txtmail = driver.findElement(By.xpath("//*[@id=\"txtPax1_EMail\"]"));
		txtmail.sendKeys("senthil.mdu@gmail.com");
		
		WebElement txtmobile = driver.findElement(By.xpath("//*[@id=\"txtPax1_Phone2\"]"));
		txtmobile.sendKeys("8898745223");
		
		WebElement continue3 = driver.findElement(By.xpath("//*[@id=\"contentwsb\"]/div[3]/a[1]"));
		continue3.click();
		
		Thread.sleep(8000);
		WebElement nothanks = driver.findElement(By.xpath("//*[@id=\"editBtn1\"]/ul/li[2]/a"));
		nothanks.click();
		
		Thread.sleep(8000);
		WebElement continue4 = driver.findElement(By.xpath("//*[@id=\"shop\"]/table[3]/tbody/tr/td[2]/a"));
		continue4.click();
		
		Thread.sleep(5000);
		WebElement close = driver.findElement(By.xpath("//*[@id=\"plPopup\"]/a[1]"));
		close.click();
		
		WebElement print = driver.findElement(By.xpath("//*[@id=\"rescharges\"]/tbody/tr[8]/td[2]/strong"));
		String text = print.getText();
		System.out.println(text);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
