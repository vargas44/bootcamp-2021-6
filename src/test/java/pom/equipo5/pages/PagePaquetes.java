package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo5.base.SeleniumBaseE5;

public class PagePaquetes extends SeleniumBaseE5 {
    public PagePaquetes(WebDriver driver) {
        super(driver);
    }


    //001_Paquete economico
    //atributos

    By CiudadOrigen = By.xpath("//div[@class=\"sbox-row -wrap -row-bottom\"]//input");
    By ClickCiudad = By.xpath("//div[@class=\"ac-container\"]//ul/li//span[1]");
    By BtnCajaDestino = By.xpath("//div[@class=\"sbox-second-place-container\"]//input");
    By CiudadDestino = By.xpath("//div[@class=\"ac-group-container\"]/ul/li[1]");
    By BtnFechaIda = By.xpath("//div[@class=\"sbox-dates-row sbox-row\"]//input");
    By BtnNextMes = By.xpath("//div[@class=\"datepicker-packages sbox-v4-components\"]//div[2]/i");
    By FechaIda = By.xpath("(//div[@data-month=\"2022-03\"])[3]//span[contains(span, '4')]");
    By FechaVuelta = By.xpath("(//div[@data-month=\"2022-03\"])[3]//span[contains(span, '11')]");
    By BtnAplicarFecha = By.xpath("(//div[@class=\"_dpmg2--desktopFooter-btn-container\"])[5]//button[2]");
    By CajaHabitaciones = By.xpath("//div[5]//div[@class=\"input-container\"]");
    By BtnAplicarHusped = By.xpath("(//div[@class=\"_pnlpk-panel__footer -medium-down-to-lg\"])[2]/a[1]");
    By RestarPersonas = By.xpath("//div/a[1][@class=\"steppers-icon-left sbox-3-icon-minus\"]\n");
    By BtnBuscar = By.xpath("//div[6]/div/a/em[@class=\"btn-text\"]");
    By OrdenarPor = By.xpath("(//aloha-select)[2]//div/select");
    By TextAlojamiento = By.xpath("//aloha-location-name//span[@class=\"-eva-3-tc-gray-2\"]");


    //funciones

    public void IngresoOrigen(){
        teclear(CiudadOrigen, "rio");
        clickear(ClickCiudad);
    }
    public void IngresaCiudadDestino()
    {
        teclear(BtnCajaDestino, "carm");
        clickear(CiudadDestino);
    }
    public void FechaIda1(){clickear(BtnFechaIda);}
    public void SiguienteMes(){clickear(BtnNextMes);}
    public void IngresarFechaIda(){clickear(FechaIda);}
    public void IngresarFechaVuelta(){clickear(FechaVuelta);}
    public void AplicarFecha(){clickear(BtnAplicarFecha);}
    public void CasillaHabitacion(){clickear(CajaHabitaciones);}
    public void QuitarHuspedes(){clickear(RestarPersonas);}
    public void AplicarHuspedes(){clickear(BtnAplicarHusped);}
    public void BuscarPage(){clickear(BtnBuscar);}
    public void Esperapagina(){waitExplicitlocated(OrdenarPor,15);}
    public void OrdenarPrecio(){clickear(OrdenarPor);}
    public void ValidarTexto(){
        validacionText(TextAlojamiento, "Playa del Carmen, El Pedregal. A 1,36 km del centro");
    }

    //002_PaquetesFiltroMesNoche

    //Atributos
    By BtnNoDecidido = By.xpath("//div[9]/span/label/span[@class=\"switch-container\"]");
    By BtnSelectMes = By.xpath("//div/div/select[@class=\"select-tag sbox-month-seletor\"]");
    By FiltroNoches = By.xpath("//div/span[@class=\"filter-tags-wrapper nights_count\"]");
    By Noches = By.xpath("//div[4]/div[1]//div[@class=\"filter-value eva-3-tag nights_count-filter\"][2]");
    By BtnAplicarNoches = By.xpath("//div[4]/div[2]/a[2]/em[@class=\"btn-text\"]");
    By TextNoches = By.xpath("//div[2]/span/span[@class=\"driver-text\"]");
    By TextFebrero = By.xpath("//div/p/em[@class=\"-eva-3-bold month -eva-3-capitalize\"]");

    //funciones
    public void IngresoOrigine2(){
        teclear(CiudadOrigen, "merino");
        clickear(ClickCiudad);
    }
    public void IngresaCiudadDestino2()
    {
        teclear(BtnCajaDestino, "ind");
        clickear(CiudadDestino);
    }
    public void CasillaHabitacion2(){
        clickear(CajaHabitaciones);
        for (int i = 0; i < 3; i++) {
        clickear(BtnAplicarHusped);
        }
    }
    public void SeleccionSinEleccion(){clickear(BtnNoDecidido);}
    public void SeleccionarMes(){
        listaEstatica(BtnSelectMes,"Marzo 2022");}
    public void ClickBuscar(){clickear(BtnBuscar);}
    public void FiltrarPorNoche(){clickear(FiltroNoches);}
    public void SeleccionNoches(){
        clickear(Noches);
        clickear(BtnAplicarNoches);}

    public void Esperapagina2(){waitExplicitlocated(TextNoches,4);}

    public void Validacion(){validacionText(TextNoches,"6 DÍAS / 5 NOCHES");}
    public void ValidacionSecundaria(){validacionText(TextFebrero,"Marzo");}

    //TC003_PaqueteRecomendado

    By TipoPaquete = By.xpath("//div[@class=\"sbox-bundles\"]/span[3]/input[@type=\"radio\"]");
    By SumarAdultos = By.xpath("//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]\n");
    By SumarMenores = By.xpath("//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[2]\n");
    By PrimerMenor = By.xpath("//div/div/select[@class=\"select-tag\"]");
    By SegundoMenor = By.xpath("//div[2]/div[2]/div/div/select[@class=\"select-tag\"]");
    By FiltroAerolinea = By.xpath("//filter-group[@data-sfa-id=\"airlines\"]/li/span[contains(div, 'Aerolíneas')]");
    By TipoAerolinea = By.xpath("//checkbox-filter[@class=\"airlines\"]//checkbox-filter-item//li/span[contains(span,'American Airlines')]");
    By FiltroEquipaje = By.xpath("//checkbox-filter[@class=\"baggage\"]//checkbox-filter-item[2]/li/span");
    By OrdenarPrecio = By.xpath("(//div[@class=\"select-container\"])/select[@id=\"eva-select\"]");
    By ObtenerPrecio = By.xpath("//div/highlight-level-three//span[contains(text(),\"Vuelo más conveniente\")]");

    By CiudadOrigen2 = By.xpath("//span[.='Punta Cana, La Altagracia, República Dominicana']");

    By Aplicar = By.xpath("//div[2]/a[@class=\"_pnlpk-apply-button sbox-3-btn -primary _pnlpk-panel__button--link-right -lg\"]");

    //Funciones
    public void TipoPaquetes(){clickear(TipoPaquete);}

    public void EsperaCiudad(){
        waitExplicitlocated(CiudadOrigen,2);
    }

    public void IngresoOrigen2(){
        teclear(CiudadOrigen, "pun");
        clickear(CiudadOrigen2);
    }
    public void IngresaDestino2()
    {
        teclear(BtnCajaDestino, "nue");
        clickear(CiudadDestino);
    }
    public void FechaIda2(){clickear(BtnFechaIda);}
    public void SiguienteMes2(){clickear(BtnNextMes);}
    public void IngresarFechaIda2(){clickear(FechaIda);}
    public void IngresarFechaVuelta2(){clickear(FechaVuelta);}
    public void AplicarFecha2(){clickear(BtnAplicarFecha);}
    public void CasillaHabitacioneAdulto(){
        clickear(CajaHabitaciones);
        for (int i = 2; i < 4; i++) {
            clickear(SumarAdultos);
        }
    }
    public void CasillaHabitacionMenores(){
        for (int j = 0; j < 2; j++) {
            clickear(SumarMenores);
        }
    }
    public void EdadMenores(){listaEstatica(PrimerMenor,"2 años");
        listaEstatica(SegundoMenor,"8 años");
    }
    public void BotonAplicar(){
        clickear(Aplicar);
    }
    public void ClickBuscar2(){clickear(BtnBuscar);}

    public void Esperapagina3(){waitExplicitlocated(TipoAerolinea,6);}


    public void FiltrarAerolinea(){
        clickear(FiltroAerolinea);
        clickear(TipoAerolinea);
    }
    public void FiltrarEquipaje(){clickear(FiltroEquipaje);}
    public void FiltroOrdenar(){listaEstatica(OrdenarPrecio,"Precio");}
    public void ObtenerText(){
        validacionText(ObtenerPrecio,"Vuelo más conveniente");
    }

}
