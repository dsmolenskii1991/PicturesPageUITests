import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PicturesPage {
    //Драйвер
    WebDriver driver;

    //Локаторы на странице
    By searchByPictureXpath = By.xpath("//div[contains(@class, 'cbir-button')]");
    By searchFileTextFieldXpath = By.name("cbir-url");
    By searchFileButtonXpath = By.name("cbir-submit");
    By firstTagInRecognizedPicturesListXpath = By.xpath("//div[contains(@class, 'CbirTags')]//a[1]");
    By inputFileDialogXpath = By.xpath("//input[@name = 'upfile']");

    public PicturesPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //Метод поиска картинки по url
    public void SearchByPictureUrl(String pictureUrl)
    {
        driver.findElement(searchByPictureXpath).click();
        driver.findElement(searchFileTextFieldXpath).sendKeys(pictureUrl);
        driver.findElement(searchFileButtonXpath).click();

    }

    //Получение текста первого тэга
    public String GetFirstTagText(){
        return driver.findElement(firstTagInRecognizedPicturesListXpath).getText();
    }

    //Метод поиска картинки через загрузку файла
    public void SearchByPictureFromDirectory(String pathToPicture){
        driver.findElement(searchByPictureXpath).click();
        driver.findElement(inputFileDialogXpath).sendKeys(pathToPicture);
    }

}
