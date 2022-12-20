package domain.repository;

import domain.model.User;

public interface UserRepository {
  void save(User user) throws Exception;
  User find(String username) throws Exception;
}
