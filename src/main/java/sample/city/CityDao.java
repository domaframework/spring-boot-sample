package sample.city;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import sample.DataSourceAutowireable;

@Dao
@DataSourceAutowireable
public interface CityDao {

	@Select
	City selectById(Integer id);

	@Select
	List<City> selectAll();

	@Update
	int update(City city);
}
