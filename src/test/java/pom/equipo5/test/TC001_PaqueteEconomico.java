package pom.equipo5.test;

import org.junit.Test;
import pom.equipo5.base.TestBaseE5;
import pom.equipo5.pages.PagePaquetes;
import pom.equipo5.pages.VFHomePageE5;

public class TC001_PaqueteEconomico extends TestBaseE5 {

    protected PagePaquetes paginapaquetes;
    protected VFHomePageE5 paginahome;

    @Test
    public void Test(){

        paginahome = new VFHomePageE5(driver);
        paginahome.abrirHome();
        paginapaquetes = new PagePaquetes(driver);
        paginapaquetes.IngresoOrigen();
        paginapaquetes.IngresaCiudadDestino();
        paginapaquetes.FechaIda1();
        paginapaquetes.SiguienteMes();
        paginapaquetes.IngresarFechaIda();
        paginapaquetes.IngresarFechaVuelta();
        paginapaquetes.AplicarFecha();
        paginapaquetes.CasillaHabitacion();
        paginapaquetes.QuitarHuspedes();
        paginapaquetes.AplicarHuspedes();
        paginapaquetes.BuscarPage();
        paginapaquetes.Esperapagina();
        paginapaquetes.OrdenarPrecio();
        paginapaquetes.ValidarTexto();


    }

}
