package com.example.SyLibrary.admin.model.dao;

import java.util.List;

import com.example.SyLibrary.admin.model.dto.MemoDTO;

public interface MemoDAO {
	List<MemoDTO> list(int start, int end);
	void insert(MemoDTO dto);
	void delete(int me_rownum);
	void update(MemoDTO dto);
	int count();
	MemoDTO search(int me_rownum);
}
