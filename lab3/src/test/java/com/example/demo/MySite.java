package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MySite {
    public static void main(String[] args) {
        //for normal start
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver w =(WebDriver) new ChromeDriver();
        try{
            w.get("https://pikabu.ru/");
            System.out.println(w.getTitle());
        }finally {
            w.quit();
        }
    }
}
