package com.moneysmart.repository;


import com.moneysmart.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class UserRepository {

    public static Map<String , User> userHashMap = new HashMap<>();
}
