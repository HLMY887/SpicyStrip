package xyz.hlmy.spicystrip.model.actviti.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.hlmy.spicystrip.model.actviti.entity.PageInfo;

/**
 * 我的申请
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyProListDTO {

    private String userName;

    private String proName;

    private PageInfo pageInfo;

    public String getProName() {
        return proName;
    }

    public MyProListDTO setProName(String proName) {
        this.proName = proName;
        return this;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public MyProListDTO setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public MyProListDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public String toString() {
        return "MyProListDTO{" + "userName='" + userName + '\'' + ", proName='" + proName + '\'' + ", pageInfo=" + pageInfo + '}';
    }
}
