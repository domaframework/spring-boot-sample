package sample.city;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface CityDao {

    @Select
    City selectById(Integer id);

    @Select
    List<City> selectAll();

    @Update
    int update(City city);
}
