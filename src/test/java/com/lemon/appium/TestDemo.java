package com.lemon.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TestDemo {
	/**
	 * 1锛氱偣鍑绘敞鍐屾寜閽紝杩涘叆娉ㄥ唽椤甸潰 
	 * 2锛氫笉鍋氫换浣曟搷浣� 
	 * 3锛氭湡鏈涳細娉ㄥ唽鎸夐挳涓嶅彲鐐瑰嚮
	 * 
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// 1锛氭坊鍔犻厤缃�
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// 鎴戣娴嬭瘯鐨勮澶�
		capabilities.setCapability("deviceName", "127.0.0.1:26944");// map:閿�煎
		// 娴嬭瘯閭ｄ釜app锛氬寘鍚�
		capabilities.setCapability("appPackage", "com.tencent.mm");
		// app鐨勫摢涓〉闈�
		capabilities.setCapability("appActivity", "com.tencent.mm.ui.LauncherUI");
		// 瀹㈡埛绔笉鑳藉拰Android鏈哄櫒鐩存帴閫氫俊,闇�瑕佽闂竴涓湴鍧�
		URL remoteAddress = new URL("http://127.0.0.1:4723/wd/hub");

		// 2锛氬垱寤洪┍鍔�:
		AppiumDriver<WebElement> driver = new AndroidDriver<WebElement>(remoteAddress, capabilities);

		// 纭�х瓑寰� 5s
		Thread.sleep(5000);

		// 3锛氭壘鍒伴〉闈㈠厓绱狅紝瀹氫綅椤甸潰鍏冪礌
		 WebElement registerBtn = driver.findElement(By.id("czx"));
		// WebElement registerBtn = driver.findElement(By.name("娉ㄥ唽"));
//		WebElement registerBtn = (WebElement) driver.findElements(By.className("android.widget.Button")).get(1);
		// 璁╂敞鍐屾寜閽幓杩涜鐐瑰嚮鎿嶄綔
		registerBtn.click();

		// 杈撳叆妗�
		List<WebElement> inputs = driver.findElements(By.id("hk"));
		System.out.println(inputs.size());
		inputs.get(0).sendKeys("happy");// 濉厖鍐呭
		inputs.get(1).sendKeys("13888888888");// 濉厖鍐呭
		inputs.get(2).sendKeys("");// 濉厖鍐呭

		// 4锛氭搷浣滈〉闈㈠厓绱犳潵妯℃嫙鐢ㄦ埛鐨勬搷浣�
		WebElement btn2 = driver.findElement(By.id("ctg"));

		// 5锛氶�氳繃鏂█鍜屾棩蹇楁潵鏌ョ湅娴嬭瘯缁撴灉
		boolean flag = btn2.isEnabled(); // 濡傛灉鎸夐挳涓嶈兘鐐瑰嚮锛岃繑鍥瀎alse
//		Assert.assertFalse(flag);
		System.out.println(flag);

		driver.quit();//鍏抽棴app
	}

}

