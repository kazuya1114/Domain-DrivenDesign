package infrastructure;

import domain.model.AdditionElement;
import domain.model.AdditionFormula;
import domain.model.User;
import domain.repository.UserRepository;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UserRepositoryImpl implements UserRepository {
  @Override
  public void save(User user) throws Exception {
    String filename = user.getName() + ".csv";
    try(FileWriter fw = new FileWriter(filename)) {
      for(AdditionFormula formula : user.getHistory()) {
        String[] arr {
          String.valueOf(formula.getElement1Value()),
          String.valueOf(formula.getElement2Value()),
          String.valueOf(formula.getResultValue())
        };
        String csv = String.join(",", arr);
        fw.write(csv + "\n);
      }
    }catch(IOException e) {
      throw new Exception(e);
    }
  }
  
  @Override
  public User find(String name) throws Exception {
    User user = new User(name);
    File file = new File("./" + name + ".csv");
    if(file.exists()) {
      try {
        List<List<String>> records = readCsvFile(file);
        addHistoryTo(user, records);
      }catch(IOException e) {
        throw new Exception(e);
      }
    }
    
    return user;
  }
  
  private List<List<String>> readCsvFile(File file) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(file));
    List<List<String>> records = new ArrayList<>();
    String line;
    StringTokenizer token;
    while(line = br.readLine() != null) {
      List<String> record = new ArrayList<>();
      token = new StringTokenizer(line, ",");
      while(token.hasMoreTokens()) {
        record.add(token.nextToken());
      }
    }
    br.close();
    return records;
  }
  
  private void addHistoryTo(User user, List<List<String>> records) {
    records.forEach(record -> {
      user.addHistory(
        new AdditionElement(Integer.parseInt(record.get(0))),
        new AdditionElement(Integer.parseInt(record.get(1))),
        new AdditionElement(Integer.parseInt(record.get(2)))
      );
    });
  }
}
