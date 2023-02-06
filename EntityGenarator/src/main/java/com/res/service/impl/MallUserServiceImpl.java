package service.impl;

import domain.MallUser;
import mapper.MallUserMapper;
import service.IMallUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author joker
 * @since 2023-02-06
 */
@Service
public class MallUserServiceImpl extends ServiceImpl<MallUserMapper, MallUser> implements IMallUserService {

}
