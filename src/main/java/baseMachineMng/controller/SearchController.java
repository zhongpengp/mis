//package baseMachineMng.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import baseMachineMng.service.TableTotalService;
//import baseMachineMng.vo.TableTotal;
//
//@Controller
//@RequestMapping("/baseMachineSearchController")
//public class SearchController {
//
//	@Autowired
//	private TableTotalService tableTotalService;
//
//	@RequestMapping("searchByForm")
//	@ResponseBody
//	public List<TableTotal> searchMachineByForm(TableTotal tableTotal, String gouzhiriqi1, String gouzhiriqi2,
//			String daoruxitongriqi1, String daoruxitongriqi2, String shebeimingchengjingquechaxun) {
//		List<TableTotal> result = tableTotalService.searchMachineByForm(tableTotal, gouzhiriqi1, gouzhiriqi2,
//				daoruxitongriqi1, daoruxitongriqi2, shebeimingchengjingquechaxun);
//		System.out.println(result.size());
//		return result;
//	}
//}
