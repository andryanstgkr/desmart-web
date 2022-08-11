package com.andryanstgkr.desmartweb.controller;

import java.util.LinkedHashMap;
import java.util.List;
import com.andryanstgkr.desmartweb.handler.PaginationHandler;
import com.andryanstgkr.desmartweb.handler.ResponseHandler;
import com.andryanstgkr.desmartweb.model.Resident;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("residents")
public class ResidentController {
   Logger logger = LoggerFactory.getLogger(MainController.class);


   @Autowired
   private RestTemplate restTemplate;

   @Value("${backend-api.url}")
   private String BACKEND_API_URL;

   @GetMapping("")
   public String getAllResidents(Model model) {
      ResponseEntity<LinkedHashMap<String, Object>> responseEntity =
            restTemplate.exchange(BACKEND_API_URL + "/resident/all", HttpMethod.GET, null,
                  new ParameterizedTypeReference<LinkedHashMap<String, Object>>() {});

      List<Resident> residents =
            (List<Resident>) (Object) ResponseHandler.handleResponseEntityList(responseEntity);
      logger.info("residents: " + residents);
      model.addAttribute("residents", residents);
      model.addAttribute("CONTENT_TITLE", "Dusun");
      model.addAttribute("LAYOUT_TITLE", "DeSmart");
      PaginationHandler.handlePaginationParam(model, responseEntity);
      return "resident/residents";
   }

   @GetMapping("/id={id}")
   public String getResidentDetailById(Model model, @PathVariable("id") String id) {
      ResponseEntity<LinkedHashMap<String, Object>> responseEntity =
            restTemplate.exchange(BACKEND_API_URL + "/resident/id/" + id, HttpMethod.GET, null,
                  new ParameterizedTypeReference<LinkedHashMap<String, Object>>() {});


      Object resident = (Object) ResponseHandler.handleResponseEntity(responseEntity);
      logger.debug("resident: " + resident);
      model.addAttribute("resident", resident);

      model.addAttribute("CONTENT_TITLE", "Dusun");
      model.addAttribute("LAYOUT_TITLE", "DeSmart");
      PaginationHandler.handlePaginationParam(model, responseEntity);
      return "resident/resident-detail";
   }

   @GetMapping("/id={id}")
   public String updateResident(Model model, Resident resident) {
      ResponseEntity<LinkedHashMap<String, Object>> responseEntity =
            restTemplate.exchange(BACKEND_API_URL + "/resident/id/" + id, HttpMethod.GET, null,
                  new ParameterizedTypeReference<LinkedHashMap<String, Object>>() {});


      Object resident = (Object) ResponseHandler.handleResponseEntity(responseEntity);
      logger.debug("resident: " + resident);
      model.addAttribute("resident", resident);

      model.addAttribute("CONTENT_TITLE", "Dusun");
      model.addAttribute("LAYOUT_TITLE", "DeSmart");
      PaginationHandler.handlePaginationParam(model, responseEntity);
      return "resident/resident-detail";
   }

   @GetMapping("/nik={nik}")
   public String getResidentDetailByNIK(Model model, @PathVariable("nik") String nik) {
      ResponseEntity<LinkedHashMap<String, Object>> responseEntity =
            restTemplate.exchange(BACKEND_API_URL + "/resident/nik/" + nik, HttpMethod.GET, null,
                  new ParameterizedTypeReference<LinkedHashMap<String, Object>>() {});


      Object resident = (Object) ResponseHandler.handleResponseEntity(responseEntity);
      logger.debug("resident: " + resident);
      model.addAttribute("resident", resident);

      model.addAttribute("CONTENT_TITLE", "Dusun");
      model.addAttribute("LAYOUT_TITLE", "DeSmart");
      PaginationHandler.handlePaginationParam(model, responseEntity);
      return "resident/resident-detail";
   }
}
