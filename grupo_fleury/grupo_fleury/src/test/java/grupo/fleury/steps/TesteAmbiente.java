package grupo.fleury.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAmbiente {
public static void main(String[] args) {
	System.setProperty("webdriver.chromedriver", "C:\\Users\\katiane\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.fleury.com.br/");
}
}