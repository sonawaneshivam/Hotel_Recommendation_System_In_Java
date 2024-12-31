package com.hotel.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginEntity {
	private int id;
	private String name;
	private String email;
	private String conatct_no;
	private String username;
	private String password;
	private String type;
	private String status;
}
