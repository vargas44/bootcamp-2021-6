package desafio.equipo5;

//Librerias importadas
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Paquetes {

    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        System.out.println("instanciar");
        driver = new ChromeDriver();
        driver.get("https://www.viajesfalabella.cl/");
        driver.manage().window().maximize();
    }

    @Test
    public void TC001_PaqueteEconomico() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);

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
        By RestarPersonas = By.xpath("//div/a[1][@class=\"steppers-icon-left sbox-3-icon-minus\"]\n");
        By BtnAplicarHusped = By.xpath("(//div[@class=\"_pnlpk-panel__footer -medium-down-to-lg\"])[2]/a[1]");
        By BtnBuscar = By.xpath("//div[6]/div/a/em[@class=\"btn-text\"]");
        By OrdenarPor = By.xpath("(//aloha-select)[2]//div/select");
        By TextAlojamiento = By.xpath("//aloha-location-name//span[@class=\"-eva-3-tc-gray-2\"]");

        //Origen
        wait.until(ExpectedConditions.visibilityOfElementLocated(CiudadOrigen)).sendKeys("rio");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClickCiudad)).click();

        //Destino
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnCajaDestino)).sendKeys("carm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CiudadDestino)).click();

        //Fecha ida
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnFechaIda)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnNextMes)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(FechaIda)).click();
        //Fecha vuelta
        wait.until(ExpectedConditions.visibilityOfElementLocated(FechaVuelta)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnAplicarFecha)).click();

        //Seleccionar casilla de habitaciones y huspedes
        wait.until(ExpectedConditions.visibilityOfElementLocated(CajaHabitaciones)).click();
        //Boton menos husped
        for (int i = 0; i < 1; i++) {
            //Selecion de adulto 1
            wait.until(ExpectedConditions.visibilityOfElementLocated(RestarPersonas)).click();
        }
        //Click aplicar
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnAplicarHusped)).click();
        //Boton buscar
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnBuscar)).click();

        //Ordenar por Precio: menor a mayor. "Importando la clase Select"
        Thread.sleep(3000);
        WebElement ordenar = wait.until(ExpectedConditions.visibilityOfElementLocated(OrdenarPor));
        Select select = new Select(ordenar);
        select.selectByVisibleText("Precio: menor a mayor");
        Thread.sleep(3000);
        //Obtener texto de alojamiento
        String location = wait.until(ExpectedConditions.visibilityOfElementLocated(TextAlojamiento)).getText();
        String[] arr = location.split(" ");
        String nameLocation = arr[0] + " " + arr[1] + " " + arr[2].replace(",", "");

        //Verificar mas economico"
        Assert.assertEquals("Playa del Carmen", nameLocation);

    }

    @Test
    public void TC002_PaqueteFiltroMesNoche() {

        WebDriverWait wait = new WebDriverWait(driver, 20);

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

        //Origen
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnCajaOrigen)).sendKeys("merino");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CiudadOrigen)).click();

        //Destino
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnCajaDestino)).sendKeys("ind");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CiudadDestino)).click();

        //Seleccionar casilla de habitaciones y huspedes
        wait.until(ExpectedConditions.visibilityOfElementLocated(CajaHabitaciones)).click();
        //Agregar husped
        for (int i = 2; i < 3; i++) {
            //Selecion de adultos 4
            wait.until(ExpectedConditions.visibilityOfElementLocated(SumarPersonas)).click();
        }
        //Click aplicar
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnAplicarHusped)).click();
        //Selecciona Switch "Todavia no he decidido la fecha"
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnNoDecidido)).click();
        //Selecionar mes
        WebElement mes = wait.until(ExpectedConditions.visibilityOfElementLocated(BtnSelectMes));
        Select select = new Select(mes);
        select.selectByVisibleText("Marzo 2022");

        //Boton buscar
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnBuscar)).click();
        //Filtrar por noches
        wait.until(ExpectedConditions.visibilityOfElementLocated(FiltroNoches)).click();
        //5 a 7 noches
        wait.until(ExpectedConditions.visibilityOfElementLocated(Noches)).click();

        //Aplicar
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnAplicarNoches)).click();
        //Obtener texto "6 DÍAS / 5 NOCHES"
        String night = wait.until(ExpectedConditions.visibilityOfElementLocated(TextNoches)).getText();
        //Obtener texto "Febrero"
        String month = wait.until(ExpectedConditions.visibilityOfElementLocated(TextFebrero)).getText();
        //Validar noches y mes
        Assert.assertEquals("6 DÍAS / 5 NOCHES", night);
        Assert.assertEquals("Marzo", month);


    }

    @Test
    public void TC003_PaqueteRecomendado() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        By TipoPaquete = By.xpath("//div[@class=\"sbox-bundles\"]/span[3]/input[@type=\"radio\"]");
        By BtnCajaOrigen = By.xpath("//div[@class=\"sbox-row -wrap -row-bottom\"]//input");
        By CiudadOrigen = By.xpath("//div[12]//div/ul/li[@class=\"item -active\"]");
        By BtnCajaDestino = By.xpath("//div[@class=\"sbox-second-place-container\"]//input");
        By CiudadDestino = By.xpath("//div[12]//div/ul/li[1][@class=\"item -active\"]");
        By CajaFechaIda = By.xpath("//div[@class=\"sbox-dates-row sbox-row\"]//input");
        By NextMes = By.xpath("//div[@data-range=\"start\"]//div[@class=\"_dpmg2--controls-next\"]/i");
        By FechaIda = By.xpath("//div[5]//div[5]/div[2]//span[8]/span[@class=\"_dpmg2--date-number\"]");
        By FechaVuelta = By.xpath("( //div[@data-month=\"2022-02\"])[3]//span[contains(span,'15')]");
        By BtnAplicar  = By.xpath("//div[7]//div[6]/div[2]/button[2][@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"]");
        By CajaHabitaciones = By.xpath("//div[5]//div[@class=\"input-container\"]");
        By SumarAdultos = By.xpath("//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]\n");
        By SumarMenores = By.xpath("//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[2]\n");
        By PrimerMenor = By.xpath("//div/div/select[@class=\"select-tag\"]");
        By SegundoMenor = By.xpath("//div[2]/div[2]/div/div/select[@class=\"select-tag\"]");
        By Aplicar = By.xpath("//div[2]/a[@class=\"_pnlpk-apply-button sbox-3-btn -primary _pnlpk-panel__button--link-right -lg\"]");
        By Buscar = By.xpath("//div[6]/div/a/em[@class=\"btn-text\"]");
        By FiltroAerolinea = By.xpath("//filter-group[@data-sfa-id=\"airlines\"]/li/span[contains(div, 'Aerolíneas')]");
        By TipoAerolinea = By.xpath("//checkbox-filter[@class=\"airlines\"]//checkbox-filter-item//li/span[contains(span,'American Airlines')]");
        By FiltroEquipaje = By.xpath("//checkbox-filter[@class=\"baggage\"]//checkbox-filter-item[2]/li/span");
        By OrdenarPrecio = By.xpath("(//div[@class=\"select-container\"])/select[@id=\"eva-select\"]");
        By ObtenerPrecio = By.xpath("//div/highlight-level-three//span[contains(text(),\"Vuelo más conveniente\")]");

        //Tipo de paquete Vuelo + Auto
        driver.findElement(TipoPaquete).click();
        //Origen
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnCajaOrigen)).sendKeys("pun");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CiudadOrigen)).click();
        //Destino
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnCajaDestino)).sendKeys("nue");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CiudadDestino)).click();
        //Fecha ida
        wait.until(ExpectedConditions.visibilityOfElementLocated(CajaFechaIda)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(NextMes)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(FechaIda)).click();
        //Fecha vuelta
        wait.until(ExpectedConditions.visibilityOfElementLocated(FechaVuelta)).click();
        //Aplicar
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnAplicar)).click();

        //Seleccionar casilla de habitaciones y huspedes
        wait.until(ExpectedConditions.visibilityOfElementLocated(CajaHabitaciones)).click();

        for (int i = 2; i < 4; i++) {
            //Selecion de adultos 4
            driver.findElement(SumarAdultos).click();
        }

        for (int j = 0; j < 2; j++) {
            //Selecion de menores 2
            driver.findElement(SumarMenores).click();
        }

        //Edad primer menor
        WebElement menor1 = driver.findElement(PrimerMenor);
        Select select = new Select(menor1);
        select.selectByVisibleText("2 años");

        //Edad segundo menor
        WebElement menor2 = driver.findElement(SegundoMenor);
        Select elegir = new Select(menor2);
        elegir.selectByVisibleText("8 años");

        //Click aplicar
        wait.until(ExpectedConditions.visibilityOfElementLocated(Aplicar)).click();
        //Boton buscar
        wait.until(ExpectedConditions.visibilityOfElementLocated(Buscar)).click();

        //Filtrar por Aerolineas
        wait.until(ExpectedConditions.visibilityOfElementLocated(FiltroAerolinea)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TipoAerolinea)).click();
        Thread.sleep(3000);
        //Filtrar por equipaje
        driver.findElement(FiltroEquipaje).click();

        //Seleccionar la opcion de ordenar por precio
        WebElement ordenar = driver.findElement(OrdenarPrecio);
        Select orden = new Select(ordenar);
        orden.selectByVisibleText("Precio");
        Thread.sleep(3000);
        //Obtener Texto "Vuelo mas conveniente"
        String Recomendado = driver.findElement(ObtenerPrecio).getText();
        //Validar vuelo mas coveniente
        Assert.assertEquals("Vuelo más conveniente", Recomendado);

    }

    @After
    public void close() {
        if (driver != null) {
            System.out.println("Close");
            driver.close();
        }

    }
}
