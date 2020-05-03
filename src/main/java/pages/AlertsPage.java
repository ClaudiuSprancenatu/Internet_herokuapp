package pages;

import org.openqa.selenium.By;

public class AlertsPage {

    private BasePage browser;
    private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
    private By result = By.id("result");

    public AlertsPage(BasePage browser){
        this.browser = browser;
    }

    public AlertsPage open (){
        browser.visit("/javascript_alerts");
        return this;
    }

    public void triggerAlert(){
        browser.pressButton(triggerAlertButton);
        browser.alert_clickToAccept();
    }

    public void acceptTriggerConfirm(){
        browser.pressButton(triggerConfirmButton);
        browser.alert_clickToAccept();
    }

    public void dismissTriggerConfirm(){
        browser.pressButton(triggerConfirmButton);
        browser.alert_clickToDismiss();
    }

    public void acceptTriggerPromptButton(String text){
        browser.pressButton(triggerPromptButton);
        browser.alert_setInput(text);
        browser.alert_clickToAccept();
    }

    public void dismissTriggerPromptButton(String text){
        browser.pressButton(triggerPromptButton);
        browser.alert_setInput(text);
        browser.alert_clickToDismiss();
    }

    public String getResult(){
        return browser.getMessage(result);
    }

    public String getAlertText(){
        return browser.alert_getText();
    }
}
