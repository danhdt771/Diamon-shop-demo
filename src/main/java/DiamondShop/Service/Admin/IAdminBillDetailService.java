package DiamondShop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.BillDetailDto;

@Service
public interface IAdminBillDetailService {

	public List<BillDetailDto> getBillDeatail(int id);
}
