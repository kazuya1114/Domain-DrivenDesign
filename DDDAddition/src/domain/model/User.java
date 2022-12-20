package domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
  private final String name;
  private final List<AdditionFormula> history = new ArrayList<>();
  
  public User(String name) {
    this.name = name;
  }
  
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof User)) return false;
    User user = (User) o;
    return Objects.equals(this.name, user.name);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
  
  public String getName() {
    return this.name;
  }
  
  public List<AdditionFormula> getHistory() {
    return new ArrayList<>(this.history);
  }
  
  public void addHistory(AdditionElement element1, AdditionElement element2, AdditionElement result) {
    this.history.add(new AdditionFormula(element1, element2, result));
  }
}
