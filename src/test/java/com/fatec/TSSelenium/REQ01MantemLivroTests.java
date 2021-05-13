package com.fatec.TSSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class REQ01MantemLivroTests {

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
	public void ct01cadastrolivrocomsucesso() {
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
		driver.findElement(By.linkText("Excluir")).click();
		espera();
		assertEquals(("Lista de livros"), driver.findElement(By.cssSelector(".panel-title")).getText());
	}

	@Test
	public void ct02listarlivrocomsucesso() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(968, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		espera();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
		espera();
		assertEquals(("Lista de livros"), driver.findElement(By.cssSelector(".panel-title")).getText());
	}

	@Test
	public void ct03editarlivrocomsucesso() {
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
		driver.findElement(By.linkText("Editar")).click();
		driver.findElement(By.id("isbn")).clear();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("5678");
		driver.findElement(By.id("autor")).clear();
		driver.findElement(By.id("autor")).sendKeys("Mariano Cleber");
		driver.findElement(By.id("titulo")).clear();
		driver.findElement(By.id("titulo")).sendKeys("Harry Potter");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera();
		assertEquals(("Lista de livros"), driver.findElement(By.cssSelector(".panel-title")).getText());
	}

	@Test
	public void ct04excluirlivrocomsucesso() {
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
		driver.findElement(By.linkText("Excluir")).click();
	}

	public void espera() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}