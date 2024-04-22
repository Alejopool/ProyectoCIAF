package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", // Directorio de nuestros archivos .feature
        glue = "steps", // Paquete donde tenemos nuestras clases definiendo los steps
        plugin = { "pretty", "html:target/cucumber-reports" }, tags = "@papa")

public class TestRunner {

    // Lo que hace es Expandir el navegador antes de ejecutar la prueba
    @BeforeClass
    public static void expandirNavegador() {
        BasePage.expandirNavegador();

    }

    // Lo que hace es cerrar el navegador despues de la prueba
    @AfterClass
    public static void cleanDriver() {
        BasePage.closeBrowser();
    }
}
