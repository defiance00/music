package org.company.app.service;

import java.util.Map;

public interface LoginService {
	Map<String, Object> login(String email, String passwd);
	}

