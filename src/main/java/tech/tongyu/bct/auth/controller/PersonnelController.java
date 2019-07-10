package tech.tongyu.bct.auth.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import tech.tongyu.bct.auth.common.JsonResult;
import tech.tongyu.bct.auth.dto.QueryVo;
import tech.tongyu.bct.auth.entity.Company;
import tech.tongyu.bct.auth.entity.Compper;
import tech.tongyu.bct.auth.entity.Personnel;
import tech.tongyu.bct.auth.service.CompanyService;
import tech.tongyu.bct.auth.service.CompperService;
import tech.tongyu.bct.auth.service.PersonnelService;



@RestController
@RequestMapping("/personnel")
public class PersonnelController {
	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private PersonnelService personnelService;
	@Autowired
	private CompperService compperService;
	
	/**
	 * 销售数据展示 和模糊查询分頁
	 * @author cjzhe
	 * @date 2019年7月2日13:52:52
	 * 
	 */
	@GetMapping("/findPersonnel")
	public ResponseEntity<JsonResult> findPersonnel(String companyName,String departmentName,String name,HttpServletRequest request){
		JsonResult result = new JsonResult();
		String companyNameBy = null;
		String departmentNameBy = null;
		String nameBy = null;
		if(companyName!=null && !companyName.equals("")) {
			companyNameBy= companyName;
		}
		if(departmentName!=null && !departmentName.equals("")) {
			departmentNameBy= departmentName;
		}
		if(name!=null && !name.equals("")) {
			nameBy= name;
		}
		try {
			Page<Personnel> page = new Page<Personnel>(0,10);
			List<Personnel> findPersonnelByLike = personnelService.findPersonnelByLike(companyNameBy, departmentNameBy, nameBy,page);
			List<QueryVo> vo = new ArrayList<QueryVo>();
			for (Personnel personnel : findPersonnelByLike) {
				Compper one = compperService.getOne(new QueryWrapper<Compper>().eq("personnel_id", personnel.getId()));
				Company byId = companyService.getById(one.getCompanyId());
				Company one2 = companyService.getOne(new QueryWrapper<Company>().eq("id", byId.getCompanyId()));
				QueryVo qu = new QueryVo();
				qu.setName(personnel.getName());
				qu.setDateTime(personnel.getTimeup());
				qu.setCompany(byId.getName());
				qu.setDepartment(one2.getName());
				vo.add(qu);
			}
			page.setRecords(findPersonnelByLike);
			List<Object> list = new ArrayList<Object>();
			list.add(page);
			list.add(vo);
			result.setData(list);
			if(vo!=null) {
				result.setStatus("success");
			}
			
		} catch (Exception e) {
			result.setStatus("error");
			result.setDescription(e.getClass().getName() + ":" + e.getMessage());
		}
		return ResponseEntity.ok(result);
	}
	
	
	/**
	 * 根据条件销售数据展示
	 * @author cjzhe
	 * @date 2019年7月2日13:52:52
	 * 
	 */
	@GetMapping("/showPersonnel")
	public ResponseEntity<JsonResult> showPersonnel(Integer CompanyId,Integer departmentId,HttpServletRequest request){
		JsonResult result = new JsonResult();
		try {
			//cId 是分公司id  cId2是营业部
			List<QueryVo> moth = this.moth(CompanyId, departmentId);
			
			result.setData(moth);
			if(moth!=null) {
				result.setStatus("success");
			}else {
				result.setStatus("error");
			}
			
		} catch (Exception e) {
			result.setStatus("error");
			result.setDescription(e.getClass().getName() + ":" + e.getMessage());
		}
		return ResponseEntity.ok(result);
	}
	/**
	 * 增加销售
	 * @param cId
	 * @param cId2
	 * @return
	 */
	@PostMapping("/addPersonnel")
	public ResponseEntity<JsonResult> addPersonnel(Personnel personnel,Integer Companyid,HttpServletRequest request){
		JsonResult result = new JsonResult();
		if(personnel!=null) {
			System.out.println("personnel:"+personnel);

			int save = personnelService.addPersonner(personnel);
			//int personnelId = personnel.getId();

			Compper c = new Compper();
			c.setCompanyId(Companyid);
			c.setPersonnelId(personnel.getId());
			boolean save2 = compperService.save(c);

			System.out.println("personel_id = "+personnel.getId());
			System.out.println("CompanyId = "+Companyid);
			if(save>0  &&save2 ==true) {
				result.setData(save);
				result.setStatus("success");
			}else {
				result.setData(save);
				result.setStatus("error");
			}

		}else {
			result.setStatus("error");
		}
		
		return ResponseEntity.ok(result);
		
	}
	/**
	 * 删除销售
	 * @param cId
	 * @param cId2
	 * @return
	 */
	@PostMapping("/delPersonnel")
	public ResponseEntity<JsonResult> delPersonnel(Integer id,HttpServletRequest request){
		JsonResult result = new JsonResult();
		if(id!=null) {
			boolean save = personnelService.removeById(id);
			boolean remove = compperService.remove(new QueryWrapper<Compper>().eq("personnel_id", id));
			
			if(save== true &&remove ==true) {
				result.setData(save);
				result.setStatus("success");
			}
			
		}else {
			result.setStatus("eroor");
		}
		
		return ResponseEntity.ok(result);
		
	}
	
	/**
	 * 修改
	 * @param cId
	 * @param cId2
	 * @return
	 */
	@PostMapping("/updatePersonnel")
	public ResponseEntity<JsonResult> updatePersonnel(Personnel personnel,Integer CompanyId,HttpServletRequest request){
		JsonResult result = new JsonResult();
		if(personnel!=null) {

           // private Logger logger = LoggerFactory.getLogger(UserController.class);
			//System.out.println("setPersonnelId1111= "+personnel.getId());
			boolean updatePersonnel = personnelService.updateById(personnel);
			//Compper c = new Compper();
			//c.setCompanyId(CompanyId);
			//c.setPersonnelId(personnel.getId());
			//boolean save2 = compperService.updateById(c);

			System.out.println("setCompanyId = "+CompanyId);
			System.out.println("setPersonnelId= "+personnel.getId());
			/*if(updatePersonnel== true &&save2 ==true) {
				result.setData(updatePersonnel);
				result.setStatus("success");
			}
			
			}else {
				result.setStatus("eroor");
			}*/

			if(updatePersonnel== true) {
				result.setData(updatePersonnel);
				result.setStatus("success");
			}

		}else {
			result.setStatus("eroor");
		}
		
		return ResponseEntity.ok(result);
		
	}
	
	
	
	public List<QueryVo> moth(Integer cId,Integer cId2){
		 Company byId = companyService.getById(cId);//查数据
		 Company byId2 = companyService.getById(cId2);
		 List<Integer> ids =null;
		try {
			ids = compperService.findCompperById(cId2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ids!=null) {
			List<Personnel> findPersonnel = personnelService.findPersonnel(ids);
			 List<QueryVo> vo = new ArrayList<QueryVo>();
			 for (Personnel personnel : findPersonnel) {
				 QueryVo qu = new QueryVo();
				 qu.setName(personnel.getName()); 
				 qu.setCompany(byId.getName());
				 qu.setDepartment(byId2.getName());
				 qu.setDateTime(personnel.getTimeup());
				 vo.add(qu);
			}
			 return vo;
			
		}
		 
		 
		return null;
	}
	
	
	
}
