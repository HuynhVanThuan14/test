/**
 * 
 */
package springmvc.dao;

import java.util.List;

import springmvc.model.UserInfo;

/**
 * @author Admin
 *
 */
public interface LoginDao {
	public UserInfo findUser(String username);
	
	public List<String> getUserRoles(String username);
}
