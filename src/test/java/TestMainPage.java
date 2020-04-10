import Base.BaseClass;
import Page.MainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestMainPage extends BaseClass {
    private MainPage mainPage;

    @BeforeClass
    public void beforeClass(){
        initialDriver();
         mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test(description = "5 раз получить количество сообщений и сравнить их количество")
    public void test1(){

        int array[] = new int[5];

        for(int i = 0; i<5; i++){
            driver.get("https://news.yandex.ru/yandsearch?text=test&rpt=nnews2&grhow=clutop");
            array[i] = mainPage.execute();
        }

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(array[i] != array[j]){
                   Assert.assertTrue(false);
                }
            }
        }
    }
}