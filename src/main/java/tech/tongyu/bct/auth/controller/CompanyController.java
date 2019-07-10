package tech.tongyu.bct.auth.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import tech.tongyu.bct.auth.common.JsonResult;
import tech.tongyu.bct.auth.entity.Company;
import tech.tongyu.bct.auth.entity.Compper;
import tech.tongyu.bct.auth.entity.Personnel;
import tech.tongyu.bct.auth.service.CompanyService;



@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	/**
	 * 树结构分页
	 * @author cjzhe
	 * @date 2019年7月2日13:52:52
	 * 
	 */
		@GetMapping("/showcompany")
	public ResponseEntity<JsonResult> showcompany(HttpServletRequest request){
		JsonResult result = new JsonResult();
		try {
			List<Object> list = new ArrayList<Object>();
			
			List<Company> selectcompanyFind = companyService.selectcompanyFind();//查数据
			for (Company company : selectcompanyFind) {
				Map<Object, Object> map =new HashMap<Object, Object>();
				map.put("name", company.getName());
				list.add(map);
				List<Company> list2 = companyService.list(new QueryWrapper<Company>().eq("company_id", company.getId()));
				for (int i = 0; i < list2.size(); i++) {
					Map<Object, Object> map2 =new HashMap<Object, Object>();
					map2.put("userName"+i, list2.get(i).getName());
					list.add(map2);
				}
			}
			result.setData(list);
			result.setStatus("success");
		} catch (Exception e) {
			result.setStatus("error");
			result.setDescription(e.getClass().getName() + ":" + e.getMessage());
		}
		return ResponseEntity.ok(result);
	}
	/**
	 * 增加分公司和销售 分公司传一个参数name  销售传 name companyId
	 * @param cId
	 * @param cId2
	 * @return
	 */
	//http://localhost:8080/TEST/personnel/findPersonnel
	@PostMapping("/addCompany")
	public ResponseEntity<JsonResult> addCompany(Company company,HttpServletRequest request){
		JsonResult result = new JsonResult();
		if(company!=null) {
			boolean save = companyService.save(company);
			
			if(save) {
				result.setData(save);
				result.setStatus("success");
			}
		}else {
			result.setStatus("eroor");
		}
		
		return ResponseEntity.ok(result);
		
	}
	
	
	
	
	
	
}
