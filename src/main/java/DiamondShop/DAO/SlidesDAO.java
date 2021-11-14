package DiamondShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.MapperSlides;
import DiamondShop.Entity.Slides;

@Repository
public class SlidesDAO extends BaseDAO  {
	
	public List<Slides> getDataSlide() {
		List<Slides> list = new ArrayList<Slides>();
		String query = "Select * from slides";
		list = _jdbcTemplate.query(query, new MapperSlides());
		return list;
	}
}
