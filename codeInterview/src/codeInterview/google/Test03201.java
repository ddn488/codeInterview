package codeInterview.google;

import java.sql.Date;

import javax.sql.DataSource;

public class Test03201 {

}


/**
 * Imagine that your peer has asked you to review the code below. Please provide written feedback:
 *  What bugs do you see? What should your peer do instead?

DO NOT ATTEMPT TO FIX THE CODE YOURSELF. Instead try to find as many correctness/style/testability/security/structure etc. issues as you can in a reasonable time.

**/

/** Updates user records. */
//class UserRecordUpdater {
//  String database_address;
//
//  public UserRecordUpdater(String databaseAddress) {
//    database_address = databaseAddress;
//  }
//
//  /* Updates user record with new data provided by a user */
//  public void updateUser(String userId, String address, String email) {
//    DataSource database = new Date(database_address);
//    
//    User userX = database.getUserById(userId);
//    
//    User userY = new User(userId, email, address);{
//    	
//    }
//    
//    if (userX == userY) {
//      // Skipping the update if nothing has really changed.
//      return;
//    }
//    
//    updateUser2(userX);
//  }
//
//  public void updateUser2(User user) {
//    Database database = new Database(database_address);
//    String sql = "UPDATE User set email = '" + user.email + "' address = '" + user.address + 
//        "' where userId = '" + user.userId + "'";
//    database.executeSqlUpdate(sql);
//  }
//
//}
//
///** Represents a user from the database. */
//class User {
//  String userId; String email; String address;
//  public User(String theUserId, String theAddress, String theEmail) {
//    theUserId = userId;
//    theEmail = email;
//    theAddress = address;
//  }
//  
//  @Override
//	public boolean equals(Object obj) {
//		
//		return ((User) obj).userId = this.userId;
//	}
//  
//  @Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return super.hashCode();
//	}
//  
 
//}
