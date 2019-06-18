package com.scs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scs.beans.Lab;
import com.scs.beans.User;
import com.scs.comon.PageModel;
import com.scs.comon.RequestModel;
import com.scs.comon.ResponseModel;
import com.scs.service.getLabListService;

@Controller
public class getLabListController {
	@Autowired
	private getLabListService getLabListService;
	
	@RequestMapping("/getLabList")
	@ResponseBody
	public ResponseModel<Lab> getLabList(@RequestBody RequestModel<Lab> reqModel){
		PageModel pageModel=reqModel.getPageModel();
		return getLabListService.getLabs(pageModel.getOffset(), pageModel.getPageSize());
	}
	
	@RequestMapping("/select_test/update")
	@ResponseBody
	public ResponseModel<Lab> update(@RequestBody Lab lab) {
		return getLabListService.update(lab);
	}
	
	@RequestMapping("/select_test/delete")
	@ResponseBody
	public ResponseModel<Lab> delete(@RequestBody Lab lab) {
		return getLabListService.delete(lab);
	}
	
	@RequestMapping("/LabList")
	@ResponseBody
	public ResponseModel<Lab> listLabs(@RequestBody RequestModel<Lab> reqModel){
		ResponseModel<Lab> resModel=getLabListService.listLabs(reqModel);	
		return resModel;
	}
}
