package tech.tongyu.bct.auth.service;


import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import tech.tongyu.bct.auth.entity.Company;

public interface CompanyService extends IService<Company> {
	
	List<Company> selectcompanyFind();

}
