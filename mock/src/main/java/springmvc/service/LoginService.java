package springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springmvc.dao.LoginDao;
import springmvc.model.UserInfo;

@Service
public class LoginService implements UserDetailsService {
	LoginDao loginDao;
	
	@Autowired
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = loginDao.findUser(username);
		if(userInfo == null) {
			throw new UsernameNotFoundException("Không tìm thấy usernmame");
		}
		List<String> roles = loginDao.getUserRoles(username);
		List<GrantedAuthority> grandList = new ArrayList<GrantedAuthority>();
		if(roles != null) {
			for(String role : roles) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grandList.add(authority);
			}
		}
		
		UserDetails userDetail = new User(userInfo.getUsername(), userInfo.getPassword(), grandList);
		return userDetail;
	}

}
