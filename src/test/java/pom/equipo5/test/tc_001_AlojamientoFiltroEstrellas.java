package pom.equipo5.test;

import org.junit.Test;
import pom.equipo5.base.TestBaseE5;
import pom.equipo5.pages.PageAlojamiento;
import pom.equipo5.pages.PageTraslados;
import pom.equipo5.pages.VFHomePageE5;


public class tc_001_AlojamientoFiltroEstrellas extends TestBaseE5 {

    protected PageAlojamiento paginaAlojamiento;
    protected VFHomePageE5 paginahome;


    @Test
    public void Test() {
        //usar POM :: declarar las pages asoiciadas a la prueba
        paginaAlojamiento = new PageAlojamiento(driver);
        paginahome = new VFHomePageE5(driver);
        paginahome.abrirHome();
        paginaAlojamiento.SeccionDeAlojamiento();
        paginaAlojamiento.IngresaUnaBusqueda();
        paginaAlojamiento.SeleccionarUnDestino();
        paginaAlojamiento.IngresoCantHuesped();
        paginaAlojamiento.SeleccionarSinFecha();
        paginaAlojamiento.SeleccionarBuscar();
        paginaAlojamiento.SeleccionarEstrella();
        paginaAlojamiento.BotonAplicar();
        paginaAlojamiento.ValidarNum();

    }
}
