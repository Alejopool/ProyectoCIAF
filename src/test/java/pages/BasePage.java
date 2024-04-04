package pages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus
     * subclases
     */
    protected static WebDriver driver;
    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia de WebDriverWait utilizando el
     * 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    /*
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el
     * driver del navegador
     */
    static {
        WebDriverManager.chromedriver().setup();

        // Inicializa la variable estática 'driver' con una instancia de ChromeDriver
        driver = new ChromeDriver();
    }

    /*
     * Este es el constructor de BasePage que acepta un objeto WebDriver como
     * argumento.
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    // Cerrar la sesion de Chrome
    public static void closeBrowser() {
        driver.close();
    }

    // Metodo estatico para navegar a una URL
    public static void navigateTo(String url) {
        driver.get(url);
    }

    // Metodo para expandir el navegador
    public static void expandirNavegador() {
        driver.manage().window().maximize();
    }

    // Hacer una pequeña espera antes de hacer una accion para asegurarse de que el
    // elemento exista
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    // Este metodo realiza click en los botones o donde querramos presionar click
    public void clickElement(String locator) {
        Find(locator).click();
    }

    // Este metodo funciona para escribir en un elemento
    public void write(String locator, String keysToSend) {
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }

    // Ubica el Dropdown por la etiqueta del selector y luego ubica por el value de
    // las opciones
    public void selectFromDropdownByValue(String Locator, String Value) {
        Select dropdown = new Select(Find(Locator));
        dropdown.selectByValue(Value);
    }

    // Validar Assertion de la lista de Roles
    public List<String> getDropdownValues(String locator) {
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : dropdownOptions) {
            values.add(option.getText());
        }

        return values;

    }

    public void sleep10seconds() {
        try {
            // Espera 10 segundos antes de hacer clic en el botón de inicio de sesión
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void sleep30seconds() {
        try {
            // Espera 30 segundos antes de hacer clic en el botón de inicio de sesión
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Extrae el valor de una etiqueta para luego almacenarlo en algun otra etiqueta
    // o hacer una comparativa de algo
    public String getValue(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element.getText();
    }

    // Toma pantallazos teniendo en cuenta que se guarda la hora
    public static void CapturaPantalla() {
        if (driver instanceof TakesScreenshot) {
            try {
                TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
                File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
                String timestamp = dateFormat.format(new Date());
                String screenshotsDirectory = "Capturas_Pantalla/";
                new File(screenshotsDirectory).mkdirs();
                String screenshotFileName = "Pantallazo-" + timestamp + ".png";
                String screenshotFilePath = screenshotsDirectory + screenshotFileName;
                FileHandler.copy(screenshotFile, new File(screenshotFilePath));
            } catch (Exception e) {
                System.out.println("Hubo un error " + e.getMessage());
            }
        }
    }

}
