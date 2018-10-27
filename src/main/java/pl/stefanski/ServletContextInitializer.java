package pl.stefanski;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        CatServlet catServlet = new CatServlet(catRepository());
        context.addServlet("CatServlet", catServlet).addMapping("/cats");
    }

    private CatRepository catRepository() {
        return new InMemoryCatRepository();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
