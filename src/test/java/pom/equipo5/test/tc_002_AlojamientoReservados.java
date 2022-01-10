package pom.equipo5.test;

import org.junit.Test;
import pom.equipo5.base.TestBaseE5;
import pom.equipo5.pages.PageAlojamiento;
import pom.equipo5.pages.VFHomePageE5;


public class tc_002_AlojamientoReservados extends TestBaseE5 {

    protected PageAlojamiento paginaAlojamiento;
    protected VFHomePageE5 paginahome;


    @Test
    public void Test() {
        //usar POM :: declarar las pages asoiciadas a la prueba
        paginaAlojamiento = new PageAlojamiento(driver);
        paginahome = new VFHomePageE5(driver);
        paginahome.abrirHome();
        paginaAlojamiento.SeccionDeAlojamiento();
        paginaAlojamiento.IngresarBusqueda();
        paginaAlojamiento.SeleccionarUnDestino();
        paginaAlojamiento.FechaEntrada();
        paginaAlojamiento.FechaSalida();
        paginaAlojamiento.SeleccionarCantAdultos();
        paginaAlojamiento.SeleccionarCantMenores();
        paginaAlojamiento.SeleccionarEdadMenor();
        paginaAlojamiento.EdadOtroMenor();
        paginaAlojamiento.AgrgarHabitacion();
        paginaAlojamiento.AgregarAdulto();
        paginaAlojamiento.AgregarMenor();
        paginaAlojamiento.EdadMenorAgregado();
        paginaAlojamiento.ClickAplicar();
        paginaAlojamiento.BotonBusqueda();
        paginaAlojamiento.MensajeGuardado();
        paginaAlojamiento.Validartxt();


    }
}