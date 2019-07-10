package tech.tongyu.bct.auth.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import tech.tongyu.bct.auth.entity.Compper;

public interface CompperService extends IService<Compper>  {
	
	List<Integer>findCompperById(Integer companyId) throws Exception;

}
