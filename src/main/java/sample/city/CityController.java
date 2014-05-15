package sample.city;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@Transactional
public class CityController {

    private final CityDao dao;

    @Inject
    public CityController(CityDao dao) {
        this.dao = dao;
    }

    @RequestMapping("/")
    @ResponseBody
    public List<City> selectAll() {
        return dao.selectAll();
    }

    @RequestMapping("/update")
    @ResponseBody
    public List<City> updateAndSelectAll(
            @RequestParam(value = "id", defaultValue = "1") int id,
            @RequestParam("name") String name) {
        City city = dao.selectById(id);
        city.name = name;
        dao.update(city);
        return dao.selectAll();
    }

}
