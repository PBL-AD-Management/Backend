package team2.PBL_AD_Manager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.domain.User;
import team2.PBL_AD_Manager.repository.UserRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRePository;

	public User findOne(Long id) {
		return userRePository.fincOne(id);
	}

	@Transactional
	public void save(User user) {
		userRePository.save(user);
	}

}
