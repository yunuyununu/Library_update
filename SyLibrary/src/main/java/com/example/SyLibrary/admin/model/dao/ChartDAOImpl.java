package com.example.SyLibrary.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChartDAOImpl implements ChartDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<Map<String, Object>> ct_chart() {
		List<Map<String, Object>> ctchart = sqlSession.selectList("chart.ct_Chart");
		return ctchart;
	}
	
	@Override
	public List<Map<String, Object>> loChart() {
		List<Map<String, Object>> chart = sqlSession.selectList("chart.loanChart");
		return chart;
	}
}
