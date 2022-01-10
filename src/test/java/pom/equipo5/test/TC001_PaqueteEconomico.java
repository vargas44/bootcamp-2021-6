package pom.equipo5.test;

import org.junit.Test;
import pom.equipo5.base.TestBaseE5;
import pom.equipo5.pages.PagePaquetes;
import pom.equipo5.pages.VFHomePageE5;

public class TC001_PaqueteEconomico extends TestBaseE5 {

    protected PagePaquetes paginaPaquetes;
    protected VFHomePageE5 paginahome;

    @Test
    public void Test() {
        //usar POM :: declarar las pages asoiciadas a la prueba
        paginaPaquetes = new PagePaquetes(driver);
        paginahome = new VFHomePageE5(driver);
        paginahome.abrirHome();
        paginaPaquetes.CasillaOrigen();
        paginaPaquetes.IngresaCiudadOrigen();
        paginaPaquetes.CasillaDestino();
        paginaPaquetes.IngresaCiudadDestino();
        paginaPaquetes.CasillaFechaIda();
        paginaPaquetes.SiguienteMes();
        paginaPaquetes.IngresarFechaIda();
        paginaPaquetes.IngresarFechaVuelta();
        paginaPaquetes.AplicarFecha();
        paginaPaquetes.CasillaHabitacion();
        paginaPaquetes.QuitarHuspedes();
        paginaPaquetes.AplicarHuspedes();
        paginaPaquetes.BuscarPage();
        paginaPaquetes.OrdenarPrecio();
        paginaPaquetes.ValidarText();

    }

}
