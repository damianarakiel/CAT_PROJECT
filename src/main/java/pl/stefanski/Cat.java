package pl.stefanski;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Cat {
    String race;
    String name;
    String owner;

    public Cat(String race, String name, String owner) {
        this.race = race;
        this.name = name;
        this.owner = owner;
    }

    public Cat(){
    }
}
