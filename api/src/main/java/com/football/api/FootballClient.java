package com.football.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "", url="")
public interface FootballClient {
}
