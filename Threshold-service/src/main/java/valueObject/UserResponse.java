package valueObject;

import models.Threshold;

public class UserResponse{
	
	private Threshold threshold;
	private User user;
	

	public Threshold getThreshold() {
		return threshold;
	}

	public void setThreshold(Threshold threshold) {
		this.threshold = threshold;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}