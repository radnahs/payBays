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
package com.webtual.payBays.socialMedia.fb;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Shantanu
 *
 */
@Entity
public class FBData {

	@Column(name="user_id")
	private String userId;

	@Column(name ="user_feed")
	private String userFeed;
	
	@Column(name ="user_feed_comments")
	private String userFeedComments;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserFeed() {
		return userFeed;
	}

	public void setUserFeed(String userFeed) {
		this.userFeed = userFeed;
	}

	public String getUserFeedComments() {
		return userFeedComments;
	}

	public void setUserFeedComments(String userFeedComments) {
		this.userFeedComments = userFeedComments;
	}
	
	
	
}
