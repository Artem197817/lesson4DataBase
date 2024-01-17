import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Courses {

    @Id
    @GeneratedValue
    private int id;
    private  String title;
    private int duration;

    public Courses(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }
}
