package pl.stefanski;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryCatRepository implements CatRepository {

    private List<Cat> catList;

    public InMemoryCatRepository() {
        this.catList = new ArrayList();
    }

    @Override
    public void save(Cat cat) {
        catList.add(cat);
    }

    @Override
    public List<Cat> findAll() {
        return catList;
    }

    @Override
    public List<Cat> findByRace(String race) {
        return findAll().stream().filter(cat -> cat.getRace().equals(race)).collect(Collectors.toList());
    }

    @Override
    public List<Cat> findByName(String name) {
        return findAll().stream().filter(cat -> cat.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<Cat> findByOwner(String owner) {
        return findAll().stream().filter(cat -> cat.getOwner().equals(owner)).collect(Collectors.toList());
    }
}
