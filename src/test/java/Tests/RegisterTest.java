package Tests;

import ShareData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterTest extends SharedData {

    @Test
    public void metodaTest(){


        WebElement SkipRegister = getDriver().findElement(By.id("btn2"));
        SkipRegister.click();

        WebElement FirstName = getDriver().findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstNameValue="Delia";
        FirstName.sendKeys(firstNameValue);

        WebElement LastName = getDriver().findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameValue="Anca";
        LastName.sendKeys(lastNameValue);

        WebElement Adress = getDriver().findElement(By.xpath("//textarea[@ng-model='Adress']"));
        String adressValue="Anca";
        Adress.sendKeys(adressValue);

        WebElement email = getDriver().findElement(By.xpath("//input[@ng-model='EmailAdress']"));
        String emailValue="mail@gmail.com";
        email.sendKeys(emailValue);

        WebElement Telefon = getDriver().findElement(By.cssSelector("input[type='tel']"));
        String TelefonValue="098765467";
        Telefon.sendKeys(TelefonValue);

        WebElement Gen = getDriver().findElement(By.cssSelector("input[value='Male']"));
        Gen.click();


        WebElement Hobby = getDriver().findElement(By.id("checkbox1"));
        Hobby.click();

        //Interactionam cu un dropdown clasic>select

        WebElement Skills = getDriver().findElement(By.id("Skills"));
        Select skillsDropDown = new Select(Skills);
        skillsDropDown.selectByVisibleText("Java");

        WebElement Year = getDriver().findElement(By.id("yearbox"));
        Select YearDropDown = new Select(Year);
        YearDropDown.selectByValue("1997");

        WebElement LanguageElement = getDriver().findElement(By.id("msdd"));
        LanguageElement.click();

        //Interactionam cu o multime de elemente (drop-down complex)

        List<WebElement> LanguageOptions = getDriver().findElements(By.cssSelector(".ui-autocomplete>li>a"));
        String ExpectedLanguage = "English";
        for (Integer index=0; index < LanguageOptions.size(); index++){
            if (LanguageOptions.get(index).getText().equals(ExpectedLanguage)){
                LanguageOptions.get(index).click();
            }
        }
        Hobby.click();

        WebElement SelectCountry = getDriver().findElement(By.cssSelector(".select2-selection"));
        SelectCountry.click();
        WebElement SelectCountryInput = getDriver().findElement(By.className("select2-search__field"));
        SelectCountryInput.sendKeys("Australia");
        SelectCountryInput.sendKeys(Keys.ENTER);
    }

}













