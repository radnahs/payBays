package com.webtual.payBays.socialMedia.fb;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;

public class FBServiceTest {
	
	public FBData getFBData(){
		FBData fbData = new FBData();
		return fbData;
	}

	public static void main(String[] args) {
		String accessToken="EAACEdEose0cBAGwoTrQM6LbdnsjRqngHErGZB8wNhOUZCGEpZBgV6Xsar5TmRGtrPrtsnYNTpDZBNVuGkE6E42KKZChfC2khZBCcpvhClh4LU0kv0beAqwoyUDtPAcruFlZBsdZBkV24Wn03teUSX5bOUMAmZCjd4eNbaj7PmEl7JZC6AxrMot7ujHTYIZCKNYdtURiwDobf8QtpQZDZD";
		FacebookClient fbClient = new DefaultFacebookClient(accessToken);
		//User userFB = fbClient.fetchObject("me/feed", User.class);
		User userFB = fbClient.fetchObject("me", User.class);
		System.out.println(userFB.getName());
		System.out.println(userFB.getBio());
		System.out.println(userFB.getWork());
		//FacebookType publishMessageResponse = fbClient.publish("me/feed", FacebookType.class, Parameter.with("message", "Friends please ignore these posts .... I'm testing my API ...."));
		//System.out.println(publishMessageResponse.getId());
		
		Connection<User> myFriends = fbClient.fetchConnection("me/friends", User.class);
	    Connection<Post> myFeed = fbClient.fetchConnection("me/feed", Post.class);

	    System.out.println("Count of my friends: " + myFriends.getData().size());

	    for (int i = 0; i < 5; i++) {
	    	if (!myFeed.getData().isEmpty())
		    	System.out.println(i + " item in my feed: " + myFeed.getData().get(i).getMessage());
		}
	    
	}
	
	//reading posts
	public static void main2(String[] args) {
		String accessToken="EAACEdEose0cBACtFj4yee4Pj9PRvAvTY9OJSueLqMZAp4wCZBPnlZA4ZALqXgg9HdIlKxMU4D5c1cFlbPiet7KQ3CcKbCWiQtUHd3ZCFfUUk6bc9hFnrhGlcAnQjQ1gkDvsZA2CYY86ZBkiL6nfCchhpz2wZBVamfMZCbIMR6rP1bQ9q85H8cqcbX2YtUJ1Ivj0QWzDWSZBJ6snwZDZD";
		FacebookClient fbClient = new DefaultFacebookClient(accessToken);
		/*User userFB = fbClient.fetchObject("me", User.class);
		System.out.println(userFB.getName());*/
	    User user = fbClient.fetchObject("me", User.class);
	    Page page = fbClient.fetchObject("cocacola", Page.class);

	    Connection<Post> myFeed = fbClient.fetchConnection("me/feed", Post.class);


	    System.out.println("User name: " + user.getName());
	    System.out.println("Page likes: " + page.getLikes());

		
	}
	
	void fetchObject() {
	    System.out.println("* Fetching single objects *");

	  }


}
