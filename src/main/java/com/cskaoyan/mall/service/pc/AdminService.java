package com.cskaoyan.mall.service.pc;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.vo.ListBean;
import com.cskaoyan.mall.vo.adminManage.AddAdminVo;
import com.cskaoyan.mall.vo.adminManage.AdminVo;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
@Service
public interface AdminService {
    ListBean queryAllAdmins(int page, int limit, String sort, String order) throws IOException;

    ListBean queryAdminsByUsername(int page, int limit, String username,String sort, String order) throws IOException;

    void deleteAdminById(AdminVo adminVo);

    AddAdminVo insertAdmin(AddAdminVo addAdminVo);

    AddAdminVo updateAdminById(AddAdminVo addAdminVo);

}
