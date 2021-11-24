package DiamondShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.DAO.BillDetailDAO;
import DiamondShop.Dto.BillDetailDto;

@Service
public class AdminBillDetailImpl implements IAdminBillDetailService {
	
	@Autowired
	private BillDetailDAO _billDetailDAO;
	
	@Override
	public List<BillDetailDto> getBillDeatail(int id) {
		return _billDetailDAO.getBillDetail(id);
	}

}
