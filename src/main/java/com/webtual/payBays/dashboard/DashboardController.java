/**
 * <p>Project: payBays </p>
 * <p>Package Name: com.webtual.payBays.dashboard </p>
 * <p>File Name: DashboardController.java</p>
 * <p>Create Date: Nov 12, 2017 </p>
 * <p>Create Time: 12:50:14 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package com.webtual.payBays.dashboard;

import static com.webtual.payBays.misc.PayBaysProperties.*;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.webtual.payBays.misc.PayBaysProperties;
import com.webtual.payBays.news.RSSFeedData;
import com.webtual.payBays.news.RssFeedService;
import com.webtual.payBays.user.UserData;


@Controller
public class DashboardController {
	
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@RequestMapping( value="Login", method = RequestMethod.POST)
    public ModelAndView login(UserData user, BindingResult result, Map model, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("dashboard/dashboard");
		try {						
			user.setUserDomain(PayBaysProperties.DOMAIN);
			session.setAttribute("user", user);
			
			modelAndView.addObject("messageData", user);
			
			RssFeedService toiFeedService =new RssFeedService();
			modelAndView.addObject("toiDataList", toiFeedService.topFeed(PAYBAYS_TOI_URL,5));
			
			RssFeedService bbcFeedService =new RssFeedService();
			modelAndView.addObject("bbcDataList", bbcFeedService.topFeed(PAYBAYS_BBC_URL,5));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
    }
	
	@RequestMapping( value="FacebookFeed")
	public @ResponseBody String showFacebookFeed(@RequestParam(value = "userId") String userId, HttpServletRequest request,HttpSession session) {
		//FBService fbService = new FBService();
		//FBData fbData = fbService.getFBData();
		//return fbData.getUserFeed();
		return "shandar as the fb post";
    }

	
	@RequestMapping( value="LinkedinFeed")
	public @ResponseBody String showLinkedinFeed(@RequestParam(value = "userId") String userId, HttpServletRequest request,HttpSession session) {
		//LinkedinService linkedinService = new LinkedinService();
		//LinkedinData linkedinData = linkedinService.getLinkedinData();
		//return linkedinData.getUserFeed();
		return "shandar as the linkedin post";
    }
	
	@RequestMapping( value="TOIFeed")
	public @ResponseBody String showTOIFeed(@RequestParam(value = "titleAsId") String titleString, HttpServletRequest request,HttpSession session) {
		System.out.println("Shandar titleString ="+titleString);
		String retStr="";
		RssFeedService rssFeedService =new RssFeedService();
		List<RSSFeedData> rssFeedDataList =rssFeedService.topFeed(PAYBAYS_TOI_URL,5);
		for (RSSFeedData rssFeedData : rssFeedDataList) {
			if(rssFeedData.getTitle().equalsIgnoreCase(titleString)){
				retStr=rssFeedData.getNewsDescription();
				break;
			}
		}
		System.out.println("Shandar retStr ="+retStr);
		return retStr;
    }
	
	@RequestMapping( value="BBCFeed")
	public @ResponseBody String showBBCFeed(@RequestParam(value = "titleAsId") String titleString, HttpServletRequest request,HttpSession session) {
		String retStr="";
		RssFeedService rssFeedService =new RssFeedService();
		List<RSSFeedData> rssFeedDataList =rssFeedService.topFeed(PAYBAYS_BBC_URL,5);
		for (RSSFeedData rssFeedData : rssFeedDataList) {
			if(rssFeedData.getTitle().equalsIgnoreCase(titleString)){
				retStr=rssFeedData.getNewsDescription();
				break;
			}
		}
		System.out.println("Shandar retStr ="+retStr);
		return retStr;
    }
	
}
