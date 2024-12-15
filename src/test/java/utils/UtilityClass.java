package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class UtilityClass {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName, testDescription, testCategory, testAuthor;
	public String sheetName;

	public void browserLaunch(String browser,String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("incognito-Chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("−−incognito");
			driver = new ChromeDriver(option);
		} else
			driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void browser_Close() {
		driver.quit();
	}

	public void Screenshot(WebDriver driver) {
		this.driver = driver;
	}

	public static String takeScreenShot(String name) throws IOException {

		String path = "C:\\Automation\\BestBuyGuvi\\Snap\\" + name + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}

	public void visibilityOfElement(WebElement els) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(els));
	}

	public static String[][] readExcel(String sheetname) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook(
				"C:\\Automation\\BestBuyGuvi\\src\\test\\resources\\testData\\BestBuyTestData.xlsx");
		XSSFSheet sheet = book.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();
		short colCount = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i - 1][j] = cell.getStringCellValue();
			}
		}
		book.close();
		return data;
	}

	public void scrollDown(WebElement find) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", find);
	}
	
	public void brokenLinkChecking(List links)
	{
		HttpURLConnection con = null;
		int responseCode = 200;
		String url = "";
	//	List<WebElement> links = driver.findElements(By.xpath("//*[@class=\"body-copy-sm mr-200\"]"));
		Iterator<WebElement> it = links.iterator();
		while (it.hasNext()) {
			url = it.next().getAttribute("href");
			try {
				con = (HttpURLConnection) (new URL(url).openConnection());
				con.setRequestMethod("HEAD");
				con.connect();
				responseCode = con.getResponseCode();
				if (responseCode >= 400) {
					System.out.println(url + "is a broken link");
				} else {
					System.out.println(url + "is a valid link");
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}