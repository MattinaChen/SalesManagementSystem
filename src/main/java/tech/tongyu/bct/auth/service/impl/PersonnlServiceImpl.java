package tech.tongyu.bct.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tech.tongyu.bct.auth.entity.Personnel;
import tech.tongyu.bct.auth.mapper.PersonnelMapper;
import tech.tongyu.bct.auth.service.PersonnelService;


@Service
public class PersonnlServiceImpl extends ServiceImpl<PersonnelMapper, Personnel> implements PersonnelService{
	@Autowired
	private PersonnelMapper personnelMapper;

	@Override
	public List<Personnel> findPersonnel(List<Integer> ids) {
		
		return personnelMapper.findPersonnel(ids);
	}

	@Override
	public List<Personnel> findPersonnelByLike(String companyName, String departmentName, String name,Page<Personnel> page) {
		
		return personnelMapper.findPersonnelByLike(companyName, departmentName, name,page);
	}

	@Override
	public int addPersonner(Personnel personnel) {
		
		return personnelMapper.addPersonner(personnel);
	}
	
	
}
