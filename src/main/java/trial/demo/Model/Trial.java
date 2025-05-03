package trial.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Trial {

@Id
private long id;
private String column1;
private String column2;


}
