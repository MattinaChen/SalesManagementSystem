package tech.tongyu.bct.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import tech.tongyu.bct.auth.entity.Compper;

public interface CompperMapper extends BaseMapper<Compper> {
	
	List<Integer>findCompperById(@Param("companyId")Integer companyId);

}
