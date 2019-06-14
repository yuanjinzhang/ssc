package com.scs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TurnPageMapper {
	@Select("select url from lab_pages where id=#{id}")
	String getPageUrlById(@Param("id") int id);
}
