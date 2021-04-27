package grupo.fleury.steps;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

public class TestesProjSteps {

	private static int WAIT_TIMEOUT = 60;
	private RemoteWebDriver driver;
	private WebDriverWait waitDriver;

	@Before
	public void init() {
		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		waitDriver = new WebDriverWait(driver, WAIT_TIMEOUT);
	}

	@After
	public void teardown() {
		driver.close();
	}

	private WebElement waitElement(By by) {
		return waitDriver.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void aceitaCookies() {
		WebElement cookieButton = waitElement(By.xpath("//*[text()='CONTINUAR']"));
		cookieButton.click();
		System.out.println("Aceitei os cookies");
	}

	@Test
	@Dado("^eu acessar o menu Unidades$")
	public void eu_acessar_o_menu_Unidades() throws Throwable {
                                                                                                                        
	}

	@Test
	@Dado("^escolher de até tres Facilidades$")
	public void escolher_de_até_tres_facilidades() throws Throwable {
		driver.get("https://www.fleury.com.br/unidades");
		aceitaCookies();

		WebElement selectFacilidades = driver.findElement(By.id("checkoox-select-facilities"));
		selectFacilidades.click();
		WebElement checkboxAcessibilidade = driver.findElement(By.xpath("//*[text()='Acessibilidade']"));
		checkboxAcessibilidade.click();
		WebElement checkboxMetro = waitElement(By.xpath("//*[text()='Próximo ao metrô']"));
		checkboxMetro.click();
		WebElement firstCardTitle = driver.findElement(By.tagName("h3"));
		String nomeUnidadeAcessada = firstCardTitle.getText();
		WebElement checkboxDetalhes = driver.findElement(By.xpath("//*[text()='Ver detalhes']"));
		checkboxDetalhes.click();
		WebElement title = waitElement(By.xpath("//*[text()='" + nomeUnidadeAcessada + "']"));

		Assertions.assertEquals(nomeUnidadeAcessada, title.getText());
		Assertions.assertEquals("h3", title.getTagName());
	}

	@Test
	@Quando("^clicar em Ver detalhes na primeira unidade que aparecer$")
	public void clicar_em_Ver_detalhes_na_primeira_unidade_que_aparecer() throws Throwable {

	}

	@Test
	@Entao("^eu devo validar o Nome da Unidade$")
	public void eu_devo_validar_o_nome_da_unidade() {
		// escolher_de_até_tres_facilidades();
		// Assert.assertTrue(//h1);
		// driver.findElementByXPath("//h1").equals(nomeunidade);
	}

}
