package DiamondShop.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.BillDetail;
import DiamondShop.Entity.Bills;
import DiamondShop.Entity.MapperBills;

@Repository
public class BillDAO extends BaseDAO {

	private final String SQL_GET_ALL_BILL = "select * from bills ";
	private final String SQL_FIND_BILL_BY_ID = "select * from bills where id = ?";
	private final String SQL_CHECK_EXISTS_BILL = "select count(*) from bills where id = ?";
	private final String SQL_DELETE_BILL = "delete from bills where id = ?";
	private final String SQL_UPDATE_BILL = "update bills "
			+ "set USER_NAME = ?, PHONE = ?, DISPLAY_NAME = ?, ADDRESS = ?, TOTAL = ?, " 
			+ "TOTAL_QTY = ?, NOTE = ? " 
			+ "where id = ?";
	private final String SQL_INSERT_BILL = "insert into bills" 
			+ "(USER_NAME, PHONE, DISPLAY_NAME, ADDRESS, TOTAL, TOTAL_QTY, NOTE) "
			+ "values(?,?,?,?,?,?,?)";

	public int addBill(Bills bill) {
		StringBuffer sql = new StringBuffer();

		sql.append("INSERT INTO bills ( ");
		sql.append("USER_NAME, ");
		sql.append("PHONE, ");
		sql.append("DISPLAY_NAME, ");
		sql.append("ADDRESS, ");
		sql.append("TOTAL, ");
		sql.append("TOTAL_QTY, ");
		sql.append("NOTE ");
		sql.append(") VALUES ( ");
		sql.append("'" + bill.getUser_name() + "', ");
		sql.append("'" + bill.getPhone() + "', ");
		sql.append("'" + bill.getDisplay_name() + "', ");
		sql.append("'" + bill.getAddress() + "', ");
		sql.append("'" + bill.getTotal() + "', ");
		sql.append("'" + bill.getTotal_qty() + "', ");
		sql.append("'" + bill.getNote() + "' ");
		sql.append(");");

		int result = _jdbcTemplate.update(sql.toString());

		return result;
	}

	public int getIdLastBill() {
		String sql = "Select MAX(Id) From bills;";
		int id = _jdbcTemplate.queryForObject(sql, Integer.class);

		return id;
	}

	public int addBillDetail(BillDetail billDetail) {
		StringBuffer sql = new StringBuffer();

		sql.append("INSERT INTO billdetail ( ");
		sql.append("id_product, ");
		sql.append("id_bill, ");
		sql.append("total, ");
		sql.append("qty ");
		sql.append(") VALUES ( ");
		sql.append("" + billDetail.getId_product() + ", ");
		sql.append("" + billDetail.getId_bill() + ", ");
		sql.append("" + billDetail.getTotal() + ", ");
		sql.append("" + billDetail.getQty() + " ");
		sql.append(");");

		int result = _jdbcTemplate.update(sql.toString());

		return result;
	}

	// GET BILL WITH PAGINATION
	private String sqlBillPagination(int firstBill, int limit) {
		StringBuilder sql = new StringBuilder();
		sql.append(SQL_GET_ALL_BILL);
		sql.append("ORDER BY id asc ");
		sql.append("OFFSET " + (firstBill - 1) + " ROWS ");
		sql.append("FETCH NEXT " + limit + " ROWS ONLY ");

		return sql.toString();
	}

	// GET ALL BILL.
	public List<Bills> listBill() {
		return _jdbcTemplate.query(SQL_GET_ALL_BILL, new MapperBills());
	}

	// GET BILL WITH PAGINATION.
	public List<Bills> getBillPagination(int firstBill, int limit) {
		String sql = sqlBillPagination(firstBill, limit);
		return _jdbcTemplate.query(sql, new MapperBills());
	}

	public boolean deleteBill(int id) {
		return _jdbcTemplate.update(SQL_DELETE_BILL, id) > 0;
	}

	public boolean updateBill(Bills bill) {
		return _jdbcTemplate.update(SQL_UPDATE_BILL, 
				bill.getUser_name(), 
				bill.getPhone(),
				bill.getDisplay_name(), 
				bill.getAddress(), 
				bill.getTotal(), 
				bill.getTotal_qty(), 
				bill.getNote(), 
				bill.getId()) > 0;
	}

//	public boolean createBill(Bills bill) {
//		return _jdbcTemplate.update(SQL_INSERT_BILL, 
//				bill.getUser_name(), 
//				bill.getPhone(),
//				bill.getDisplay_name(), 
//				bill.getAddress(), 
//				bill.getTotal(), 
//				bill.getTotal_qty(), 
//				bill.getNote()) > 0;
//	}

	public Bills findBillById(int id) {
		return _jdbcTemplate.queryForObject(SQL_FIND_BILL_BY_ID, new MapperBills(), id);
	}

	public Integer checkBillExists(int id) {
		return _jdbcTemplate.queryForObject(SQL_CHECK_EXISTS_BILL, Integer.class, id);
	}
}
