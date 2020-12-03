import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class PicturePageTests {

    public String examplePictureUrl = "https://bit.ly/3qom0pK";

    //Нужно указать путь до файла в локальной директории
    public String examplePictureDirectory = "C:\\\\driver\\unnamed.png";

    //Нужно указать путь до драйвера
    public String pathToDriver = "C:\\\\driver\\chromedriver.exe";
    public WebDriver driver;

    @Before
    public void setup() {
        //Путь до драйвера
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
        Assert.assertTrue(pictures.GetFirstTagText().contains("автокран"));
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
        Assert.assertTrue(pictures.GetFirstTagText().contains("автокран"));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}





