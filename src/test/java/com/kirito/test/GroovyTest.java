package com.kirito.test;

import cn.hutool.core.io.file.FileReader;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * groovy脚本测试
 * <p/>
 * <a href="https://mp.weixin.qq.com/s/-C2jbgrLJLYd0d4HlPuuew">Spring Boot 整合 Groovy 脚本，实现动态编程</a>
 *
 * @author kirito
 * @date 2023-11-11 14:00:47
 * @desc ...
 */
public class GroovyTest {

    @Test
    public void test1() {
        String scriptStr = new FileReader("classpath:groovy\\HelloWorld.groovy").readString();
        //创建groovy
        GroovyShell groovyShell = new GroovyShell();
        //装载解析脚本代码
        Script script = groovyShell.parse(scriptStr);
        //执行
        script.invokeMethod("HelloWorld", null);
    }

    @Test
    public void test2() {
        String scriptStr = new FileReader("classpath:groovy\\HelloWorld.groovy").readString();
        //创建groovy
        GroovyShell groovyShell = new GroovyShell();
        //装载解析脚本代码
        Script script = groovyShell.parse(scriptStr);
        int sum = (int) script.invokeMethod("add", new Object[]{1, 2});
        System.out.println("sum = " + sum);
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("科目1", "语文");
        paramMap.put("科目2", "数学");
        Object[] param2 = new Object[]{paramMap};
        String result = (String) script.invokeMethod("mapToString", param2);
        System.out.println("result = " + result);
    }

}
