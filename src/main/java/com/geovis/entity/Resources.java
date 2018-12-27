package com.geovis.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author zhouxian
 * @since 2018-12-24
 */
@TableName("sys_resources")
public class Resources extends Model<Resources> {

    private static final long serialVersionUID = 1L;

    /**
     * 资源ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 资源名称
     */
    @TableField("user_name")
    private String userName;
    /**
     * 资源url
     */
    @TableField("res_url")
    private String resUrl;
    /**
     * 资源类型   1:菜单    2：按钮
     */
    @TableField("user_type")
    private String userType;
    /**
     * 父资源
     */
    @TableField("parent_id")
    private String parentId;
    /**
     * 排序
     */
    @TableField("user_sort")
    private String userSort;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getUserSort() {
        return userSort;
    }

    public void setUserSort(String userSort) {
        this.userSort = userSort;
    }

    public static final String ID = "id";

    public static final String USER_NAME = "user_name";

    public static final String RES_URL = "res_url";

    public static final String USER_TYPE = "user_type";

    public static final String PARENT_ID = "parent_id";

    public static final String USER_SORT = "user_sort";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "id=" + id +
                ", userName=" + userName +
                ", resUrl=" + resUrl +
                ", userType=" + userType +
                ", parentId=" + parentId +
                ", userSort=" + userSort +
                "}";
    }
}
