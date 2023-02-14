package Runner;


import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.SnippetType;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.Utils;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/Features/ComprarProdutos.feature",
        glue = {"Steps"},
        tags = {"~@ignore"},
        plugin = "pretty",
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        strict = false
)
public class RunCucumberTest  {
    public static WebDriver driver;

    @BeforeClass
    public static void start(){
        driver = new ChromeDriver();

    }

    @AfterClass
    public static void stop(){
        driver.quit();

    }



}
