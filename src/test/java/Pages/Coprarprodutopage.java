package Pages;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Coprarprodutopage  {

    WebDriver driver;
    public Coprarprodutopage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarHome(){
        driver.manage().window().maximize();
        driver.get("https://www.khelf.com.br/");
        driver.findElement(By.xpath("//*[@id=\"adopt-accept-all-button\"]")).click();
    }

    public void acessoMasculino(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"reactTop\"]/div/header/nav/ul/li[5]/div/a")).click();//entrar aba masculina
    }

    public void acessarCamisetas(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"categoryPage\"]/div/section/div[2]/div/div/div[1]/div[1]/button/h4")).click(); //clicar categoria
        driver.findElement(By.xpath("//*[@id=\"categoryPage\"]/div/section/div[2]/div/div/div[1]/div[1]/div/div/a[7]")).click(); // clicar aba camisetas

    }
    public void escolherProduto(){
        driver.findElement(By.xpath("//*[@id=\"categoryPage\"]/div/section/div[3]/div[1]/article[4]/a/div[1]/picture[2]/img")).click();// clica na camiseta
        driver.findElement(By.xpath("//*[@id=\"productPage\"]/div/section/div[1]/section/div[2]/div/div[2]/div[5]/div[2]/div/div[2]/button")).click(); //escolhe tamanho
        driver.findElement(By.xpath("//*[@id=\"productPage\"]/div/section/div[1]/section/div[2]/div/div[2]/div[6]/div/div/button")).click();//adicionar a sacola

    }
    public void finalizarCompra(){
        driver.findElement(By.xpath("//*[@id=\"reactAside\"]/section/section/div[3]/a")).click();
    }

    public void pagar(){
        driver.findElement(By.xpath("//*[@id=\"cart-to-orderform\"]")).click();
    }

    public void Scroll1() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,1000)");
        Thread.sleep(4000);
    }

    public void Scroll2() throws InterruptedException {
        JavascriptExecutor ss = (JavascriptExecutor) driver;
        ss.executeScript("window.scrollTo(0,1000)");
        Thread.sleep(1000);

    }


}
