package DiamondShop.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Dto.BillDetailDto;
import DiamondShop.Dto.MapperBillDetailDto;

@Repository
public class BillDetailDAO extends BaseDAO {

	private final String SQL_GET_BILLDETAIL = "SELECT "
			+ "p.product_name, "
			+ "p.price, "
			+ "c.total, "
			+ "c.qty "
			+ "FROM products AS p "
			+ "INNER JOIN billdetail AS c "
			+ "ON p.id = c.id_bill "
			+ "WHERE c.id_bill = ?";
	
	public List<BillDetailDto> getBillDetail(int id) {
		return _jdbcTemplate.query(SQL_GET_BILLDETAIL, new MapperBillDetailDto(), id);
	}
}
