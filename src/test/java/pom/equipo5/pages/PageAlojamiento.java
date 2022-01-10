package pom.equipo5.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo5.base.SeleniumBaseE5;

import java.util.List;

public class PageAlojamiento extends SeleniumBaseE5 {

    private String text = "el loa";

    public PageAlojamiento(WebDriver driver) {
        super(driver);
    }

    //Atributos t002_AlojamientoFiltroEstrella

    By Alojamiento = By.xpath("//label[.='Alojamientos']");
    By Busqueda = By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-primary undefined']");
    By Destino = By.xpath("//span[@class='item-text']");
    By Huespedes = By.xpath("//div[@class='sbox-3-input -md sbox-distri-input sbox-3-validation -top-right sbox-guests-container']/div[@class='input-container']");
    By inconoSumar = By.xpath("//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]");
    By sinfecha = By.xpath("//label[@class='checkbox-label']");
    By Buscar = By.xpath("//em[.='Buscar']");
    By Estrella = By.xpath("//eva-tooltip[4]//span[@class='eva-3-tag']");
    By SeleccionaEstrella = By.xpath("//span[contains(@class,\"-show-tooltip\")]//em[contains(text(),\"4\")and contains(@class,\"filter-name\")]");
    By Aplicar = By.xpath("//span[@class='eva-3-tooltip -white -bottom -right -not-hover -show-tooltip']//eva-button[.='Aplicar']");
    By Resultado = By.xpath("(//div[contains(@class,\"card-rating\")])[1]//i");


    //Atributos t003_AlojamamientoRangoPrecio


    By FiltroPrecio = By.xpath("//eva-tooltip[3]//span[@class='tag-text']");
    By SliderMenor = By.xpath("//div[@class='slider-handler -left']");
    By SliderMayor = By.xpath("//div[@class='slider-handler -right']");
    By AplicarPrecio = By.xpath("//eva-button[2]/a[.='Aplicar']");
    By Mensaje = By.xpath("//h3[@class='eva-3-h3 tag-text-heading']");


    //Atributos t002_AlojamientoReservados


    By Clickcheckin = By.xpath("//input[@class='input-tag sbox-checkin-date']");
    By IconoNext = By.xpath("//div[@class='_dpmg2--controls-next']/i[@class='_dpmg2--icon-ico-arrow']"); //siguiente mes
    By FechaIngreso = By.xpath("//div[@class='_dpmg2--months']/div[3]//span[@class='_dpmg2--date _dpmg2--available _dpmg2--weekend']/span[.='5']");
    By checkout = By.xpath("//input[@class='input-tag sbox-checkout-date']");
    By FechaSalida = By.xpath("//div[@class='_dpmg2--month _dpmg2--o-2 _dpmg2--has-start-range _dpmg2--month-active']//span[.='9']");
    By CantAdultos = By.xpath("//label[@class='sbox-input-label sbox-3-label-form sbox-label-dynamic-text']");
    By IconoSumar = By.xpath("//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]");
    By CanMenores = By.xpath("//div[@class='_pnlpk-itemBlock']//label[@class='_pnlpk-minors-title']");
    By IconoSumarMenores = By.xpath("//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[2]");
    By EdadMenor = By.xpath("//div[@class=\"select-container\"] /select");
    By EdadOtroMenor = By.xpath("//div[@class='_pnlpk-minors-age-select-wrapper']/div[@class='_pnlpk-itemRow _pnlpk-minor-age-select _pnlpk-minor-age-select-last-item']//select[@class='select-tag']");
    By AgregarHabitacion = By.xpath("//a[.='Añadir habitación']");
    By AgregarAdultos = By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//label[@class='_pnlpk-adults-title']");
    By IconoAgregar = By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]");
    By AgregarMenor = By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//label[@class='_pnlpk-minors-title']");
    By EdadMenAgregado = By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//div[@class='_pnlpk-itemRow _pnlpk-minor-age-select _pnlpk-minor-age-select-last-item']//select[@class='select-tag']");
    By Busca = By.xpath("//em[.='Buscar']");
    By CantMenor = By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[2]");
    By AplicarBusqueda = By.xpath("//div[@class='_pnlpk-panel__footer -medium-down-to-lg']/a[.='Aplicar']");
    By MensajeGuardado = By.xpath("//h5[@class='message-title eva-3-h5']");


    //funciones

    public void SeccionDeAlojamiento() {
        clickear(Alojamiento);
    }

    public void IngresaUnaBusqueda() {
        teclear(Busqueda, "Santi");
    }

    public void SeleccionarUnDestino() {
        clickear(Destino);
    }

    public void IngresoCantHuesped() {
        clickear(Huespedes);
        clickear(inconoSumar);
    }

    public void SeleccionarSinFecha() {
        clickear(sinfecha);
    }

    public void SeleccionarBuscar() {
        clickear(Buscar);
    }

    public void SeleccionarEstrella() {
        clickear(Estrella);
        clickear(SeleccionaEstrella);
    }

    public void BotonAplicar() {
        clickear(Aplicar);
    }

    public void ValidarNum() {
        validacionNum(Resultado);
    }

    //tc003 AlojamientoFiltroPrecio

    public void IngresaBusqueda() {
        teclear(Busqueda, "chill");
    }

    public void FiltroporPrecio() {
        clickear(FiltroPrecio);
        moverSlider(SliderMenor,SliderMayor);
      }

    public void SeleccionarAplicar() {
        clickear(AplicarPrecio);
    }

    public void GuardoMensaje() {
        clickear(Mensaje);

    }

    public void ValidarText() {
        validacionText(Mensaje, "No podemos encontrar lo que estás buscando");
    }


    public void IngresarBusqueda() {
        teclear(Busqueda, "coyh");

    }
     public void FechaEntrada(){
        clickear(Clickcheckin);
        clickear( IconoNext);
        clickear(FechaIngreso);
     }
     public void FechaSalida(){
        clickear(checkout);
        clickear(FechaSalida);
     }
     public void SeleccionarCantAdultos(){
         for (int i = 0; i < 2; i++) {
             clickear(CantAdultos);
             clickear(IconoSumar);
         }
     }
     public void SeleccionarCantMenores(){
         for (int i = 0; i < 2; i++) {
             clickear(CanMenores);
             clickear(IconoSumarMenores);
         }

        //clickear(EdadMenor);
        //clickear(EdadOtroMenor);
     }
     public void SeleccionarEdadMenor(){
        listaEstatica(EdadMenor,"1 año");
        //clickear(EdadMenor);
     }
     public void EdadOtroMenor(){
        listaEstatica(EdadOtroMenor,"4 años");
        //clickear(EdadOtroMenor);
     }
     public void AgrgarHabitacion(){
        clickear(AgregarHabitacion);
     }
     public void AgregarAdulto(){
        clickear(AgregarAdultos);
        clickear(IconoAgregar);
     }
     public void AgregarMenor(){
        clickear(AgregarMenor);
        clickear(CantMenor);
     }
     public void EdadMenorAgregado(){
        listaEstatica(EdadMenAgregado,"1 año");
        //clickear(EdadMenAgregado);
     }
     public void ClickAplicar(){
        clickear(AplicarBusqueda);
     }
     public void BotonBusqueda(){
        clickear(Busca);
     }
     public void MensajeGuardado(){
        clickear(MensajeGuardado);
     }
    public void Validartxt() {
        validacionText(MensajeGuardado, "Todos los alojamientos en Coyhaique están reservados.");
    }

}

