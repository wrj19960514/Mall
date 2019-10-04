package com.cskaoyan.mall.vo.adminManage;

import java.util.List;

public class PermVo {
    List assignedPermissions;
    List systemPermissions;

    public List getAssignedPermissions() {
        return assignedPermissions;
    }

    public void setAssignedPermissions(List assignedPermissions) {
        this.assignedPermissions = assignedPermissions;
    }

    public List getSystemPermissions() {
        return systemPermissions;
    }

    public void setSystemPermissions(List systemPermissions) {
        this.systemPermissions = systemPermissions;
    }
}
