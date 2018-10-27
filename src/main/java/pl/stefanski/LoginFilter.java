package pl.stefanski;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/")
public class LoginFilter implements Filter {

        @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        Object loggedAttr = httpRequest.getSession().getAttribute("logged");
        if (Boolean.TRUE.equals(loggedAttr)) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("/login");
        }

        Boolean logged = Optional.ofNullable(httpRequest.getSession().getAttribute("logged")).map(Boolean.class::cast).orElse(false);

        if (logged) {
            chain.doFilter(request, response);
        } else {
//            HttpServletResponse httpResponse = (HttpServletResponse) response;
//            httpResponse.sendRedirect("../login.jsp");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.include(request, response);
        }
    }
}
