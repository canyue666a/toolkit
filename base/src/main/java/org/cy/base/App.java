package org.cy.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    private Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
//    @Override
//    public void run(String... args) throws Exception {
//        URL url=new File("plugins/SimplePlugin-1.0.0.jar").toURI().toURL();
//        logger.info(url.toString());
////        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
////        Class app = classLoader.loadClass("org.cy.simple.Application");
////        app.getMethod("run",String[].class)
////                .invoke(app.newInstance(),new Object[]{new String[]{}});
//        RuntimeCommandExector exector = RuntimeCommandExector.getINSTANCE();
//        InputStream is = exector.exec("java -jar " + url.getPath().substring(1), new RuntimeCommandExecCallback() {
//            @Override
//            public void onSuccess(InputStream info) throws Exception {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(info,"gbk"));
//                String line=null;
//                while ((line=reader.readLine())!=null){
//                    System.out.println(line);
//                }
//            }
//
//            @Override
//            public void onFaild(InputStream error, int exitValue) throws IOException {
//                logger.error("command exec failed!");
//                BufferedReader reader = new BufferedReader(new InputStreamReader(error,"gbk"));
//                String line=null;
//                while ((line=reader.readLine())!=null){
//                    System.out.println(line);
//                }
//            }
//        });
//
//    }
