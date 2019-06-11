package com.FAS.service;

import java.util.List;
import com.FAS.entities.SaleDetail;

public interface ISaleDetailService extends CrudService<SaleDetail>{

	List<SaleDetail> fetchBySaleId(int id)throws Exception;
}
