package Steps;


import Pages.Coprarprodutopage;
import Runner.RunCucumberTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class CompraProdutoStep  extends RunCucumberTest {

    Coprarprodutopage coprarprodutoPg = new Coprarprodutopage(driver);
    @Dado("^que estou na tela de home$")
    public void queEstouNaTelaDeHome()  {
        coprarprodutoPg.acessarHome();
    }

    @Dado("^acesso a secao masculina$")
    public void acessoASecaoMasculina()  {
        coprarprodutoPg.acessoMasculino();
        String texto = driver.findElement(By.xpath("//*[@id=\"categoryPage\"]/div/section/div[1]/div[1]/h1")).getText();
        Assert.assertEquals("Masculino",texto);
    }

    @Dado("^clico na secao camisetas$")
    public void clicoNaSesaoCamisetas()  {
       coprarprodutoPg.acessarCamisetas();
       String texto = driver.findElement(By.xpath("//*[@id=\"categoryPage\"]/div/section/div[1]/div[1]/h1")).getText();
       Assert.assertEquals("Camisetas",texto);
    }
    @Quando("^vejo a tela de camisetas masculinas$")
    public void vejoATelaDeCamisetasMasculinas() throws InterruptedException  {
        coprarprodutoPg.Scroll1();
    }

    @Quando("^finalizar a compra$")
    public void finalizarACompra()  {
        coprarprodutoPg.escolherProduto();
        coprarprodutoPg.finalizarCompra();
    }
    @Entao("^comprar o produto$")
    public void comprarOproduto() throws InterruptedException {
        coprarprodutoPg.Scroll2();
        coprarprodutoPg.pagar();

    }

    @After(order = 1)
    public void screenshot(Scenario cenario){
        File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshot/"+cenario+".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
