package pl.stefanski;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static pl.stefanski.CatParams.*;

//@WebServlet("/cats") - adnotacja nie potrzebna bo mapowanie jest zrobione w klasie ServletContextInitializer
public class CatServlet extends HttpServlet {

    private CatRepository catRepository;

    public CatServlet(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        catRepository.save(new Cat(req.getParameter(RACE), req.getParameter(NAME), req.getParameter(OWNER)));
        resp.sendRedirect("/cats");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Cat> cats = null;
        String searchFilter = req.getParameter("search");
        String operator = req.getParameter("operator");


        if (searchFilter != null && !searchFilter.isEmpty()) {
            switch (operator) {
                case "race":
                    cats = catRepository.findByRace(searchFilter);
                    break;
                case "name":
                    cats = catRepository.findByName(searchFilter);
                    break;
                case "owner":
                    cats = catRepository.findByOwner(searchFilter);
                    break;
            }
        } else {
            cats = catRepository.findAll();
        }

            req.setAttribute(CatModelAtributs.ALL_CATS, cats);
            req.getRequestDispatcher("/form.jsp").

                    forward(req, resp);
        }
    }
