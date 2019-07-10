package tech.tongyu.bct.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tech.tongyu.bct.auth.entity.Compper;
import tech.tongyu.bct.auth.mapper.CompperMapper;

import tech.tongyu.bct.auth.service.CompperService;


@Service
public class CompperServiceImpl extends ServiceImpl<CompperMapper, Compper> implements CompperService{
	@Autowired
	private CompperMapper compperMapper;

	@Override
	public List<Integer> findCompperById(Integer companyId)throws Exception {

		List<Integer> findCompperByIds = compperMapper.findCompperById(companyId);
		if(findCompperByIds==null) {
			return null;
		}
		
		return findCompperByIds;
	}
}
