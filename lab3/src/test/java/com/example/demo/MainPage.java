package com.example.demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// page_url = https://www.jetbrains.com/

public class MainPage {
  private WebDriver google;
  private WebDriver firefox;
  public MainPage(){
    System.setProperty("webdriver.http.factory", "jdk-http-client");
  }

  public void finish(){
    google.quit();
    firefox.quit();
  }
  public void start_google(){
    google = new ChromeDriver();
    google.get("https://pikabu.ru/");
  }
  public void start_firefox(){
    firefox = new FirefoxDriver();
    firefox.get("https://pikabu.ru/");
  }
  public WebDriver getFirefox() {
    return firefox;
  }

  public WebDriver getGoogle() {
    return google;
  }
}
