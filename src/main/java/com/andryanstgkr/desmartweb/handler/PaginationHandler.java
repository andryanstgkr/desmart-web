package com.andryanstgkr.desmartweb.handler;

import java.util.LinkedHashMap;
import com.andryanstgkr.desmartweb.constant.ResponseConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

public class PaginationHandler {
   public static void handlePaginationParam(Model model, ResponseEntity<LinkedHashMap<String, Object>> responseEntity) {
      model.addAttribute(ResponseConstant.CURRENT_PAGE, 1);
      model.addAttribute(ResponseConstant.PAGE_NUMBER, responseEntity.getBody().get(ResponseConstant.PAGE_NUMBER));
      model.addAttribute(ResponseConstant.TOTAL_PAGES, responseEntity.getBody().get(ResponseConstant.TOTAL_PAGES));
      model.addAttribute(ResponseConstant.TOTAL_RECORD, responseEntity.getBody().get(ResponseConstant.TOTAL_RECORD));
   }
}
