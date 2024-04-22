package pages;

public class TourNavegation extends BasePage {

    public TourNavegation() {
        super(driver);
    }

    // ingreso a DashBoard
    private String IngresarDashboard = "//p[normalize-space()='Dashboard']";

    // Ingreso a Programa de formacion
    private String ProgramaFormacion = "/html[1]/body[1]/div[1]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]";
    private String ClickProgramaFormacion = "//*[@id=\"contenido\"]/li/a/span";

    // Recursos Digiales
    private String RecursosDigitales = "/html[1]/body[1]/div[1]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]";
    private String BotonCajaHerramientas = "//p[normalize-space()='Caja de Herramientas']";

    // Caracterizacion
    private String BotonCaracterizacion = "/html[1]/body[1]/div[1]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[5]/a[1]";

    // Historial Academico
    private String BotonHistorialAcademico = "/html[1]/body[1]/div[1]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[6]/a[1]/p[1]";

    // Mis Certificados
    private String BottonCertificados = "/html[1]/body[1]/div[1]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[7]/a[1]/p[1]";

    // Renovacion
    private String BotonRenovacion = "/html[1]/body[1]/div[1]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[8]/a[1]";
    private String BotonFinanciera = "//a[@href='rematriculafinanciera.php']";

    // MI financiacion
    private String BotonMiFinanciacion = "/html[1]/body[1]/div[1]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[9]/a[1]/p[1]";

    // Feria de emprendiemiento
    private String BotonFeriaEmprendimiento = "/html[1]/body[1]/div[1]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[11]/a[1]/p[1]";

    // Cerrar Sesion
    private String BotonCerrarSesion = "//i[@class='fa-solid fa-power-off']";

    public void NavegarPorOpciones() {
        sleep5seconds();
        clickElement(IngresarDashboard);
        sleep5seconds();
        clickElement(ProgramaFormacion);
        clickElement(ClickProgramaFormacion);
        sleep5seconds();
        clickElement(RecursosDigitales);
        clickElement(BotonCajaHerramientas);
        sleep5seconds();
        clickElement(BotonCaracterizacion);
        sleep5seconds();
        clickElement(BotonHistorialAcademico);
        sleep5seconds();
        clickElement(BottonCertificados);
        sleep5seconds();
        clickElement(BotonRenovacion);
        clickElement(BotonFinanciera);
        sleep5seconds();
        clickElement(BotonMiFinanciacion);
        sleep5seconds();
        clickElement(BotonFeriaEmprendimiento);
        sleep5seconds();
    }

    public void CerrarSesion() {
        clickElement(BotonCerrarSesion);
    }

}
