package DiamondShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Dto.MapperProductsDto;
import DiamondShop.Dto.ProductsDto;

@Repository
public class ProductsDAO extends BaseDAO {
	public static final String FEATURED_PRODUCT = "FEATURED_PRODUCT";
	public static final String NEW_PRODUCT = "NEW_PRODUCT";

	private StringBuilder SqlString() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("p.id, ");
		sql.append("p.id_categories as id_categories, ");
		sql.append("p.sizes as sizes, ");
		sql.append("p.product_name as product_name, ");
		sql.append("p.sale as sale, ");
		sql.append("p.title as title, ");
		sql.append("p.detail as detail, ");
		sql.append("c.color_name as color_name, ");
		sql.append("c.code as code_color, ");
		sql.append("c.img as img, ");
		sql.append("p.created_at as created_at, ");
		sql.append("p.updated_at as updated_at, ");
		sql.append("p.price as price, ");
		sql.append("c.id as id_color, ");
		sql.append("p.FEATURED_PRODUCT, ");
		sql.append("p.NEW_PRODUCT ");
		sql.append("FROM products AS p ");
		sql.append("INNER JOIN product_colors AS c ");
		sql.append("ON p.id = c.id_product ");
		
		return sql;
	}

	private String sqlProducts(String typeProduct) {
		StringBuilder sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		if (typeProduct == FEATURED_PRODUCT) {
			sql.append("AND p.FEATURED_PRODUCT = 1 ");
		}
		if (typeProduct == NEW_PRODUCT) {
			sql.append("AND p.NEW_PRODUCT = 1 ");
		}
		sql.append("GROUP BY ");
		sql.append("p.id ");
		if (typeProduct == FEATURED_PRODUCT) {
			sql.append("LIMIT 9;");
		}
		if (typeProduct == NEW_PRODUCT) {
			sql.append("LIMIT 12;");
		}
		return sql.toString();
	}

	private String sqlAllProductByIdOrPaginate(int id, int firstProduct, int limit) {
		StringBuilder sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND p.id_categories = " + id + " ");
		sql.append("GROUP BY ");
		sql.append("p.id ");

		if(limit != 0) {
			sql.append("LIMIT " + firstProduct +","+limit + ";");
		}
		
		return sql.toString();
	}
	
	private String sqlProductById(int id) {
		StringBuilder sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND p.ID = " + id + " ");
		sql.append("GROUP BY ");
		sql.append("p.id ");
		
		return sql.toString();
	}


	public List<ProductsDto> getDataProducts(String typeProduct) {
		String sql = sqlProducts(typeProduct);
		List<ProductsDto> products = _jdbcTemplate.query(sql, new MapperProductsDto());
		return products;
	}
	
	public List<ProductsDto> getDataProductsByCategoryId(int id) {
		String sql = sqlAllProductByIdOrPaginate(id, 0, 0);
		List<ProductsDto> products = _jdbcTemplate.query(sql, new MapperProductsDto());
		return products;
	}
	
	public List<ProductsDto> getDataProductsPaginate(int id, int firstProduct, int limit) {
		String sqlProductById = sqlAllProductByIdOrPaginate(id, 0, 0);
		List<ProductsDto> productById = _jdbcTemplate.query(sqlProductById, new MapperProductsDto());
		List<ProductsDto> products = new ArrayList<ProductsDto>();
		if(productById.size() > 0) {
			String sql = sqlAllProductByIdOrPaginate(id, firstProduct, limit);
			products = _jdbcTemplate.query(sql, new MapperProductsDto());
		}
		return products;
	}
	
	public ProductsDto findProductById(int id) {
		String sql = sqlProductById(id);
		ProductsDto products = _jdbcTemplate.queryForObject(sql, new MapperProductsDto());
		return products;
	}

}
