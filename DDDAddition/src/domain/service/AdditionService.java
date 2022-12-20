package domain.service;

import domain.model.AdditionElement;
import domain.model.User;
import domain.repository.UserRepository;

public class AdditionService {
  private final UserRepository userRepository;
  
  public AdditionService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  public int execute(String username, int num1, int num2) throws Exception {
    try {
      final AdditionElement element1 = new AdditionElement(num1);
      final AdditionElement element2 = new AdditionElement(num2);
      final AdditionElement result = element1.plus(element2);
      final User user = this.userRepository.find(username);
      user.addHistory(element1, element2, result);
      this.userRepository.save(user);
      return result.getValue();
    }catch(Exception e) {
      throw new Exception(e);
    }
  }
}
