package com.andryanstgkr.desmartweb.controller;

import java.util.LinkedHashMap;
import java.util.List;
import com.andryanstgkr.desmartweb.constant.PageConstant;
import com.andryanstgkr.desmartweb.constant.ResponseConstant;
import com.andryanstgkr.desmartweb.handler.PaginationHandler;
import com.andryanstgkr.desmartweb.handler.ResponseHandler;
import com.andryanstgkr.desmartweb.model.SubVillage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {

   Logger logger = LoggerFactory.getLogger(MainController.class);

   @Autowired
   private ReloadableResourceBundleMessageSource messageSource;

   @Value("${placeholder.greetings}")
   private String greetings;

   @Autowired
   private RestTemplate restTemplate;

   @Value("${backend-api.url}")
   private String BACKEND_API_URL;

   @SuppressWarnings("unchecked")
   @GetMapping(value = "/")
   public String index(Model model) {
      logger.info("Test");
      ResponseEntity<LinkedHashMap<String, Object>> responseEntity =
            restTemplate.exchange("http://localhost:1991/api/subvillage/all", HttpMethod.GET, null,
                  new ParameterizedTypeReference<LinkedHashMap<String, Object>>() {});
      model.addAttribute("header", "Berkunjung ke Samosir");
      List<SubVillage> subVillages =
            (List<SubVillage>) (Object) ResponseHandler.handleResponseEntityList(responseEntity);
      logger.info(subVillages.toString());
      model.addAttribute("subVillages", subVillages);
      return "template";
   }

   @GetMapping(value = "/villages")
   @SuppressWarnings("unchecked")
   public String getAllVillages(Model model) {

      ResponseEntity<LinkedHashMap<String, Object>> responseEntity = restTemplate.exchange(BACKEND_API_URL + "/subvillage/all", HttpMethod.GET, null,
                  new ParameterizedTypeReference<LinkedHashMap<String, Object>>() {});

      List<SubVillage> subVillages = (List<SubVillage>) (Object) ResponseHandler.handleResponseEntityList(responseEntity);

      model.addAttribute("subVillages", subVillages);
      model.addAttribute("CONTENT_TITLE", "Dusun");
      model.addAttribute("LAYOUT_TITLE", "DeSmart");
      PaginationHandler.handlePaginationParam(model, responseEntity);
      return "subvillages";
   }

   @PostMapping(value = "/village/confirm")
   public String confirmNewVillage(Model model,
         @ModelAttribute("subVillage") SubVillage subVillage) {
      logger.info("Village: " + subVillage.toString());


      ResponseEntity<LinkedHashMap<String, Object>> responseEntity = restTemplate.exchange(
            BACKEND_API_URL + "/admin/district/id/" + subVillage, HttpMethod.GET, null,
            new ParameterizedTypeReference<LinkedHashMap<String, Object>>() {});

      ObjectMapper mapper = new ObjectMapper();
      mapper.findAndRegisterModules();
      SubVillage _subVillage = mapper
            .convertValue(responseEntity.getBody().get(ResponseConstant.DATA), SubVillage.class);

      model.addAttribute("CONTENT_TITLE", "Merdeka");
      model.addAttribute("LAYOUT_TITLE", "Merdeka");
      model.addAttribute("subVillage", _subVillage);

      return PageConstant.SUB_VILLAGE_CONFIRM;
   }


}
