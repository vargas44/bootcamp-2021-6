package pom.equipo5.test;

import org.junit.Test;
import pom.equipo5.base.TestBaseE5;
import pom.equipo5.pages.PageTraslados;
import pom.equipo5.pages.VFHomePageE5;

public class TC003_TrasladoMinivan extends TestBaseE5 {

    protected PageTraslados paginatraslados;
    protected VFHomePageE5 paginahome;

    @Test
    public void Test(){

        paginahome = new VFHomePageE5(driver);
        paginahome.abrirHome();
        paginatraslados = new PageTraslados(driver);
        paginatraslados.SeccionDeTraslados();
        paginatraslados.IngresaUnAeropuerto();
        paginatraslados.SeleccionarUnAeropuerto();
        paginatraslados.IngresoUnHotel();
        paginatraslados.SeleccionarUnHotel();
        paginatraslados.FechaDeArribo();
        paginatraslados.PasajerosAdultos3();
        paginatraslados.Buscar();
        paginatraslados.ValidarText3();
    }

}
