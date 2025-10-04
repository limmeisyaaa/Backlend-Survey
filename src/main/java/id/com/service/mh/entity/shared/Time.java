package id.com.service.mh.entity.shared;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "time")
@Getter
@Setter
@NoArgsConstructor
public class Time {

    @Column(name = "time_id")
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String timeId;

    @Column(name = "time")
    private String time;

}