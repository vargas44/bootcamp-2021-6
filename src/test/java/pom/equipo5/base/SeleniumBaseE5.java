package pom.equipo5.base;

import org.apache.commons.compress.changes.ChangeSetPerformer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumBaseE5 {

        //Atributos
        WebDriver driver;


    public SeleniumBaseE5(WebDriver driver) {
            this.driver = driver;
        }

        //Metodos Wrapper - Envoltorios

        //retorno ->  en su declaracion debe indicar que Objeto retorna
        public WebElement encontrarElementoWeb(By localizador){
            return driver.findElement(localizador);

        }

        public List<WebElement> encontrarElementosWeb(By localizador){
            return driver.findElements(localizador);
        }

        //accion -> void
        public void obtenerUrl(String URL){
            driver.get(URL);
        }
        //accion -> void

         public void waitExplicitClick(By locator, int time){
        WebDriverWait espera;
        espera = new WebDriverWait(driver,time);
        espera.until(ExpectedConditions.elementToBeClickable(locator));
    }

        public void clickear(By localizador){
            encontrarElementoWeb(localizador).click();
        }


        public void select(By localizador){

            Select lista = new Select(driver.findElement(localizador));

        }

        public void teclear(By localizador, String text){
            driver.findElement(localizador).sendKeys(text);
        }

        public void listaEstatica (By localizador, String text){
            Select menor = new Select(driver.findElement(localizador));
            menor.selectByVisibleText(text);
        }

        public void moverSlider(By localizadorMenor,By localizadorMayor){
            WebElement menor = driver.findElement(localizadorMenor);
            Actions moveSlider = new Actions(driver);
            Action action = moveSlider.dragAndDropBy(menor, 70, 0).build();
            action.perform();

            WebElement may = driver.findElement(localizadorMayor);
            Actions moveSlide = new Actions(driver);
            Action actionn = moveSlide.dragAndDropBy(may, -120, 0).build();
            actionn.perform();
    }


        //Validaciones
        public void validacionText(By localizador, String text){
            Assert.assertEquals(text, driver.findElement(localizador).getText());
        }
        public void validacionNum(By localizador){
            List<WebElement> result = driver.findElements(localizador);
            Assert.assertEquals(4,result.size());
        }




    }

