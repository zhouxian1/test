package com.geovis.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
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
@TableName("sys_login_log")
public class LoginLog extends Model<LoginLog> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户ID
     */
    private String uid;
    /**
     * 登录时间
     */
    private Date loginTime;
    /**
     * 登陆IP
     */
    private String loginIP;
    /**
     * 登录次数
     */
    private Integer loginTotal;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public Integer getLoginTotal() {
        return loginTotal;
    }

    public void setLoginTotal(Integer loginTotal) {
        this.loginTotal = loginTotal;
    }

    public static final String ID = "id";

    public static final String UID = "uid";

    public static final String LOGINTIME = "loginTime";

    public static final String LOGINIP = "loginIP";

    public static final String LOGINTOTAL = "loginTotal";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "id=" + id +
                ", uid=" + uid +
                ", loginTime=" + loginTime +
                ", loginIP=" + loginIP +
                ", loginTotal=" + loginTotal +
                "}";
    }
}
