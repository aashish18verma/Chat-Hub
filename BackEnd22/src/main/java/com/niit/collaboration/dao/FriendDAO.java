package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Friend;

public interface FriendDAO 
{

		public boolean addFriendList(Friend friend);
		public boolean sendFriendRequest(Friend friend);
		public boolean deleteFriendRequest(Friend friend);
		public boolean update_noncnf_to_cnf(Friend frind);
		
		
		public List <Friend> cnfFriendList(String friendType);
		
		public List <Friend> noncnfFriendList(String userEmail,String friendType);
		public List <Friend> cnfFriendList(String userEmail,String friendType);
		public List <Friend> requestedFriendList(String friendType);
		public List <Friend> allFriendList();
		
		
		
}



