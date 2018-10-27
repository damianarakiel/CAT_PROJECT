package pl.stefanski;

import java.util.List;

public interface CatRepository {
    public void save(Cat cat);
    List<Cat> findAll();
    List<Cat> findByRace(String race);
    List<Cat> findByName(String name);
    List<Cat> findByOwner(String owner);
}
