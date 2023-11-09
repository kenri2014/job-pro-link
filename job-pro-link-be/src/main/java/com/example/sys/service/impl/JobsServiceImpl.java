package com.example.sys.service.impl;

import com.example.sys.entity.Jobs;
import com.example.sys.mapper.JobsMapper;
import com.example.sys.service.IJobsService;
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
public class JobsServiceImpl extends ServiceImpl<JobsMapper, Jobs> implements IJobsService {

}
