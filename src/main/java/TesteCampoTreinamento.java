import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
	@Test
	public void testeTextField() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + 
				System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de campo");
		Assert.assertEquals("Teste de campo", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		driver.quit(); //fechar instancias abertas
	}
	
	@Test
	public void testeTextArea() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + 
				System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
		Assert.assertEquals("teste", 
				driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	public void testeRadioButton() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + 
				System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(
		driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.quit();
	}
	
	@Test
	public void testeCheckBox() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + 
				System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		driver.quit();
	}
	
	@Test
	public void testeCombo() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + 
				System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByIndex(3);
//		 ou poderia ser feito por -> combo.selectByValue("superior");
//		Ou também combo.selectByVisibleText("2o grau incompleto");
		
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
		driver.quit();
	}
	
	@Test
	public void deveVerificarValoresCombo() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + 
				System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		java.util.List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		
		for(WebElement option: options) {
			if(option.getText().contentEquals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		
		Assert.assertTrue(encontrou);
		driver.quit();
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + 
				System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		Assert.assertEquals(3, combo.getAllSelectedOptions().size());
		
		combo.deselectByVisibleText("Natacao");
		combo.deselectByVisibleText("Corrida");
		combo.deselectByVisibleText("O que eh esporte?");
		
		driver.quit();
	}
	
	@Test
	public void deveInteragisComBotoes() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + 
				System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();
	}
	
	@Test
	@org.junit.Ignore //ELE DIZ PARA O JUNIT NAO EXECUTAR O TESTE
	public void deveInteragisComLinks() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + 
				System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement link = driver.findElement(By.linkText("Voltar"));
		link.click();
		
//		Assert.fail(); quando quer que de falha para anotação
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		driver.quit();
	}
	
	@Test
	public void buscaTextoNaPagina() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + 
				System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
//		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		driver.quit();
	}
}
