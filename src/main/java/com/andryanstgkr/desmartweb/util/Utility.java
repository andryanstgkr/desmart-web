package com.andryanstgkr.desmartweb.util;

import org.springframework.beans.factory.annotation.Value;

public class Utility {
   @Value("${backend-api.url}")
   public static String BACKEND_API_URL;
}
