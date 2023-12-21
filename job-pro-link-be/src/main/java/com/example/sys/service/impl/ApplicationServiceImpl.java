package com.example.sys.service.impl;

import com.example.sys.entity.Application;
import com.example.sys.mapper.ApplicationMapper;
import com.example.sys.service.IApplicationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author soso
 * @since 2023-11-09
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements IApplicationService {

}
