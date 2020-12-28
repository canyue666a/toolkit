package org.cy.base.controller;

import org.cy.base.core.util.RuntimeCommandExecCallback;
import org.cy.base.core.util.RuntimeCommandExector;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.log.ReliableLog;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("/plugin")
public class PluginController {
    private final static Logger logger = LoggerFactory.getLogger(PluginController.class);

    @GetMapping("/{id}")
    public void exec(@PathVariable("id") String id) throws Exception {
        logger.info("id为{id}的插件准备运行", id);
        URL url = new File("plugins/SimplePlugin-1.0.0-boot.jar").toURI().toURL();
        logger.info(url.toString());
//        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
//        Class app = classLoader.loadClass("org.cy.simple.Application");
//        app.getMethod("run",String[].class)
//                .invoke(app.newInstance(),new Object[]{new String[]{}});
        RuntimeCommandExector exector = RuntimeCommandExector.getINSTANCE();
        InputStream is = exector.exec("java -jar " + url.getPath().substring(1), new RuntimeCommandExecCallback() {
            @Override
            public void onSuccess(InputStream info) throws Exception {
                BufferedReader reader = new BufferedReader(new InputStreamReader(info, "gbk"));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                logger.info("插件运行成功！");
            }

            @Override
            public void onFaild(InputStream error, int exitValue) throws IOException {
                logger.error("command exec failed!");
                BufferedReader reader = new BufferedReader(new InputStreamReader(error, "gbk"));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                logger.warn("插件运行失败！");
            }
        });

    }
}
