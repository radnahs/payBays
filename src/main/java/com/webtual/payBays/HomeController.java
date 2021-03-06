package com.webtual.payBays;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webtual.payBays.user.UserData;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)	
	public ModelAndView home(Locale locale, Model model) {
		Map<String, Object> modelMap = null;
		try {
			modelMap= new HashMap<String, Object>();
			
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			String formattedDate = dateFormat.format(date);
			modelMap.put("serverTime", formattedDate);
			UserData userData = new UserData();
			modelMap.put("user", userData);				
			
		} catch (Exception e) {
			logger.error("ERROR in home : ",e);
		}
		return new ModelAndView("home", modelMap);
	}
	
}
