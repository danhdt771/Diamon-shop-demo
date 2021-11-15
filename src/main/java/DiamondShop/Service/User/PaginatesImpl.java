package DiamondShop.Service.User;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.PaginatesDto;

@Service
public class PaginatesImpl implements IPaginateService {

	@Override
	public PaginatesDto getInfoPaginates(int currentPage, int limit, int totalData) {
		PaginatesDto paginate = new PaginatesDto();
		paginate.setLimit(limit);
		paginate.setTotalPage(setInfoTotalPages(totalData, limit));
		paginate.setCurrentPage(checkCurrentPage(currentPage, paginate.getTotalPage()));
		paginate.setFirstProduct(findFirstProductInPage(paginate.getCurrentPage(), limit));
		
		return paginate;
	}
	
	private int findFirstProductInPage(int currentPage, int limit) {
		return (currentPage - 1) * limit + 1;
	}
	
	private int setInfoTotalPages(int totalData, int limit) {
		int totalPage = 0;
		totalPage = totalData / limit;
		totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage;
		return totalPage;
	}
	
	private int checkCurrentPage(int currentPage, int totalPage) {
		if(currentPage < 1) {
			return 1;
		}
		if(currentPage > totalPage) {
			return totalPage;
		}
		return currentPage;
	}
}
