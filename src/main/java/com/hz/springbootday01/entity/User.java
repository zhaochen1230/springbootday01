package com.hz.springbootday01.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class User implements Serializable {
	private Integer id; //id
	private String userCode; //用户编码
	private String userName; //用户名称
	private String userPassword; //用户密码
	private Integer gender;  //性别
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date birthday;  //出生日期
	private String phone;   //电话
	private String address; //地址
	private Role role;    //用户角色
	private Integer createdBy;   //创建者
	private Date creationDate; //创建时间
	private Integer modifyBy;     //更新者
	private Date modifyDate;   //更新时间
	private List<Address> addressList;//地址集合


}
