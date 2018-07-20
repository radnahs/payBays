/**
 * <p>Project: payBays </p>
 * <p>Package Name: com.webtual.payBays.fb </p>
 * <p>File Name: FBService.java</p>
 * <p>Create Date: Nov 13, 2017 </p>
 * <p>Create Time: 12:50:14 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package com.webtual.payBays.socialMedia.fb;

import static com.webtual.payBays.misc.PayBaysProperties.*;

import java.util.ArrayList;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;

public class FBService {

	private String accessToken = FACEBOOK_ACCESS_TOKEN;
	//private String accessToken = "EAACEdEose0cBAFLZBZAZCkITgQgac4i2nPqdaoZBm6rK0VFDs6loLVA6A2f6jscnm1QkYZAV063GNmWPljbOAeepqAZCZAYD6zDGe9EthAVgEiCCp2DfUbHGg1zpv6YiCrXBRYMqbTlZCEJGhJnZBZBDyyBGJyVTPeksK7bMeqaRrhTY0q4WYZAbYffFJn3o8hDLnsUpMbYf4mwHQZDZD";
	private final FacebookClient facebookClient;
	
	public FBService() {
		facebookClient = new DefaultFacebookClient(accessToken);
	}
	
	public List<FBData> getFBFeed(){
	    Connection<Post> myFeed = facebookClient.fetchConnection("me/feed", Post.class);
	    Page page = facebookClient.fetchObject("cocacola", Page.class);

	    List<FBData> fbDataList = new ArrayList<>(); 
	    for (int i = 0; i < 5; i++) {
	    	if (!myFeed.getData().isEmpty()){
	    		FBData fbData = new FBData();
	    		//System.out.println(i + " item in my feed: " + myFeed.getData().get(i).getMessage());
		    	fbData.setUserFeed(myFeed.getData().get(i).getMessage());
		    	//fbData.setUserFeedComments(myFeed.getData().get(i).getComments());
		    	fbDataList.add(fbData);
	    	}
		}
	    return fbDataList;
	}
	
	public void postFeedToFB(String feedToPost){
		FacebookType publishMessageResponse = facebookClient.publish("me/feed", FacebookType.class, Parameter.with("message", feedToPost));
	}
	
	public static void main(String[] args) {
		FBService fbService = new FBService();
		List<FBData> fbDataList = fbService.getFBFeed();
		for (FBData fbData : fbDataList) {
			System.out.println(fbData.getUserFeed());
			//System.out.println(fbData.getUserFeedComments());
		}
	}

}
