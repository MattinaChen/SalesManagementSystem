package tech.tongyu.bct.auth.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import tech.tongyu.bct.auth.entity.Company;

public interface CompanyMapper extends BaseMapper<Company>  {
	
	List<Company> selectcompanyFind();

}
