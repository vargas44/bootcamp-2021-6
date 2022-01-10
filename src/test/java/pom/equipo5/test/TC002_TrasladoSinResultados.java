package pom.equipo5.test;

import org.junit.Test;
import pom.equipo5.base.TestBaseE5;
import pom.equipo5.pages.PageTraslados;
import pom.equipo5.pages.VFHomePageE5;

public class TC002_TrasladoSinResultados extends TestBaseE5 {

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
        paginatraslados.IngresoUnHotel2();
        paginatraslados.SeleccionarUnHotel();
        paginatraslados.FechaDeArribo();
        paginatraslados.PasajerosAdultos();
        paginatraslados.Buscar();
        paginatraslados.ValidarText2();


    }

}
