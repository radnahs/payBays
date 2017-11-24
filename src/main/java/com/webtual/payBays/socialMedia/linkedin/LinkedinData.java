/**
 * <p>Project: payBays </p>
 * <p>Package Name: com.webtual.payBays.socialMedia.linkedin </p>
 * <p>File Name: LinkedinData.java</p>
 * <p>Create Date: Nov 12, 2017 </p>
 * <p>Create Time: 09:10:14 AM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package com.webtual.payBays.socialMedia.linkedin;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Shantanu
 *
 */
@Entity
public class LinkedinData {

	@Column(name="user_id")
	private String userId;

	@Column(name ="user_feed")
	private String userFeed;

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

}
