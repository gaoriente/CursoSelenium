import org.junit.Assert;
import org.junit.Test;
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

}
