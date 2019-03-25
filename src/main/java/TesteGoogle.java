import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
	@Test
	public void teste() {
//		System.setProperty("webdriver.gecko.driver", "/Users/gabrieloriente/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
//		Assert.assertTrue(condition); Verifica se eh verdadeiro
		Assert.assertEquals("Google", driver.getTitle()); //verifica se é igual
		driver.quit(); //fechar instancias abertas
	}
	
	@Test
	public void apiProd() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://my-hive-api-production.sa-east-1.elasticbeanstalk.com/");
		Assert.assertEquals("Welcome to CodeIgniter!", driver.findElement(By.tagName("h1")).getText());
		driver.quit();
	}

}
