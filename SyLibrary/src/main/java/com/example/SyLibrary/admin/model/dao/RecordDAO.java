package com.example.SyLibrary.admin.model.dao;

import java.util.List;

import com.example.SyLibrary.admin.model.dto.RecordDTO;


public interface RecordDAO {
	int count(String search_option, String keyword);
	List<RecordDTO> list(int start, int end, String search_option, String keyword);
	public List<RecordDTO> order(int start, int end, String search_option, String keyword);
	public String member_email(int l_num);
}
