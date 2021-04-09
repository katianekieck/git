import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class PassosTeste {
	private WebDriver driver;
	
	@Dado("^eu acessar o menu Unidades$")
	public void eu_acessar_o_menu_unidades() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.fleury.com.br/");
		driver.findElement(By.xpath("//input[contains(text(),'Unidades')]")).click();

	}

	@Dado("^escolher de (\\d+) a (\\d+) Facilidades$")
	public void escolher_de_a_facilidades(int int1, int int2) {
		// Select combo = new
		// Select(driver.findElement(By.id"("checkoox-select-facilities")"";"
		// driver.findElement(By.xpath(“//input[contains(@id,'senha')];
		// Select facilidades = new
		// Select(driver.findElement(By.name("_Acessibilidade")));

		Select combo = new Select(driver.findElement(By.id("checkoox-select-facilities")));
		combo.selectByValue("Acessibilidade");
		combo.selectByValue("Próximo ao metrô");
		combo.selectByValue("Bicicletário e vaga verde");

	}

	@Quando("^clicar em Ver detalhes na primeira unidade que aparecer$")
	public void clicar_em_ver_detalhes_na_primeira_unidade_que_aparecer() {
		driver.findElement(By.xpath("//input[contains(text(),'Ver detalhes')]")).click();

		driver.findElement(By.id("button-see-on-map-2-analia-franco-ii")).click();

	}

	@Então("^eu devo validar o Nome da Unidade$")
	public void eu_devo_validar_o_nome_da_unidade(String texto) {
		WebElement texto1 =driver.findElement(By.xpath("//[contains(text(),'Anália Franco II\r\n"+ "')]"));
		 
		assertEquals("Anália Franco II", texto1);

	}

}
