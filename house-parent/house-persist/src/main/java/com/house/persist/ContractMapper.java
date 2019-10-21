package com.house.persist;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.house.model.Contract;

public interface ContractMapper {
@Select("select * from t_c_contract where id=#{id}")
public Contract queryById(@Param("id") Long Id);
}
