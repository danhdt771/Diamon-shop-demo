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
		sql.append("MIN(p.id_categories) as id_categories, ");
		sql.append("MIN(p.sizes) as sizes, ");
		sql.append("MIN(p.product_name) as product_name, ");
		sql.append("MIN(p.sale) as sale, ");
		sql.append("MIN(p.title) as title, ");
		sql.append("MIN(p.detail) as detail, ");
		sql.append("MIN(c.color_name) as color_name, ");
		sql.append("MIN(c.code) as code_color, ");
		sql.append("MIN(c.img) as img, ");
		sql.append("MIN(p.created_at) as created_at, ");
		sql.append("MIN(p.updated_at) as updated_at, ");
		sql.append("MIN(p.price) as price, ");
		sql.append("MIN(c.id) as id_color, ");
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
		sql.append("p.id , ");
		sql.append("p.FEATURED_PRODUCT, ");
		sql.append("p.NEW_PRODUCT ");
		sql.append("ORDER BY NEWID() ");
		if (typeProduct == FEATURED_PRODUCT) {
			sql.append("OFFSET 0 ROWS ");
			sql.append("FETCH NEXT 9 ROWS ONLY ");
		}
		if (typeProduct == NEW_PRODUCT) {
			sql.append("OFFSET 0 ROWS ");
			sql.append("FETCH NEXT 12 ROWS ONLY ");
		}
		return sql.toString();
	}

	private String sqlAllProductByIdOrPaginate(int id, int firstProduct, int limit) {
		StringBuilder sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND p.id_categories = " + id + " ");
		sql.append("GROUP BY ");
		sql.append("p.id , ");
		sql.append("p.FEATURED_PRODUCT, ");
		sql.append("p.NEW_PRODUCT ");

		if(limit != 0) {
			sql.append("ORDER BY p.ID asc ");
			sql.append("OFFSET " + (firstProduct-1) + " ROWS ");
			sql.append("FETCH NEXT " + limit + " ROWS ONLY ");
		}
		
		return sql.toString();
	}
	
	private String sqlProductById(int id) {
		StringBuilder sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND p.ID = " + id + " ");
		sql.append("GROUP BY ");
		sql.append("p.id , ");
		sql.append("p.FEATURED_PRODUCT, ");
		sql.append("p.NEW_PRODUCT ");
		
		return sql.toString();
	}


	public List<ProductsDto> getDataProducts(String typeProduct) {
		String sql = sqlProducts(typeProduct);
		List<ProductsDto> products = _jdbcTemplate.query(sql, new MapperProductsDto());
		return products;
	}
	
	public List<ProductsDto> getDataProductsById(int id) {
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
