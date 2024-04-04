package steps;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.PaginaPrincipal;

public class TestSteps {

    PaginaPrincipal landingPage = new PaginaPrincipal();

    @Given("^Navegar al portal https://www.ciaf.digital/?")
    public void IngresarUrlHacerLogin() {
        landingPage.IngresarUrlCIAF();
        landingPage.IngresarCredenciales();
    }

    @When("^Validar la Lista de Roles?")
    public void validateCheckoutPlans() {

        List<String> lista = landingPage.DevolverValoresDrpdown();
        List<String> listaEsperada = Arrays.asList("Funcionario", "Docente", "Estudiante");

        Assert.assertEquals(listaEsperada, lista);
    }

    @And("^Ingresar a Faltas de Asistencia?")
    public void RevisarAsistencia() {
        landingPage.ValidacionFaltas();
    }

    @And("^luego al programa de formacion")
    public void RevisarProgramaFormacion() {
        landingPage.IngresarProgramaFormacion();

        String ValorObtenido = landingPage.ExtraccionDatos();
        String ValorEsperado = "Profesional en ingeniería de software";
        Assert.assertEquals(ValorEsperado, ValorObtenido);
    }

    @Then("^Buscar Materia y Cerrar Sesion de usuario?")
    public void CerarSesionUsuario() {
        landingPage.BuscarMateria();
    }

}
