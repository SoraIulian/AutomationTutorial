package Tests;

import ShareData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FramesTest extends SharedData {
    @Test
    public void MetodaTest() {


        WebElement SkipSignIn = getDriver().findElement(By.id("btn2"));
        SkipSignIn.click();
        //Wait explicit cu conditii diferite
        WebDriverWait WaitExplicit = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement SwitchTo = getDriver().findElement(By.xpath("//a[text()='SwitchTo']"));
        WaitExplicit.until(ExpectedConditions.visibilityOf(SwitchTo));

        //Mergem cu mouseul pe un anumit element
        Actions actions = new Actions(getDriver());
        actions.moveToElement(SwitchTo).perform();

        WaitExplicit.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Frames']")));
        WebElement FrameElement = getDriver().findElement(By.xpath("//a[text()='Frames']"));
        FrameElement.click();
        getDriver().navigate().to("https://demo.automationtesting.in/Frames.html");

        List<WebElement> FrameOptions = getDriver().findElements(By.cssSelector(".nav-tabs>li>a"));
        FrameOptions.get(0).click();

        //Ne mutam pe un iframe
        getDriver().switchTo().frame("singleframe");
        WebElement FirstFrame = getDriver().findElement(By.cssSelector("input[type='text']"));
        FirstFrame.sendKeys("test");

        getDriver().switchTo().defaultContent();
        FrameOptions.get(1).click();

        getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[src='SingleFrame.html']")));
        WebElement SecondFrame = getDriver().findElement(By.cssSelector("input[type='text']"));
        SecondFrame.sendKeys("test2");

    }


}
