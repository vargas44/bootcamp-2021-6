package pom.equipo5.test;

import org.junit.Test;
import pom.equipo5.base.TestBaseE5;
import pom.equipo5.pages.PagePaquetes;
import pom.equipo5.pages.VFHomePageE5;

public class TC002_PaqueteFiltroMesNoche extends TestBaseE5 {

    protected PagePaquetes paginapaquetes;
    protected VFHomePageE5 paginahome;

    @Test
    public void Test(){

        paginahome = new VFHomePageE5(driver);
        paginahome.abrirHome();
        paginapaquetes = new PagePaquetes(driver);
        paginapaquetes.IngresoOrigine2();
        paginapaquetes.IngresaCiudadDestino2();
        paginapaquetes.CasillaHabitacion2();
        paginapaquetes.SeleccionSinEleccion();
        paginapaquetes.SeleccionarMes();
        paginapaquetes.ClickBuscar();
        paginapaquetes.FiltrarPorNoche();
        paginapaquetes.SeleccionNoches();
        paginapaquetes.Esperapagina2();
        paginapaquetes.Validacion();
        paginapaquetes.ValidacionSecundaria();


    }
}
