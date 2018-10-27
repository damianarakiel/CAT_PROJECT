package pl.stefanski;

import org.apache.catalina.startup.Tomcat;

public class App {
	public static void main(String[] args) throws Exception {
		Tomcat tomcat = EmbeddedTomcatFactory.create(8082);
		tomcat.start();
        tomcat.getServer().await();
	}
}
