package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo5.base.SeleniumBaseE5;

public class PageTraslados extends SeleniumBaseE5 {

    private String text = "";

    public PageTraslados(WebDriver driver) {
        super(driver);
    }

    //Atributos TC001_TrasladoAuto

    By Traslados = By.xpath("//label[.='Traslados']");
    By EntraAeropuerto = By.xpath("//input[@placeholder='Ingresa un aeropuerto']");
    By ListaDinamica = By.xpath("//span[@class='item-text']");
    By HotelDestino= By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']");
    By SeleccionFecha = By.xpath("//input[@class='input-tag sbox-checkin']");
    By IngresoFecha = By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--onlyway _dpmg2--show-info _dpmg2--show']//div[@class='_dpmg2--month _dpmg2--o-6 _dpmg2--month-active']//span[@class='_dpmg2--date _dpmg2--available _dpmg2--weekend']/span[.='23']");
    By SeleccionPasajeros = By.xpath("//div[@class='sbox-3-input -md sbox-distri-input sbox-3-validation -top-right sbox-passengers-error-wrapper sbox-passengers-container']/div[@class='input-container']");
    By IconoSumaPasajeroAdulto = By.xpath("//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]");
    By BotonBuscar = By.xpath("//em[.='Buscar']");
    By Verificar = By.xpath("//span[.='Auto Estándar']");

    //Atributos TC002_TrasladoSinResultados
    By Verificar2 = By.xpath("//span[.='¡Ups! No hay traslados disponibles para esta fecha.']");

    //Atributos TC003_TrasladoMinivan
    By Verificar3 = By.xpath("//span[.='Minivan Estándar']");

    //funciones TC001_TrasladoAuto

    public void SeccionDeTraslados(){
        clickear(Traslados);
    }
    public void IngresaUnAeropuerto()
    {
        teclear(EntraAeropuerto, "el loa");
    }
    public void SeleccionarUnAeropuerto(){
        clickear(ListaDinamica);
    }
    public void IngresoUnHotel(){
    teclear(HotelDestino,"tarij");
    }
    public void SeleccionarUnHotel(){
        clickear(ListaDinamica);
    }
    public void FechaDeArribo(){
        clickear(SeleccionFecha);
        clickear(IngresoFecha);
    }
    public void PasajerosAdultos(){
        clickear(SeleccionPasajeros);
        clickear(IconoSumaPasajeroAdulto);
    }
    public void Buscar(){
        clickear(BotonBuscar);
    }
    public void ValidarText(){
        validacionText(Verificar, "Auto Estándar");
    }

    //funciones TC002_TrasladoSinResultados

    public void IngresoUnHotel2(){
        teclear(HotelDestino,"iqui");
    }
    public void ValidarText2(){
        validacionText(Verificar2, "¡Ups! No hay traslados disponibles para esta fecha.");
    }

    //funciones TC003_TrasladoMinivan
    public void PasajerosAdultos3(){
        clickear(SeleccionPasajeros);
        for (int i = 0; i < 12; i++) {
            clickear(IconoSumaPasajeroAdulto);
        }

    }
    public void ValidarText3(){
        validacionText(Verificar3, "Minivan Estándar");
    }

}
