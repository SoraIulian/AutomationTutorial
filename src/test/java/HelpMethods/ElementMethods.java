package HelpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.text.Element;
import java.time.Duration;

public class ElementMethods {
    private WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }

    //facem metode generale pt interactiunile cu elemente
    public void ClickElement(WebElement signIn){
        WaitElementVisible(Element);
        Element.click();

    }
    public void WaitElementVisible(WebElement){
        WebDriverWait WaitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        WaitExplicit.until(ExpectedConditions.visibilityOf(Element));
    }

    public void FIllElement(WebElement Element, String Value){
        WaitElementVisible(Element);
        Element.sendKeys(Value);

    }
    public void ValidateElementText(WebElement Element, String Value){
        WaitElementVisible(Element);
        String Actual = Element.getText();
        Assert.assertEquals(Value, Actual);
    }
}
