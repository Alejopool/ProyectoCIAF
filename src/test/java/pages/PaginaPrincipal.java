package pages;

import java.util.List;

public class PaginaPrincipal extends BasePage {

    // Etiquetas Del DOM de login
    private String UsuarioLogin = "//input[@id='logina']";
    private String ContrasenaLogin = "//input[@id='clavea']";
    private String ListaSelectDropdown = "//select[@id='roll']";
    private String ClickIngresar = "//input[@value='Ingresar']";

    // Validar Faltas
    private String FaltasReportadas = "//small[normalize-space()='Faltas']";
    private String CerrarTableroFaltas = "//div[@id='myModalFaltas']//button[@type='button'][normalize-space()='Cancelar']";

    // Validar Programa de Formacion
    private String ProgramaFormacion = "/html[1]/body[1]/div[1]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[1]/a[1]";
    private String ClickProgramaFormacion = "//*[@id=\"contenido\"]/li/a/span";

    // Buscar Materia y cerrar Sesion
    private String InputBuscar = "//input[@type='search']";
    private String BotonCerrarSesion = "//i[@class='fa-solid fa-power-off']";

    public PaginaPrincipal() {
        super(driver);
    }

    public void IngresarUrlCIAF() {
        navigateTo("https://www.ciaf.digital/");
    }

    public void IngresarCredenciales() {
        write(UsuarioLogin, "ja.lopez20@ciaf.edu.co");
        write(ContrasenaLogin, "");
        clickElement(ListaSelectDropdown);
        CapturaPantalla();
        selectFromDropdownByValue(ListaSelectDropdown, "Estudiante");

        clickElement(ClickIngresar);

    }

    public List<String> DevolverValoresDrpdown() {
        return getDropdownValues(ListaSelectDropdown);
    }

    public void ValidacionFaltas() {
        clickElement(FaltasReportadas);
        sleep10seconds();
        clickElement(CerrarTableroFaltas);
    }

    public void IngresarProgramaFormacion() {
        clickElement(ProgramaFormacion);
        clickElement(ClickProgramaFormacion);

    }

    public String ExtraccionDatos() {
        String Valor = getValue(ClickProgramaFormacion);
        return Valor;
    }

    public void BuscarMateria() {
        write(InputBuscar, "Yanci Viviana");
        sleep30seconds();
        clickElement(BotonCerrarSesion);
    }

}
