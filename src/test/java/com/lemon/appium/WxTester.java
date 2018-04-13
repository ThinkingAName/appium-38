package com.lemon.appium;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class WxTester {
	/**
	 * 1：点击注册按钮，进入注册页面 
	 * 2：不做任何操作 
	 * 3：期望：注册按钮不可点击
	 * 
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// 1：添加配置
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// 我要测试的设备
		capabilities.setCapability("deviceName", "127.0.0.1:26944");// map:键值对
		// 测试那个app：包名
		capabilities.setCapability("appPackage", "com.tencent.mm");
		// app的哪个页面
		capabilities.setCapability("appActivity", "com.tencent.mm.ui.LauncherUI");
		// 客户端不能和Android机器直接通信,需要访问一个地址
		URL remoteAddress = new URL("http://127.0.0.1:4723/wd/hub");

		// 2：创建驱动:
		AppiumDriver<WebElement> driver = new AndroidDriver<WebElement>(remoteAddress, capabilities);

		// 硬性等待 5s
		Thread.sleep(5000);

		// 3：找到页面元素，定位页面元素
		 WebElement registerBtn = driver.findElement(By.id("czx"));
		// WebElement registerBtn = driver.findElement(By.name("注册"));
//		WebElement registerBtn = (WebElement) driver.findElements(By.className("android.widget.Button")).get(1);
		// 让注册按钮去进行点击操作
		registerBtn.click();

		// 输入框
		List<WebElement> inputs = driver.findElements(By.id("hk"));
		System.out.println(inputs.size());
		inputs.get(0).sendKeys("happy");// 填充内容
		inputs.get(1).sendKeys("13888888888");// 填充内容
		inputs.get(2).sendKeys("");// 填充内容

		// 4：操作页面元素来模拟用户的操作
		WebElement btn2 = driver.findElement(By.id("ctg"));

		// 5：通过断言和日志来查看测试结果
		boolean flag = btn2.isEnabled(); // 如果按钮不能点击，返回false
//		Assert.assertFalse(flag);
		System.out.println(flag);

		driver.quit();//关闭app
	}

}
