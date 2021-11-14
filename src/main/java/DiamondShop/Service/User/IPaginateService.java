package DiamondShop.Service.User;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.PaginatesDto;

@Service
public interface IPaginateService {

	public PaginatesDto getInfoPaginates(int currentPage, int limit, int totalData);
}
