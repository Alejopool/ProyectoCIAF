package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import pages.BasePage;

public class Hooks extends BasePage {

    public Hooks() {
        super(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.log("Escenario Fallido, Por favor revisar la Imagen adjuntada en el reporte");
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot of the error");
        } else {
            scenario.log("Escenario Exitoso, se adjunta la Imagen en el reporte");
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot of the success");
        }
    }

}
