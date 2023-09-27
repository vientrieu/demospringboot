package com.example.demospringboot.config;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

/**
 * @author mangvientrieu
 */
public final class UrlAccessConfig {

	public static final Map<String, Set<String>> mapUrl = ImmutableMap.<String, Set<String>>builder()
			.put("USER", Sets.newHashSet("/api/book", "/api/student"))
			.put("ADMIN", Sets.newHashSet("/api/admin"))
			.build();

	public static boolean checkAccessUrlByRole(String role, String url) {
		Set<String> urls = mapUrl.get(role);
		return urls.contains(url);
	}
}
