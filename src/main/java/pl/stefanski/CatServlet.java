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
        String raceFilter = req.getParameter("search");
        String nameFilter = req.getParameter("search");
        String ownerFilter = req.getParameter("search");
        String operator = req.getParameter("operator");


        if (raceFilter != null && !raceFilter.isEmpty()) {
            switch (operator) {
                case "race":
                    cats = catRepository.findByRace(raceFilter);
                    break;
                case "name":
                    cats = catRepository.findByName(nameFilter);
                    break;
                case "owner":
                    cats = catRepository.findByOwner(ownerFilter);
                    break;
            }
        } else {
            cats = catRepository.findAll();
        }

//        if (raceFilter != null && !raceFilter.isEmpty()) {
//            cats = catRepository.findByRace(raceFilter);
//        } else if (nameFilter != null && !nameFilter.isEmpty()){
//            cats = catRepository.findByName(nameFilter);
//        } else if (ownerFilter != null && !ownerFilter.isEmpty()){
//            cats = catRepository.findByOwner(ownerFilter);
//        } else {
//            cats = catRepository.findAll();
//        }
            req.setAttribute(CatModelAtributs.ALL_CATS, cats);
            req.getRequestDispatcher("/form.jsp").

                    forward(req, resp);
        }
    }
