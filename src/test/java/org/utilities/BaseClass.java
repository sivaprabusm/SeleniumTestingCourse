package org.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	Actions act = new Actions(driver);
	
	//Method 1 Launch_Chrome
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
	//Method 1.1 Close_Chrome
	public static void exitChrome() {
		driver.close();
	}
	//Method 1.2 Launch_Firefox
	public static void launchFirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	//Method 1.3 Close_Firefox
	public static void exitFirefox() {
		driver.close();
	}
	//Method 1.4 Launch_Edge
	public static void launchEdge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	//Method 1.5 Close_Edge
	public static void exitEdge() {
		driver.close();
	}
	//Method 2 Launch_url
	public static void getUrl(String url) {
		driver.get(url);
	}
	//Method 3 Maximize window
	public static void winMax() {
		driver.manage().window().maximize();
	}
	//Method 4 Get Webpage Title
	public static void printTitle() {
		System.out.println(driver.getTitle());
	} 
	//Method 5 Get current Url
	public static void printCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
	}
	//Method 6 send value to textbox
	public static void fill(WebElement ele, String value) {
		ele.sendKeys(value);
	}
	//Method 7
	public static void btnClick(WebElement ele) {
		ele.click();
	}
	//Method 8.0 Robot_Cut_Option
	public static void valCut() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	//Method 8.1 Robot_Copy_option
	public static void valCopy() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	//Method 8.2 Robot_Paste_option
	public static void valPaste() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	//Method 8.3 Robot_Select_All_option
	public static void selectAll() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	//Method 8.4 Robot_Press_Enter
	public static void pressEnterKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	//Method 8.5 Robot_Press_Escape
	public static void pressEscapeKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
	//Method 8.6 Robot_Press_Tab
	public static void pressTabKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	//Method 8.7 Robot_Press_Down_Arrow
	public static void pressDownArrow() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	//Method 8.8 Robot_Press_Up_Arrow
	public static void pressUpArrow() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}
	//Method 9.0 JavascriptExecutor_Scroll_up_option
	public static void scrollUp(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", ele);
	}
	//Method 9.1 JavascriptExecutor_Scroll_up_option
	public static void scrollDown(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}
	//Method 9.2 JavascriptExecutor_Click
	public static void javascriptClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele);
	}
	//Method 9.3 JavascriptExecutor_GetAttribute ----> To get the value entered in a textBox
	public static void javascriptGetAttribute(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Object obj = js.executeScript("arguments[0].getAttribute('value')", ele);
		String txt = (String)obj;
		System.out.println(txt);
	}
	//Method 9.4 JavascriptExecutor_Highlight_WebElement 
	public static void javascriptHighlightElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow, border:10px solid red')", ele);
	}
	//Method 10.0 Actions_DoubleClick
	public static void doubleClickElement(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).doubleClick().build().perform();
	}
	//Method 10.1 Actions_SingleClick
	public static void singleClickElement(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).doubleClick().build().perform();
	}
	//Method 10.2 Actions_Move_To
	public static void moveToLocator(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	//Method 10.3 Actions_Context_Click
	public static void rightClickElement(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).contextClick().build().perform();
	}
	//Method 11 TakeScreenshot
	public static void screenShotPage(String destinationLocation) throws IOException {
		TakesScreenshot ss = (TakesScreenshot)driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File des = new File(destinationLocation);
		FileUtils.copyFile(src, des);
	}
	//Method 12 Get_Existing_Text
	public static void printWebElementText(WebElement ele) {
		String text = ele.getText();
		System.out.println(text);
	}
	//Method 13 Get_Entered_Value
	public static void printEnteredValue(WebElement ele) {
		String value = ele.getAttribute("value");
		System.out.println(value);
	}
	//Method 14.0 Alert_Simple
	public static void alertSimple() {
		Alert a = driver.switchTo().alert();
		a.accept();
		System.out.println("Alert Handled by pressing OK");
	}
	//Method 14.1 Alert_Confirm_Ok_(OR)_Cancel
	public static void alertConfirm(int value_0or1) {
		Alert a = driver.switchTo().alert();
		if(value_0or1 == 1) {
			a.accept();
			System.out.println("Alert Handled by pressing Ok");
		}
		else {
			a.dismiss();
			System.out.println("Alert Handled by pressing Cancel");
		}
	}
	//Method 14.2 Alert_Prompt_Text_OK_(OR)_Cancel
	public static void alertPrompt(String txt, int value_0or1) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(txt);
		if(value_0or1 == 1) {
			a.accept();
			System.out.println("Alert Handled by pressing Ok");
		}
		else {
			a.dismiss();
			System.out.println("Alert Handled by pressing Cancel");
		}
	}
	//Method 15.0 Switch_To_Frame_With_FrameId
	public static void switchToFrameId(String id_or_name) {
		driver.switchTo().frame(id_or_name);
	}
	
	//Method 15.1 Switch_To_Frame_With_WebElement
	public static void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);
	}
	//Method 15.2 Switch_To_Frame_With_Frame_IndexNumber
	public static void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	//Method 15.3 Switch_To_Main_HTML_From_Current_Frame
	public static void switchToHomeFrame() {
		driver.switchTo().defaultContent();
	}
	//Method 15.4 Switch_To_Immediate_Parent_Frame
	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	//Method 16.0 Windows_Handling_Switch_To_Second_Tab ---> Total number of tabs - 2
	public static void switchToNextTab() {
		String parentId = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String eachId : handles) {
			if(!parentId.equals(eachId)) {
				driver.switchTo().window(eachId);
			}
		}
	}
	//Method 16.1 Windows_Handling_Switch_To_nth_Tab ----> Number of tabs - more than 2
	public static void switchToTab(int tab) {
		Set<String> handles = driver.getWindowHandles();
		int count = 1;
		for (String eachId : handles) {
			if(count == tab) {
				driver.switchTo().window(eachId);
			}
			count++;
		}
	}
	//Method 17.0 Static_Wait
	public static void waitStatic(long millisecs) throws InterruptedException {
		Thread.sleep(millisecs);
	}
	//Method 17.1 Implicit_Wait
	public static void waitImplicit(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	//Method 17.2 Fluent_Wait
	public static void waitFluent(long secs, long poll) {
		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(secs)).pollingEvery(Duration.ofSeconds(poll)).ignoring(Throwable.class);
	}
	
	//Method 18 Select_isMultiSelectDropdown
	public static void isMultiSelect(WebElement ele) {
		Select s = new Select(ele);
		boolean a = s.isMultiple();
		if(a) {
			System.out.println("The dropdown is a multi-Select");
		}
		else {
			System.out.println("The dropdown is single-select");
		}
	}
	//Method 18.1 Select_ByValue
	public static void singleSelectOptionByValue(WebElement ele, String value) {
		Select s = new Select(ele);
		s.selectByValue(value);
	}
	//Method 18.2 Select_ByVisibleText
	public static void singleSelectOptionByVisibleText(WebElement ele, String visibleText) {
		Select s = new Select(ele);
		s.selectByVisibleText(visibleText);
	}
	//Method 18.3 Select_ByIndex
	public static void singleSelectOptionByIndex(WebElement ele, int index) {
		Select s = new Select(ele);
		s.selectByIndex(index);
	}
	//Method 18.4 Get all the options from the Dropdown
	public static void getAllOptionsFromDropdown(WebElement ele) {
		Select s = new Select(ele);
		List<WebElement> li = s.getOptions();
		for (int i = 0; i < li.size(); i++) {
			WebElement eachElement = li.get(i);
			String text = eachElement.getText();
			System.out.println(text);
		}
	}
	//Method 18.5 Multi-Select_ByIndex
	public static void multiSelectByIndex(WebElement ele, int[] index) {
		Select s = new Select(ele);
		for (int i = 0; i < index.length; i++) {
			s.selectByIndex(index[i]);
		}
	}
	//Method 18.6 Multi-Select_ByVisibleText
	public static void multiSelectByVisibleText(WebElement ele, String[] visibleText) {
		Select s = new Select(ele);
		for (int i = 0; i < visibleText.length; i++) {
			s.selectByVisibleText(visibleText[i]);
		}
	}
	//Method 18.7 Multi-Select_ByValue
	public static void multiSelectByValue(WebElement ele, String[] values) {
		Select s = new Select(ele);
		for (int i = 0; i < values.length; i++) {
			s.selectByValue(values[i]);
		}
	}
	//Method 18.8 Get all multi-Selected options from dropdown
	public static void getAllMultiSelectedOptionsFromDropdown(WebElement ele) {
		Select s = new Select(ele);
		List<WebElement> list = s.getAllSelectedOptions();
		for (WebElement eachElement : list) {
			System.out.println(eachElement.getText());
		}
	}
	//Method 18.9 Get first select option from dropdown
	public static void getFirstSelectedOptionFromDropdown(WebElement ele) {
		Select s = new Select(ele);
		WebElement option = s.getFirstSelectedOption();
		System.out.println(option.getText());
	}
	//Method 18.10 Deselect by index
	public static void deselectOptionByIndex(WebElement ele, int index) {
		Select s = new Select(ele);
		s.deselectByIndex(index);

	}
	//Method 18.11 Deselect by value
	public static void deselectOptionByValue(WebElement ele, String value) {
		Select s = new Select(ele);
		s.deselectByValue(value);
	}
	//Method 18.12 Deselect by visible text
	public static void deselectOptionByVisibleText(WebElement ele, String visibleText) {
		Select s = new Select(ele);
		s.deselectByVisibleText(visibleText);
	}
	//Method 18.13 Deselect all options
	public static void deselectAllOptions(WebElement ele) {
		Select s = new Select(ele);
		s.deselectAll();
	}
	//Method 18.14 Multi-deselect by index
	public static void multiDeselectByIndex(WebElement ele, int[] index) {
		Select s = new Select(ele);
		for (int i = 0; i < index.length; i++) {
			s.deselectByIndex(index[i]);
		}
	}
	//Method 18.15 Multi-deselect by value
	public static void multiDeselectByValue(WebElement ele, String[] values) {
		Select s = new Select(ele);
		for (int i = 0; i < values.length; i++) {
			s.deselectByValue(values[i]);
		}
	}
	//Method 18.16 Multi-deselect by visible text
	public static void multiDeselectByVisibleText(WebElement ele, String[] visibleTexts) {
		Select s = new Select(ele);
		for (int i = 0; i < visibleTexts.length; i++) {
			s.deselectByVisibleText(visibleTexts[i]);
		}
	}
	//Method 19 Find_Table
	private void testMethod() {
		int q=100;
	}
}
