package ubb.barcoaie.server.core.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vegetable extends BaseEntity<Long> {
    @Column(length = 20)
    private int onServer;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private int price;
}
