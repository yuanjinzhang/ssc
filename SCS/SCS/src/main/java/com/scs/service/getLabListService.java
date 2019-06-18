package com.scs.service;

import java.util.List;

import com.scs.beans.Lab;
import com.scs.comon.RequestModel;
import com.scs.comon.ResponseModel;

public interface getLabListService {
List<Lab> getLabList();	
    ResponseModel<Lab> listLabs(RequestModel<Lab> reqModel);
	ResponseModel<Lab> getLabs(int offset,int pageSize);
	ResponseModel<Lab> update(Lab lab);
	ResponseModel<Lab> delete(Lab lab);
}
