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
 * 
 * </p>
 *
 * @author zhouxian
 * @since 2018-12-24
 */
@TableName("sys_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户名
     */
	@TableField("user_name")
	private String userName;
    /**
     * 密码
     */
	@TableField("pass_word")
	private String passWord;
    /**
     * 是否启用
     */
	@TableField("user_enable")
	private Integer userEnable;
	/**
	 * 是否可用
	 * */
	@TableField("user_status")
	private  Integer userStatus;


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

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Integer getUserEnable() {
		return userEnable;
	}

	public void setUserEnable(Integer userEnable) {
		this.userEnable = userEnable;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public static final String ID = "id";

	public static final String USER_NAME = "user_name";

	public static final String PASS_WORD = "pass_word";

	public static final String USER_ENABLE = "user_enable";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", userName=" + userName +
			", passWord=" + passWord +
			", userEnable=" + userEnable +
				",userStatus="+userStatus+
			"}";
	}
}
