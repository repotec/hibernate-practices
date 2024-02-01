package com.demo.cascadingnonowner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "application_translations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationTranslation {
    @Id
    @Column(name="APPLICATION_TRANSLATION_ID")
    private long applicationTranslationId;

    @Column(name="APPLICATION_DISPLAY_NAME")
    private String applicationDisplayName;

    @ManyToOne
    @JoinColumn(name = "application_id_fk")
    private Application application;

    //no-arg constructor + getters + setters
}
