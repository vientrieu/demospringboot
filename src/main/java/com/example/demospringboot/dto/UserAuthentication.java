package com.example.demospringboot.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mangvientrieu
 */
@Getter
@Setter
public class UserAuthentication {
	private Long userId;
	private String role;
}
