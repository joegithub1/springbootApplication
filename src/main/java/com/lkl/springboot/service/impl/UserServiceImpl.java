package com.lkl.springboot.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.lkl.springboot.po.Tuser;
import com.lkl.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("defaultJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Override
	public Integer create(Tuser user) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		user.setRegTime(sdf.format(new Date()));
		String sql="insert into t_user(user_name,pass_word,email,nick_name,reg_time) values(?,?,?,?,?)";
		int res = jdbcTemplate.update(sql, user.getUserName(),user.getPassWord(),user.getEmail(),user.getNickName(),user.getRegTime());
		return res;
	}

	@Override
	public Integer deleteByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount() {
		Integer count = jdbcTemplate.queryForObject("select count(1) from t_user", Integer.class);
		return count;
	}

	@Override
	public List<Tuser> findUser() {
		List<Tuser> tusers = null;
		//jdbcTemplate.queryForList("select * from t_user order by reg_time desc", Tuser.class);
		
		tusers = jdbcTemplate.query("select * from t_user order by reg_time desc",new Tuser());  //得到装有map的list

		return tusers;
	}

	@Override
	public Integer updateById(Tuser user) {
		// TODO Auto-generated method stub
		return null;
	}

}
