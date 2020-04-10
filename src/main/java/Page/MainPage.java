package Page;

import Base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseClass {

    public MainPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@aria-label=\"Запрос\"]")
    private WebElement search;

    @FindBy(xpath = "//input[@name=\"within\" and @value=\"777\"]")
    private WebElement radioButton;

    @FindBy(xpath = "(//input[@placeholder=\"дд.мм.гггг\"])[1]")
    private WebElement firstDate;

    @FindBy(xpath = "(//input[@placeholder=\"дд.мм.гггг\"])[2]")
    private WebElement secondDate;

    @FindBy(xpath = "//button[@class=\"websearch-button suggest2-form__button\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class=\"filters__counters\"]")
    private WebElement messages;

    @FindBy(xpath = "//label[@class=\"checkbox__label\"]/span")
    private WebElement ckeckBoxLabel;

    public void setSearch(){
        search.clear();
        search.sendKeys("tern.ru");
    }

    public void clickOnRadioButton(){
        radioButton.click();
    }

    public void setDate(){
        firstDate.sendKeys("01.01.2020");
        secondDate.sendKeys("10.04.2020");
    }

    public int getMessages(){
        return Integer.parseInt(messages.getText());
    }

    public void clickOnSearchButton(){
        searchButton.click();
        //webDriverWait.until(ExpectedConditions.invisibilityOf(ckeckBoxLabel));
    }

    public int execute(){
        setSearch();
        clickOnRadioButton();
        setDate();
        clickOnSearchButton();
        return getMessages();
    }
}
