package DiamondShop.DAO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Dto.MapperProductsDto;
import DiamondShop.Dto.ProductsDto;
import DiamondShop.Entity.MapperProduct;
import DiamondShop.Entity.Product;

@Repository
public class ProductsDAO extends BaseDAO {
	public static final String FEATURED_PRODUCT = "FEATURED_PRODUCT";
	public static final String NEW_PRODUCT = "NEW_PRODUCT";
	
	private final String SQL_FIND_PRODUCT = "select * from products where id = ?";
	private final String SQL_CHECK_EXISTS_PRODUCT = "select count(*) from products where id = ?";
	private final String SQL_DELETE_PRODUCT = "delete from products where id = ?";
	private final String SQL_UPDATE_PRODUCT = 
			"update products "
			+ "set id_categories = ?, sizes = ?, product_name = ?, price = ?, sale = ?, "
			+ "featured_product = ?, new_product = ?, detail = ?, updated_at = ? "
			+ "where id = ?";
	private final String SQL_INSERT_PRODUCT = 
			"insert into products"
			+ "(id_categories, sizes, product_name, price, sale, featured_product, new_product, detail, created_at, updated_at) "
			+ "values(?,?,?,?,?,?,?,?,?,?)";

	/*For front-end*/
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
	
	//GET PRODUCT DEPENDS ON TYPE PRODUCT
	private String sqlProductsDto(String typeProduct) {
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
		sql.append("ORDER BY p.ID ");
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

	//GET PRODUCT WITH CATEGORY ID AND CREATE PAGINATION
	private String sqlAllProductDtoWithPaginate(int id, int firstProduct, int limit) {
		StringBuilder sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		
		if (id != 0) {
			sql.append("AND p.id_categories = " + id + " ");
		}
		
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
	
	private String sqlProductDtoById(int id) {
		StringBuilder sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND p.ID = " + id + " ");
		sql.append("GROUP BY ");
		sql.append("p.id , ");
		sql.append("p.FEATURED_PRODUCT, ");
		sql.append("p.NEW_PRODUCT ");
		
		return sql.toString();
	}
	/*--------------End-----------------*/
	
	/*For back-end*/
	private StringBuilder sqlGetProductsString() {
		StringBuilder sql = new StringBuilder();
		sql.append("Select * from products as p ");
		return sql;
	}
	
	private String sqlProducts() {
		StringBuilder sql = sqlGetProductsString();
		return sql.toString();
	}

	//GET PRODUCT WITH CATEGORY ID AND CREATE PAGINATION
	private String sqlProductPagination(int firstProduct, int limit) {
		StringBuilder sql = sqlGetProductsString();
		sql.append("ORDER BY p.ID asc ");
		sql.append("OFFSET " + (firstProduct-1) + " ROWS ");
		sql.append("FETCH NEXT " + limit + " ROWS ONLY ");
			
		return sql.toString();
	}
	
	/*For front-end*/
	public List<ProductsDto> getProductsDto(String typeProduct) {
		String sql = sqlProductsDto(typeProduct);
		List<ProductsDto> products = _jdbcTemplate.query(sql, new MapperProductsDto());
		return products;
	}
	
	public List<ProductsDto> getProductsDtoByCategoryId(int id) {
		String sql = sqlAllProductDtoWithPaginate(id, 0, 0);
		List<ProductsDto> products = _jdbcTemplate.query(sql, new MapperProductsDto());
		return products;
	}
	
	//GET PRODUCT WITH CATEGORY ID AND CREATE PAGINATION.
	public List<ProductsDto> getProductsDtoPaginate(int idCategory, int firstProduct, int limit) {
		String sqlProductById = sqlAllProductDtoWithPaginate(idCategory, 0, 0);
		List<ProductsDto> productById = _jdbcTemplate.query(sqlProductById, new MapperProductsDto());
		List<ProductsDto> products = new ArrayList<ProductsDto>();
		if(productById.size() > 0) {
			String sql = sqlAllProductDtoWithPaginate(idCategory, firstProduct, limit);
			products = _jdbcTemplate.query(sql, new MapperProductsDto());
		}
		return products;
	}
	
	public ProductsDto findProductDtoById(int id) {
		String sql = sqlProductDtoById(id);
		ProductsDto products = _jdbcTemplate.queryForObject(sql, new MapperProductsDto());
		return products;
	}
	/*--------------End-----------------*/
	
	/*For back-end*/
	//GET ALL PRODUCTS.
	public List<Product> listProducts() {
		String sql = sqlProducts();
		List<Product> list = _jdbcTemplate.query(sql, new MapperProduct());
		return list;
	}

	//GET PRODUCT WITH CATEGORY ID AND CREATE PAGINATION.
	public List<Product> getProductPagination(int firstProduct, int limit) {
		List<Product> products = new ArrayList<Product>();
		String sql = sqlProductPagination(firstProduct, limit);
		products = _jdbcTemplate.query(sql, new MapperProduct());
		
		return products;
	}
	
	public boolean deleteProduct(long id) {
		return _jdbcTemplate.update(SQL_DELETE_PRODUCT, id) > 0;
	}

	public boolean updateProduct(Product product) {
		Date date = new Date();
		Timestamp timestamp2 = new Timestamp(date.getTime());

		return _jdbcTemplate.update(SQL_UPDATE_PRODUCT, product.getID_CATEGORIES(), 
				product.getSIZES(), 
				product.getPRODUCT_NAME(), 
				product.getPRICE(), 
				product.getSALE(), 
				product.getFEATURED_PRODUCT(), 
				product.getNEW_PRODUCT(), 
				product.getDETAIL(),
				timestamp2,
				product.getID()) > 0;
	}

	public boolean createProduct(Product product) {
		Date date = new Date();
		Timestamp timestamp2 = new Timestamp(date.getTime());
	   
		return _jdbcTemplate.update(SQL_INSERT_PRODUCT, 
				product.getID_CATEGORIES(), 
				product.getSIZES(), 
				product.getPRODUCT_NAME(), 
				product.getPRICE(), 
				product.getSALE(), 
				product.getFEATURED_PRODUCT(), 
				product.getNEW_PRODUCT(), 
				product.getDETAIL(),
				timestamp2,
				timestamp2) > 0;
	}
	
	public Product findProductById(long id) {
		return _jdbcTemplate.queryForObject(SQL_FIND_PRODUCT, new MapperProduct(), id);
	}
	
	public Integer checkProductExists(long id) {
		return _jdbcTemplate.queryForObject(SQL_CHECK_EXISTS_PRODUCT, Integer.class, id);
	}
}
