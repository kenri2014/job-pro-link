package com.example.sys.mapper;

import com.example.sys.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author soso
 * @since 2023-11-09
 */
public interface UsersMapper extends BaseMapper<Users> {
  String getUserName(String userName);
  String getPassword(String password);

}
