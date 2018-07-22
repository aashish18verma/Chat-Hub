package com.niit.collaboration.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.springframework.stereotype.Component;
@Entity
@Table(name="C_Multimedia")
@Component
public class UserMultimedia
{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int multimediaID=0;
	
	
	public int getMultimediaID() {
		return multimediaID;
	}
	public void setMultimediaID(int multimediaID) {
		this.multimediaID = multimediaID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getUsyerAudio() {
		return usyerAudio;
	}
	public void setUsyerAudio(String usyerAudio) {
		this.usyerAudio = usyerAudio;
	}
	public String getUserVideo() {
		return userVideo;
	}
	public void setUserVideo(String userVideo) {
		this.userVideo = userVideo;
	}
	public String getUserMultimediaTranDate() {
		return UserMultimediaTranDate;
	}
	public void setUserMultimediaTranDate(String userMultimediaTranDate) {
		UserMultimediaTranDate = userMultimediaTranDate;
	}
	public String getUserMultimediaTranTime() {
		return UserMultimediaTranTime;
	}
	public void setUserMultimediaTranTime(String userMultimediaTranTime) {
		UserMultimediaTranTime = userMultimediaTranTime;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "userEmail")
	  private User user;
	
	
	String userImage;
	String usyerAudio;
	String userVideo;
	String UserMultimediaTranDate;
	String UserMultimediaTranTime;
	
	byte []userImageData;
	public byte[] getUserImageData() {
		return userImageData;
	}
	public void setUserImageData(byte[] userImageData) {
		this.userImageData = userImageData;
	}
	public byte[] getUsyerAudioData() {
		return usyerAudioData;
	}
	public void setUsyerAudioData(byte[] usyerAudioData) {
		this.usyerAudioData = usyerAudioData;
	}
	public byte[] getUserVideoData() {
		return userVideoData;
	}
	public void setUserVideoData(byte[] userVideoData) {
		this.userVideoData = userVideoData;
	}
	byte []usyerAudioData;
	byte []userVideoData;
	
	
	
	
	
	
	
	

}
