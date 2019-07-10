package tech.tongyu.bct.auth.service;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;


import tech.tongyu.bct.auth.entity.Personnel;



public interface PersonnelService  extends IService<Personnel>  {
	
	int addPersonner(Personnel personnel);
	
	List<Personnel> findPersonnel(@Param("ids")List<Integer> ids);
	
	List<Personnel> findPersonnelByLike(String companyName,
			String departmentName,
			String name,Page<Personnel> page);
}
