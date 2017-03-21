package codeInterview.google;

public class User {

	String userId;
	String email;
	String address;

	public User(String theUserId, String theAddress, String theEmail) {
		theUserId = userId;
		theEmail = email;
		theAddress = address;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		return ((User) obj).userId.equals(this.userId);
	}
	
	@Override
	public int hashCode() {	
		return 31  + (null == userId ? 0 : userId.hashCode());		
	}

}