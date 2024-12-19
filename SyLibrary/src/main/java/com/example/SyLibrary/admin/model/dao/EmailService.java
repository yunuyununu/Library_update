package com.example.SyLibrary.admin.model.dao;

import com.example.SyLibrary.admin.model.dto.EmailDTO;

public interface EmailService {
	void sendMail(EmailDTO dto);
}
