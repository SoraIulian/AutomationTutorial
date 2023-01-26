package Tests;

import HelpMethods.ElementMethods;
import ShareData.SharedData;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends SharedData {




    @Test
    public void metodaTest(){
        //Declaram un obiect si Refractorizam actiunile
        ElementMethods elementMethods = new ElementMethods(getDriver());


        //Declaram elementul Sign In
        WebElement SignIn = getDriver().findElement(By.id("btn1"));
        elementMethods.ClickElement(SignIn);
        SignIn.click();

        WebElement email = getDriver().findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue = "mail@gmail.com";
        email.sendKeys(emailValue);


        WebElement parola = getDriver().findElement(By.xpath("//input[@placeholder='Password']"));
        String parolaValue = "Parola";
        parola.sendKeys(parolaValue);

        WebElement Enter = getDriver().findElement(By.id("enterbtn"));
        Enter.click();

        //Validam un measaj de erpare
        WebElement error = getDriver().findElement(By.id("errormsg"));
        String expectedError = "Invalid User Name or PassWord";
        String actualError = error.getText();

        Assert.assertEquals(actualError, expectedError, "Eroarea login incorecta");

    }
}
