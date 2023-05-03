package com.example.demo;

import org.openqa.selenium.By;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class MainPageTest {
    static MainPage mainPage = new MainPage();

    @AfterAll
    public static void finish(){
        mainPage.finish();
    }

    @Test
    public void t(){
        mainPage.start_google();
        mainPage.getGoogle().findElement(By.xpath("/html/body/div[1]/header/div[2]/div/div/div[2]/div/div[2]/a")).click();
        assertEquals(mainPage.getGoogle().getCurrentUrl(),"https://pikabu.ru/best");
    }
}
