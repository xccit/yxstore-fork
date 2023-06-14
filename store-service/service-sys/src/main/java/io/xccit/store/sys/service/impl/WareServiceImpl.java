package io.xccit.store.sys.service.impl;


import io.xccit.store.model.sys.Ware;
import io.xccit.store.sys.mapper.WareMapper;
import io.xccit.store.sys.service.IWareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 仓库表 服务实现类
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Service
public class WareServiceImpl extends ServiceImpl<WareMapper, Ware> implements IWareService {

}
