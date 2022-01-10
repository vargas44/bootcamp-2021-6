package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo5.base.SeleniumBaseE5;

public class PagePaquetes extends SeleniumBaseE5 {


    public PagePaquetes(WebDriver driver) {
        super(driver);
    }

    By BtnCajaOrigen = By.xpath("//div[@class=\"sbox-row -wrap -row-bottom\"]//input");
    By CiudadOrigen = By.xpath("//div[@class=\"ac-container\"]//ul/li//span[1]");
    By BtnCajaDestino = By.xpath("//div[@class=\"sbox-second-place-container\"]//input");
    By CiudadDestino = By.xpath("//div[@class=\"ac-group-container\"]/ul/li[1]");
    By BtnFechaIda = By.xpath("//div[@class=\"sbox-dates-row sbox-row\"]//input");
    By BtnNextMes = By.xpath("//div[@class=\"datepicker-packages sbox-v4-components\"]//div[2]/i");
    By FechaIda = By.xpath("(//div[@data-month=\"2022-03\"])[3]//span[contains(span, '4')]");
    By FechaVuelta = By.xpath("(//div[@data-month=\"2022-03\"])[3]//span[contains(span, '11')]");
    By BtnAplicarFecha = By.xpath("(//div[@class=\"_dpmg2--desktopFooter-btn-container\"])[5]//button[2]");
    By CajaHabitaciones = By.xpath("//div[5]//div[@class=\"input-container\"]");
    By RestarPersonas = By.xpath("//div/a[1][@class=\"steppers-icon-left sbox-3-icon-minus\"]\n");
    By BtnAplicarHusped = By.xpath("(//div[@class=\"_pnlpk-panel__footer -medium-down-to-lg\"])[2]/a[1]");
    By BtnBuscar = By.xpath("//div[6]/div/a/em[@class=\"btn-text\"]");
    By OrdenarPor = By.xpath("(//aloha-select)[2]//div/select");
    By TextAlojamiento = By.xpath("//aloha-location-name//span[@class=\"-eva-3-tc-gray-2\"]");


    //funciones

    public void CasillaOrigen(){
        clickear(BtnCajaOrigen);
    }
    public void IngresaCiudadOrigen()
    {
        teclear(CiudadOrigen, "rio");
    }
    public void CasillaDestino(){clickear(BtnCajaDestino);}
    public void IngresaCiudadDestino()
    {
        teclear(CiudadDestino, "carm");
    }
    public void CasillaFechaIda(){clickear(BtnFechaIda);}
    public void SiguienteMes(){clickear(BtnNextMes);}
    public void IngresarFechaIda(){clickear(FechaIda);}
    public void IngresarFechaVuelta(){clickear(FechaVuelta);}
    public void AplicarFecha(){clickear(BtnAplicarFecha);}
    public void CasillaHabitacion(){clickear(CajaHabitaciones);}
    public void QuitarHuspedes(){clickear(RestarPersonas);}
    public void AplicarHuspedes(){clickear(BtnAplicarHusped);}
    public void BuscarPage(){clickear(BtnBuscar);}
    public void OrdenarPrecio(){clickear(OrdenarPor);}
    public void ValidarText(){
        validacionText(TextAlojamiento, "Playa del Carmen");
    }


    public void TC002_PaqueteFiltroMesNoche() {


        By BtnCajaOrigen = By.xpath("//div[@class=\"sbox-row -wrap -row-bottom\"]//input");
        By CiudadOrigen = By.xpath("//div[12]//div/ul/li[@class=\"item -active\"]");
        By BtnCajaDestino = By.xpath("//div[@class=\"sbox-second-place-container\"]//input");
        By CiudadDestino = By.xpath("//div[12]//div/ul/li[1][@class=\"item -active\"]");
        By CajaHabitaciones = By.xpath("//div[5]//div[@class=\"input-container\"]");
        By SumarPersonas = By.xpath("//div[2]/div[1]/div[2]//a[@class=\"steppers-icon-right sbox-3-icon-plus\"]\n");
        By BtnAplicarHusped = By.xpath("//div[2]//div[2]/a[@class=\"_pnlpk-apply-button sbox-3-btn -primary _pnlpk-panel__button--link-right -lg\"]");
        By BtnNoDecidido = By.xpath("//div[9]/span/label/span[@class=\"switch-container\"]");
        By BtnSelectMes = By.xpath("//div/div/select[@class=\"select-tag sbox-month-seletor\"]");
        By BtnBuscar = By.xpath("//div[6]/div/a/em[@class=\"btn-text\"]");
        By FiltroNoches = By.xpath("//div/span[@class=\"filter-tags-wrapper nights_count\"]");
        By Noches = By.xpath("//div[4]/div[1]//div[@class=\"filter-value eva-3-tag nights_count-filter\"][2]");
        By BtnAplicarNoches = By.xpath("//div[4]/div[2]/a[2]/em[@class=\"btn-text\"]");
        By TextNoches = By.xpath("//div[2]/span/span[@class=\"driver-text\"]");
        By TextFebrero = By.xpath("//div/p/em[@class=\"-eva-3-bold month -eva-3-capitalize\"]");


        //Funciones







    }

}
