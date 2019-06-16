package com.scs.service;

import java.util.List;

import com.scs.beans.Lab;
import com.scs.comon.ResponseModel;

public interface getLabListService {
List<Lab> getLabList();	
	ResponseModel<Lab> getLabs(int offset,int pageSize);
}
