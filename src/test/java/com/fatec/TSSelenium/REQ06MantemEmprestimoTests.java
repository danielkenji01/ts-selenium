package com.fatec.TSSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class REQ06MantemEmprestimoTests {

	private WebDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void ct01cadastrarEmprestimoComSucesso() {

		Random random = new Random();

		int ra = random.nextInt(1000) + 1000;
		int isbn = random.nextInt(1000) + 1000;

		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(968, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Alunos")).click();
		espera();
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys(String.valueOf(ra));
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("jose");
		driver.findElement(By.id("email")).sendKeys("jose@gmail.com");
		driver.findElement(By.id("cep")).sendKeys("04280130");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera();
		driver.get("https://ts-scel.herokuapp.com/sig/livro");
		espera();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys(String.valueOf(isbn));
		driver.findElement(By.id("autor")).sendKeys("João Vitor");
		driver.findElement(By.id("titulo")).sendKeys("Controle sua mente");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera();
		driver.get("https://ts-scel.herokuapp.com/sig/emprestimo");
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys(String.valueOf(isbn));
		driver.findElement(By.id("ra")).sendKeys(String.valueOf(ra));
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera();
		assertEquals(("Emprestimo registrado"), driver.findElement(By.cssSelector(".text-danger")).getText());
	}

	public void espera() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}