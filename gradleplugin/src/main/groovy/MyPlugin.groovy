package com.sankuai.gradleplugin;

import org.gradle.api.Plugin
import org.gradle.api.Project

/*
* 在AndroidStudio中自定义Gradle插件
* https://www.jianshu.com/p/d53399cd507b
* */

public class MyPlugin implements Plugin<Project> {

    void apply(Project project) {
        System.out.println("========================");
        System.out.println("hello gradle plugin!");
        System.out.println("========================");
    }
}