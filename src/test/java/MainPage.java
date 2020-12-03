import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class MainPage {

    //Драйвер
    WebDriver driver;

    //Путь до главной страницы
    String mainPageUrl = "https://yandex.ru/";

    //Локаторы
    By picturePageButtonXpath = By.xpath("//a[@data-id = 'images']");

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void OpenMainPage()
    {
        driver.get(this.mainPageUrl);
    }

    //Метод перехода на страницу Картинки
    public void NavigateToPicturesPage()
    {
        driver.findElement(picturePageButtonXpath).click();

        //Получаем список открытых табов
        ArrayList tabs = new ArrayList(driver.getWindowHandles());

        //Переходим на второй таб
        driver.switchTo().window(tabs.get(1).toString());
    }

}
