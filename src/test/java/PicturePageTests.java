import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PicturePageTests {

    FileInputStream fis;
    Properties property = new Properties();

    public String examplePictureUrl;
    public String examplePictureDirectory;
    public String pathToDriver;
    public String expectedTagText = "автокран";
    public WebDriver driver;

    @Before
    public void setup() {

        //Забираем из конфига url картинки, путь до картинки, путь до драйвера и ожидаемый текст тэга
        try {
            fis = new FileInputStream("src/test/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        examplePictureUrl = property.getProperty("examplePictureUrl");
        examplePictureDirectory = property.getProperty("examplePictureDirectory");
        pathToDriver = property.getProperty("pathToDriver");

        //Устанавливаем путь до драйвера
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        //Создаём и настроиваем драйвер
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void PictureLoadingByUrlTest() {
        //Создаём экземпляры нужных страниц
        PicturesPage pictures = new PicturesPage(driver);
        MainPage main = new MainPage(driver);

        //Открываем главную страницу
        main.OpenMainPage();

        //Переходим на страницу Картинки
        main.NavigateToPicturesPage();

        //Делаем поиск картинки по url
        pictures.SearchByPictureUrl(examplePictureUrl);

        //Проверяем что в первом тэге в результатах поиска есть слово "автокран"
        Assert.assertTrue(pictures.GetFirstTagText().contains(expectedTagText));
    }

    @Test
    public void PictureLoadingManuallyTest(){
        //Создаём экземпляры нужных страниц
        PicturesPage pictures = new PicturesPage(driver);
        MainPage main = new MainPage(driver);

        //Открываем главную страницу
        main.OpenMainPage();

        //Переходим на страницу Картинки
        main.NavigateToPicturesPage();

        //Делаем поиск картинки по url
        pictures.SearchByPictureFromDirectory(examplePictureDirectory);

        //Проверяем что в первом тэге в результатах поиска есть слово "автокран"
        Assert.assertTrue(pictures.GetFirstTagText().contains(expectedTagText));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}





