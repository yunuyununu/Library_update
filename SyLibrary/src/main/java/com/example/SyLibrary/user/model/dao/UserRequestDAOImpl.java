package com.example.SyLibrary.user.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.SyLibrary.admin.model.dto.HoBookDTO;

@Repository
public class UserRequestDAOImpl implements UserRequestDAO {
	@Autowired
	SqlSession sqlSession;

	public String insert(HoBookDTO dto) {
		String result = "";
		try {
			sqlSession.insert("request.insert", dto);
			result = "신청완료";
		} catch (Exception e) {
			e.printStackTrace();
			result = "error";
		}
		return result;
	}
}
