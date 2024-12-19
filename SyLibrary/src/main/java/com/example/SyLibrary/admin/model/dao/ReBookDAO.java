package com.example.SyLibrary.admin.model.dao;

import java.util.List;

import com.example.SyLibrary.admin.model.dto.ReBookDTO;

public interface ReBookDAO {
	List<ReBookDTO> list(String search_option, String search, int start, int end);
	int count(String search_option, String search);
}
