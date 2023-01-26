package Tests;


import ShareData.SharedData;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AlertTest extends SharedData {


    @Test
    public void MetodaTest(){


        WebElement SkipRegister = getDriver().findElement(By.id("btn2"));
        SkipRegister.click();

        WebElement SwitchTo = getDriver().findElement(By.xpath("//a[text()='SwitchTo']"));


        //Mergem cu mouseul pe un anumit element
        Actions actions = new Actions(getDriver());
        actions.moveToElement(SwitchTo).perform();

        WebElement AlertElement = getDriver().findElement(By.xpath("//a[text()='Alerts']"));
        AlertElement.click();

        //Navigam catre un URL
        getDriver().navigate().to("https://demo.automationtesting.in/Alerts.html");
        List<WebElement> AlertOptions = getDriver().findElements(By.cssSelector(".nav-stacked>li>a"));
        AlertOptions.get(0).click();
        WebElement AlertOk = getDriver().findElement(By.cssSelector("#OKTab>button"));
        AlertOk.click();

        //Interactionam cu o alerta
        Alert FirstAlert= getDriver().switchTo().alert();
        FirstAlert.accept();
        AlertOptions.get(1).click();
        WebElement AlertOkCancel = getDriver().findElement(By.cssSelector("#CancelTab>button"));
        AlertOkCancel.click();

        Alert SecondAlert = getDriver().switchTo().alert();
        SecondAlert.dismiss();

        AlertOptions.get(2).click();
        WebElement AlertText = getDriver().findElement(By.cssSelector("#Textbox>button"));
        AlertText.click();

        Alert ThirdAlert = getDriver().switchTo().alert();
        ThirdAlert.sendKeys("Bau");
        ThirdAlert.accept();



    }
}
