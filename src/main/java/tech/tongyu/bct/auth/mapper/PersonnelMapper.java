package tech.tongyu.bct.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import tech.tongyu.bct.auth.entity.Compper;
import tech.tongyu.bct.auth.entity.Personnel;



public interface PersonnelMapper extends BaseMapper<Personnel> {
	List<Personnel> findPersonnel(@Param("ids")List<Integer> ids);
	
	int addPersonner(@Param("Personnel")Personnel personnel);
	
	List<Personnel> findPersonnelByLike(@Param("companyName")String companyName,
			@Param("departmentName")String departmentName,
			@Param("name")String name,Page<Personnel> page);
	
	
}
