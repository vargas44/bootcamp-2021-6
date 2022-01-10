package desafio.equipo5;
import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Alojamiento {

    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        System.out.println("init para instanciar");
        driver = new ChromeDriver();
        driver.get("https://www.viajesfalabella.cl/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

    }


    @Test

    public void tc_001_AlojamientoFiltroEstrellas()  {
        WebDriverWait espera = new WebDriverWait(driver, 8000);


        By Alojamiento = By.xpath("//label[.='Alojamientos']");
        By Busqueda= By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-primary undefined']");
        By Destino = By.xpath("//span[@class='item-text']");
        By Huespedes = By.xpath("//div[@class='sbox-3-input -md sbox-distri-input sbox-3-validation -top-right sbox-guests-container']/div[@class='input-container']");
        By inconoSumar = By.xpath("//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]");
        By sinfecha= By.xpath("//label[@class='checkbox-label']");
        By Buscar = By.xpath("//em[.='Buscar']");
        By Estrella = By.xpath("//eva-tooltip[4]//span[@class='eva-3-tag']");
        By SeleccionaEstrella= By.xpath("//span[contains(@class,\"-show-tooltip\")]//em[contains(text(),\"4\")and contains(@class,\"filter-name\")]");
        By Aplicar = By.xpath("//span[@class='eva-3-tooltip -white -bottom -right -not-hover -show-tooltip']//eva-button[.='Aplicar']");
        By Resultado =By.xpath("(//div[contains(@class,\"card-rating\")])[1]//i");

        //click en boton de Alojamiento
        //espera.until(ExpectedConditions.visibilityOfElementLocated(Alojamiento)).click();
        driver.findElement(Alojamiento).click();

        // Hacer la búsqueda introduciendo la palabra "Santi"
        espera.until(ExpectedConditions.visibilityOfElementLocated(Busqueda)).sendKeys("santi");

        //selecciona el destino Santiago de chile
        espera.until(ExpectedConditions.visibilityOfElementLocated(Destino)).click();

        //Ingresar cantidad de 3 huespedes
        espera.until(ExpectedConditions.visibilityOfElementLocated(Huespedes)).click(); //click selecionar cantidad
        espera.until(ExpectedConditions.visibilityOfElementLocated(inconoSumar)).click();//click en +(incrementar huespedes)

        //Hacer click en "Todavía no he decidido la fecha"
        espera.until(ExpectedConditions.visibilityOfElementLocated(sinfecha)).click();

        //Hacer click en "Buscar"
        espera.until(ExpectedConditions.visibilityOfElementLocated(Buscar)).click();

        //hacer click en estrella
        espera.until(ExpectedConditions.visibilityOfElementLocated(Estrella)).click();

        // En el filtro se escoje 4 estrellas
        driver.findElement(SeleccionaEstrella).click();

        //Hacer click en el boton "aplicar"
        espera.until(ExpectedConditions.visibilityOfElementLocated(Aplicar)).click();

        //Verificar que los primero 3 alojamientos sean de 4 estrellas

        List<WebElement> result = driver.findElements(Resultado);
        Assert.assertEquals(4,result.size());

        /*

        //Cargar la página
        driver.get("https://www.viajesfalabella.cl/");

        //click en boton de Alojamiento
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[.='Alojamientos']"))).click();

        // Hacer la búsqueda introduciendo la palabra "Santi"
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-primary undefined']"))).sendKeys("santi");

        //selecciona el destino Santiago de chile
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='item-text']"))).click();

        //Ingresar cantidad de 3 huespedes
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sbox-3-input -md sbox-distri-input sbox-3-validation -top-right sbox-guests-container']/div[@class='input-container']"))).click(); //click selecionar cantidad
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]"))).click();//click en +(incrementar huespedes)

        //Hacer click en "Todavía no he decidido la fecha"
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='checkbox-label']"))).click();

        //Hacer click en "Buscar"
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[.='Buscar']"))).click();

        //hacer click en estrella
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//eva-tooltip[4]//span[@class='eva-3-tag']"))).click();

        // En el filtro se escoje 4 estrellas
        driver.findElement(By.xpath("//span[contains(@class,\"-show-tooltip\")]//em[contains(text(),\"4\")and contains(@class,\"filter-name\")]")).click();

        //Hacer click en el boton "aplicar"
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='eva-3-tooltip -white -bottom -right -not-hover -show-tooltip']//eva-button[.='Aplicar']"))).click();

        //Verificar que los primero 3 alojamientos sean de 4 estrellas

        List<WebElement> result = driver.findElements(By.xpath("(//div[contains(@class,\"card-rating\")])[1]//i"));
        //String results = result.get(0).findElement(By.xpath("//div[@class=\"offer-card-rating\"]//i")).getText();
        Assert.assertEquals(4,result.size());

         */



    }


    @Test
    public void tc_002_AlojamientoReservados()  {
        WebDriverWait espera = new WebDriverWait(driver, 8000);

        By Alojamiento = By.xpath("//label[.='Alojamientos']");
        By Busqueda = By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-primary undefined']");
        By Destino = By.xpath("//span[@class='item-text']");
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
        By AgregarHabitacion =By.xpath("//a[.='Añadir habitación']");
        By AgregarAdultos = By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//label[@class='_pnlpk-adults-title']");
        By IconoAgregar = By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]");
        By AgregarMenor= By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//label[@class='_pnlpk-minors-title']");
        By EdadMenAgregado =By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//div[@class='_pnlpk-itemRow _pnlpk-minor-age-select _pnlpk-minor-age-select-last-item']//select[@class='select-tag']");
        By Busca =By.xpath("//em[.='Buscar']");
        By CantMenor= By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[2]");
        By AplicarBusqueda = By.xpath("//div[@class='_pnlpk-panel__footer -medium-down-to-lg']/a[.='Aplicar']");
        By MensajeGuardado= By.xpath("//h5[@class='message-title eva-3-h5']");


        //click en boton de Alojamiento
        driver.findElement((Alojamiento)).click();

        // Hacer la búsqueda introduciendo la palabra "coyh"
        driver.findElement(Busqueda).sendKeys("coyh");

        //Selecciona la primera opcion "Coyhaique, Aysén, Chile"
        driver.findElement(Destino).click();

        //En fecha de entrada selecionar "Sab, 5 mar 2022"
        driver.findElement(Clickcheckin).click();
        driver.findElement(IconoNext).click();
        driver.findElement(FechaIngreso).click();

        // En fecha de salida selecionar "Mier, 9 mar 2022"
        driver.findElement(checkout ).click();
        driver.findElement(FechaSalida).click();

        //Seleccionar cantidad de 6 (Adultos)
        driver.findElement(CantAdultos ).click();
        for (int i=0 ; i<4 ;i++)
            //hacer click en icono + para agregar mas personas
            driver.findElement(IconoSumar).click();

        //Seleccionar cantidad de 2 (Menores)
        driver.findElement(CanMenores).click();
        driver.findElement(IconoSumarMenores).click();
        driver.findElement(EdadMenor).click();
        driver.findElement(EdadOtroMenor).click();

        //Seleccionar edad primer menor (3 Años)

        Select edad = new Select(driver.findElement(EdadMenor));
        edad.selectByVisibleText("3 años");

        // Seleccionar edad segundo menor (4 Años)
        Select ed = new Select(driver.findElement((EdadOtroMenor)));
        ed.selectByVisibleText("4 años");

        // Se añade otra habitacion
        driver.findElement(AgregarHabitacion).click();

        //Seleccionar cantidad de 4 (Adultos)
        driver.findElement(AgregarAdultos).click();
        for (int i=0 ; i<2 ;i++)
            //hacer click en icono + para agregar mas personas
            driver.findElement(IconoAgregar).click();

        //Seleccionar cantidad de 1 (Menor)
        driver.findElement(AgregarMenor).click();
        driver.findElement(CantMenor).click();

        //Seleccionar edad (1 Año)
        Select menor = new Select(driver.findElement(EdadMenAgregado));
        menor.selectByVisibleText("1 año");

        //Click en el boton "aplicar"
        driver.findElement(AplicarBusqueda).click();

        //Click en el boton "buscar"
        driver.findElement(Busca).click();

        //Guardamos el mensaje"Todos los alojamientos en Coyhaique están reservados"
        String mensaje_alerta = driver.findElement(MensajeGuardado).getText();

        //validamos el mensaje esperado
        Assert.assertEquals( "Todos los alojamientos en Coyhaique están reservados." ,mensaje_alerta);
  /*
        //Cargar la página
        driver.get("https://www.viajesfalabella.cl/");

        //click en boton de Alojamiento
        driver.findElement(By.xpath("//label[.='Alojamientos']")).click();

        // Hacer la búsqueda introduciendo la palabra "coyh"
        driver.findElement(By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-primary undefined']")).sendKeys("coyh");

        //Selecciona la primera opcion "Coyhaique, Aysén, Chile"
        driver.findElement(By.xpath("//span[@class='item-text']")).click();

        //En fecha de entrada selecionar "Sab, 5 mar 2022"
        driver.findElement(By.xpath("//input[@class='input-tag sbox-checkin-date']")).click();
        driver.findElement(By.xpath("//div[@class='_dpmg2--controls-next']/i[@class='_dpmg2--icon-ico-arrow']")).click();
        driver.findElement(By.xpath("//div[@class='_dpmg2--months']/div[3]//span[@class='_dpmg2--date _dpmg2--available _dpmg2--weekend']/span[.='5']")).click();

        // En fecha de salida selecionar "Mier, 9 mar 2022"
        driver.findElement(By.xpath("//input[@class='input-tag sbox-checkout-date']")).click();
        driver.findElement(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-2 _dpmg2--has-start-range _dpmg2--month-active']//span[.='9']")).click();

        //Seleccionar cantidad de 6 (Adultos)
        driver.findElement(By.xpath("//label[@class='sbox-input-label sbox-3-label-form sbox-label-dynamic-text']")).click();
        for (int i=0 ; i<4 ;i++)
            //hacer click en icono + para agregar mas personas
            driver.findElement(By.xpath("//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]")).click();

        //Seleccionar cantidad de 2 (Menores)
        driver.findElement(By.xpath("//div[@class='_pnlpk-itemBlock']//label[@class='_pnlpk-minors-title']")).click();
        driver.findElement(By.xpath("//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[2]")).click();
        driver.findElement(By.xpath("//div[@class='_pnlpk-itemBlock']//label[@class='_pnlpk-minors-title']")).click();
        driver.findElement(By.xpath("//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[2]")).click();

        //Seleccionar edad primer menor (3 Años)

        Select edad = new Select(driver.findElement(By.xpath("//div[@class=\"select-container\"] /select")));
        edad.selectByVisibleText("3 años");

        // Seleccionar edad segundo menor (4 Años)
        Select ed = new Select(driver.findElement(By.xpath("//div[@class='_pnlpk-minors-age-select-wrapper']/div[@class='_pnlpk-itemRow _pnlpk-minor-age-select _pnlpk-minor-age-select-last-item']//select[@class='select-tag']")));
        ed.selectByVisibleText("4 años");

        // Se añade otra habitacion
        driver.findElement(By.xpath("//a[.='Añadir habitación']")).click();

        //Seleccionar cantidad de 4 (Adultos)
        driver.findElement(By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//label[@class='_pnlpk-adults-title']")).click();
        for (int i=0 ; i<2 ;i++)
            //hacer click en icono + para agregar mas personas
            driver.findElement(By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]")).click();

        //Seleccionar cantidad de 1 (Menor)
        driver.findElement(By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//label[@class='_pnlpk-minors-title']")).click();
        driver.findElement(By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[2]")).click();

        //Seleccionar edad (1 Año)
        Select menor = new Select(driver.findElement(By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//div[@class='_pnlpk-itemRow _pnlpk-minor-age-select _pnlpk-minor-age-select-last-item']//select[@class='select-tag']")));
        menor.selectByVisibleText("1 año");

        //Click en el boton "aplicar"
        driver.findElement(By.xpath("//div[@class='_pnlpk-panel__footer -medium-down-to-lg']/a[.='Aplicar']")).click();

        //Click en el boton "buscar"
        driver.findElement(By.xpath("//em[.='Buscar']")).click();

        //Guardamos el mensaje"Todos los alojamientos en Coyhaique están reservados"
        String mensaje_alerta = driver.findElement(By.xpath("//h5[@class='message-title eva-3-h5']")).getText();

        //validamos el mensaje esperado
        Assert.assertEquals( "Todos los alojamientos en Coyhaique están reservados." ,mensaje_alerta);*/



    }

    @Test
    public void tc_003_alojamientoPrecioRango() {
        WebDriverWait espera = new WebDriverWait(driver, 8000);

        By Alojamiento = By.xpath("//label[.='Alojamientos']");
        By Busqueda = By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-primary undefined']");
        By Destino = By.xpath("//span[@class='item-text']");
        By sinfecha= By.xpath("//label[@class='checkbox-label']");
        By Buscar = By.xpath("//em[.='Buscar']");
        By FiltroPrecio = By.xpath("//eva-tooltip[3]//span[@class='tag-text']");
        By SliderMenor =By.xpath("//div[@class='slider-handler -left']");
        By SliderMayor =By.xpath("//div[@class='slider-handler -right']");
        By Aplicar = By.xpath("//eva-button[2]/a[.='Aplicar']");
        By Mensaje = By.xpath("//h3[@class='eva-3-h3 tag-text-heading']");




        //click en boton de Alojamiento
        driver.findElement(Alojamiento).click();

        // Hacer la búsqueda introduciendo la palabra "chill"
        driver.findElement(Busqueda).sendKeys("chill");

        //selecciona el destino
        driver.findElement(Destino).click();

        //Hacer click en "Todavía no he decidido la fecha"
        driver.findElement(sinfecha).click();

        //Hacer click en "Buscar"
        driver.findElement(Buscar).click();

        //hacer click en filtrar por precio
        driver.findElement(FiltroPrecio).click();

        //Mover deslizante para elegir el rango de precio
        WebElement menor = driver.findElement(SliderMenor);
        Actions moveSlider = new Actions(driver);
        Action action = moveSlider.dragAndDropBy(menor, 70, 0).build();
        action.perform();

        WebElement may = driver.findElement(SliderMayor);
        Actions moveSlide = new Actions(driver);
        Action actionn = moveSlider.dragAndDropBy(may, -120, 0).build();
        actionn.perform();
        //click en rango seleccionado
        driver.findElement(Aplicar).click();

        //Guardamos el mensaje"No podemos encontrar lo que estás buscando"
        String mensaje_alerta = driver.findElement(Mensaje).getText();

        //validamos el mensaje esperado
        Assert.assertEquals( "No podemos encontrar lo que estás buscando" ,mensaje_alerta);

        /* //Cargar la página
        driver.get("https://www.viajesfalabella.cl/");

        //click en boton de Alojamiento
        driver.findElement(By.xpath("//label[.='Alojamientos']")).click();

        // Hacer la búsqueda introduciendo la palabra "chill"
        driver.findElement(By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-primary undefined']")).sendKeys("chill");

        //selecciona el destino

        driver.findElement(By.xpath("//span[@class='item-text']")).click();

        //Hacer click en "Todavía no he decidido la fecha"
        driver.findElement(By.xpath("//label[@class='checkbox-label']")).click();

        //Hacer click en "Buscar"
        driver.findElement(By.xpath("//em[.='Buscar']")).click();

        //hacer click en filtrar por precio
        driver.findElement(By.xpath("//eva-tooltip[3]//span[@class='tag-text']")).click();

        //Mover deslizante para elegir el rango de precio
        WebElement menor = driver.findElement(By.xpath("//div[@class='slider-handler -left']"));
        Actions moveSlider = new Actions(driver);
        Action action = moveSlider.dragAndDropBy(menor, 70, 0).build();
        action.perform();

        WebElement may = driver.findElement(By.xpath("//div[@class='slider-handler -right']"));
        Actions moveSlide = new Actions(driver);
        Action actionn = moveSlider.dragAndDropBy(may, -120, 0).build();
        actionn.perform();
        //click en rango seleccionado
        driver.findElement(By.xpath("//eva-button[2]/a[.='Aplicar']")).click();

        //Guardamos el mensaje"No podemos encontrar lo que estás buscando"
        String mensaje_alerta = driver.findElement(By.xpath("//h3[@class='eva-3-h3 tag-text-heading']")).getText();

        //validamos el mensaje esperado
        Assert.assertEquals( "No podemos encontrar lo que estás buscando" ,mensaje_alerta);

         */


    }


    @After
    public void close() {
        if (driver != null) {
            System.out.println("Close");
            driver.close();
        }
    }
}