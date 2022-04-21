package pack2;

import java.util.List;
import java.util.Set;

import org.bouncycastle.util.Arrays.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {
  @Test
  public void navigateMethod() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver  = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  
	  driver.get("https://www.saucedemo.com/");
	  Thread.sleep(4000);
	  
	  driver.get("https://www.google.com/");
	  Thread.sleep(4000);
	  
	  driver.navigate().refresh();
	  Thread.sleep(4000);
	  
	  driver.navigate().back();
	  Thread.sleep(4000);
	  
	  driver.navigate().forward();
	  
	  Thread.sleep(4000);
	  driver.quit();
  }
   
  @Test
  public void findMultipleElements() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver  = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("https://www.saucedemo.com/");
	  //driver.findElements(By.tagName("a"));//localisation par tagname
	  
	  
	  List<WebElement> maList = driver.findElements(By.cssSelector("input"));
	  
	  //System.out.println("my list" + myList);
	  for(WebElement element: maList) {
		  String monAttr = element.getAttribute("name");
		  System.out.println("Attribut= " + monAttr);
	  }
	   
	  driver.quit();
  }
  
  @Test
  public void findMultipleElementsDevoir() throws Exception {
	  //recuperer le tag A et le HREF et le linktext
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver  = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("https://www.saucedemo.com/");
	  
	  //user-name 			standard_user
	  //password 			secret_sauce
	  driver.findElement(By.id("user-name")).sendKeys("standard_user");
	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  driver.findElement(By.id("login-button")).click();
	  
	  //https://www.saucedemo.com/inventory.html
	  //driver.findElements(By.tagName("a"));//localisation par tagname
	  
	  
	  List<WebElement> maList = driver.findElements(By.cssSelector("a"));
	  
	  //System.out.println("my list" + myList);
	  for(WebElement element: maList) {
		  String href = element.getAttribute("href");
		  String text = element.getText();//.getAttribute("innerHTML");
		  
		  System.out.println("href: " + href + "text link: " + text);
	  }
	   
	  Thread.sleep(10000);
	  driver.quit();
  }
  
  
  @Test
  public void findMultipleElementsDevoir2() throws Exception {
	  //recuperer la coleur
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver  = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("https://www.saucedemo.com/");
	  
	  WebElement elem = driver.findElement(By.cssSelector("#login-button"));
	  String color = elem.getCssValue("background-color");
	  System.out.println("color: " + color);
	  
	  driver.quit();
  }
  
  
  @Test
  public void findMultipleElementsDevoir3Lisez1erParagraph() throws Exception {
	  //Open a popup window
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().minimize();
	  
	  driver.get("http://omayo.blogspot.com/");
	  String handlePageId = driver.getWindowHandle();
	  System.out.println("getWindowHandle: " + handlePageId);
	  
	  driver.findElement(By.linkText("Open a popup window")).click();
	  Set<String> windows = driver.getWindowHandles();
	  
	  for(String pageHandleId: windows) {
		  System.out.println("page handle id" + pageHandleId);
	  }
	  
	  java.util.Iterator<String> iterateur = windows.iterator();
	  while(iterateur.hasNext()) {
		  String window = iterateur.next();
		  driver.switchTo().window(window);
		  if (driver.getTitle().equals("Basic Web Page Title")) {
			  String text = driver.findElement(By.id("para1")).getText();
			  System.out.println("Paragraph text: " + text);
		  }
	  }
	  
	  driver.switchTo().window(handlePageId);
	  driver.findElement(By.id("checkbox1")).click();

	  driver.quit();
  }
}
