package com.fatec.TSSelenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class REQ02MantemLivroExcecoesTests {

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
	public void ct01cadastrolivroisbnjacadastrado() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(968, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		espera();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).sendKeys("João Vitor");
		driver.findElement(By.id("titulo")).sendKeys("Controle sua mente");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera();
		driver.get("https://ts-scel.herokuapp.com/sig/livro");
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).sendKeys("João Vitor");
		driver.findElement(By.id("titulo")).sendKeys("Controle sua mente");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		assertEquals(("Livro ja cadastrado"), driver.findElement(By.cssSelector(".text-danger")).getText());
	}
	
	@Test
	public void ct02cadastrolivroisbninvalido() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(968, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		espera();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("123");
		driver.findElement(By.id("autor")).sendKeys("João Vitor");
		driver.findElement(By.id("titulo")).sendKeys("Controle sua mente");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera();
		assertEquals(("ISBN deve ter 4 caracteres"), driver.findElement(By.cssSelector(".text-danger")).getText());
	}
	
	@Test
	public void ct03cadastrolivroisbninvalido() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(968, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		espera();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("12345");
		driver.findElement(By.id("autor")).sendKeys("João Vitor");
		driver.findElement(By.id("titulo")).sendKeys("Controle sua mente");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera();
		assertEquals(("ISBN deve ter 4 caracteres"), driver.findElement(By.cssSelector(".text-danger")).getText());
	}
	
	@Test
	public void ct04cadastrolivronomeinvalido() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(968, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		espera();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).sendKeys("João Vitor");
		driver.findElement(By.id("titulo")).sendKeys("kajskdljakdljsldkjakdljsakajskdljakdljsldkjakdljsakajskdljakdljsldkjakdljsa");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera();
		assertEquals(("Titulo deve ter entre 1 e 50 caracteres"), driver.findElement(By.cssSelector(".text-danger")).getText());
	}
	
	@Test
	public void ct05cadastrolivronomeinvalido() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(968, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		espera();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).sendKeys("João Vitor");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera();
		assertEquals(("Titulo deve ter entre 1 e 50 caracteres"), driver.findElement(By.cssSelector(".text-danger")).getText());
	}

	public void espera() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}