package tech.tongyu.bct.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tech.tongyu.bct.auth.entity.Company;
import tech.tongyu.bct.auth.mapper.CompanyMapper;
import tech.tongyu.bct.auth.service.CompanyService;


@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService{
	@Autowired
	private CompanyMapper companyMapper;

	@Override
	public List<Company> selectcompanyFind() {
		
		return companyMapper.selectcompanyFind();
	}
	
	
	
}
