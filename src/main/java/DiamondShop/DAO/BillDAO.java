package DiamondShop.DAO;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.BillDetail;
import DiamondShop.Entity.Bills;

@Repository
public class BillDAO extends BaseDAO {

	public int addBill(Bills bill) {
		StringBuffer  sql = new StringBuffer();
		
		sql.append("INSERT INTO bills ( ");
		sql.append("USER_NAME, ");
		sql.append("PHONE, ");
		sql.append("DISPLAY_NAME, ");
		sql.append("ADDRESS, ");
		sql.append("TOTAL, ");
		sql.append("TOTAL_QTY, ");
		sql.append("NOTE ");
		sql.append(") VALUES ( ");
		sql.append("'"+bill.getUser_name()+"', ");
		sql.append("'"+bill.getPhone()+"', ");
		sql.append("'"+bill.getDisplay_name()+"', ");
		sql.append("'"+bill.getAddress()+"', ");
		sql.append("'"+bill.getTotal()+"', ");
		sql.append("'"+bill.getTotal_qty()+"', ");
		sql.append("'"+bill.getNote()+"' ");
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
		StringBuffer  sql = new StringBuffer();
		
		sql.append("INSERT INTO billdetail ( ");
		sql.append("id_product, ");
		sql.append("id_bill, ");
		sql.append("total, ");
		sql.append("qty ");
		sql.append(") VALUES ( ");
		sql.append(""+billDetail.getId_product()+", ");
		sql.append(""+billDetail.getId_bill()+", ");
		sql.append(""+billDetail.getTotal()+", ");
		sql.append(""+billDetail.getQty()+" ");
		sql.append(");");
		
		int result = _jdbcTemplate.update(sql.toString());
		
		return result;
	}
}
