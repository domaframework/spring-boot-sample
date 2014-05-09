package sample.city;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class City {

    @Id
    public Integer id;

    public String name;

    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + "]";
    }

}
