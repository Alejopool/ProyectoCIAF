Feature: Navegar y hacer accciones en el portal de CIAF
    Lo que se pretende hacer realizar un test
    de manera automatica en el portal
    implementando tecnologias de automatizacion.

    @BuscarProfe
    Scenario Outline: Navegar al portal de la CIAF
        Given Navegar al portal https://www.ciaf.digital/
        When Validar la Lista de Roles
        And Ingresar a Faltas de Asistencia
        And luego al programa de formacion
        Then Buscar Materia y Cerrar Sesion de usuario


    @TourCiafDigital
    Scenario: Ingresar a los diferentes campos del portal CIAF DIGITAL
        Given Navegar al portal https://www.ciaf.digital/
        When Validar la Lista de Roles
        And Ingresar y navegar a las diferentes Opciones