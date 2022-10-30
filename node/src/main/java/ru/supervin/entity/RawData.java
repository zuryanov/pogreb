package ru.supervin.entity;

import lombok.*;
import org.hibernate.annotations.Type;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "raw_data")
public class RawData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Update event;
}
