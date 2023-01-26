package Tests;

import ShareData.SharedData;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowTest  extends SharedData {



    @Test
    public void MetodaTest() {


        WebElement SkipRegister = getDriver().findElement(By.id("btn2"));
        SkipRegister.click();

        WebElement SwitchTo = getDriver().findElement(By.xpath("//a[text()='SwitchTo']"));


        //Mergem cu mouseul pe un anumit element
        Actions actions = new Actions(getDriver());
        actions.moveToElement(SwitchTo).perform();

        WebElement WindowElement = getDriver().findElement(By.xpath("//a[text()='Windows']"));
        WindowElement.click();
        getDriver().navigate().to("https://demo.automationtesting.in/Windows.html");

        List<WebElement>WindowOptions=getDriver().findElements(By.cssSelector(".nav-stacked>li>a"));
        WindowOptions.get(0).click();

        WebElement TabButton= getDriver().findElement(By.cssSelector("#Tabbed>a>button"));
        TabButton.click();


        //Identificam multimea de taburi/windowsuri
        List<String>Tabs=new ArrayList<>(getDriver().getWindowHandles());
        //Ne mutam cu focusul pe un tab specific
        getDriver().switchTo().window(Tabs.get(1));

        //Inchidem tabul curent
        getDriver().close();
        getDriver().switchTo().window(Tabs.get(0));

        WindowOptions.get(1).click();
        WebElement WindowButton = getDriver().findElement(By.cssSelector("#Seperate>button"));
        WindowButton.click();

        List<String>Windows=new ArrayList<>(getDriver().getWindowHandles());
        //Ne mutam cu focusul pe un window specific
        getDriver().switchTo().window(Windows.get(1));
        getDriver().close();
        getDriver().switchTo().window(Windows.get(0));

        WindowOptions.get(2).click();
        WebElement MultipleButton = getDriver().findElement(By.cssSelector("#Multiple>button"));
        MultipleButton.click();
        List<String>Multiple=new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(Multiple.get(2));
        getDriver().close();
        getDriver().switchTo().window(Multiple.get(1));
        getDriver().close();
        getDriver().switchTo().window(Multiple.get(0));


    }
}
