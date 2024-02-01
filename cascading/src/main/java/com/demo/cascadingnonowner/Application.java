package com.demo.cascadingnonowner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    @Id
    @Column(name="APPLICATION_ID_PK")
    private long applicationIdPk;

    @Column(name="APPLICATION_NAME")
    private String applicationName;

    @OneToMany(mappedBy="application", cascade = CascadeType.PERSIST)
    private List<ApplicationTranslation> applicationTranslations;

    //no-arg constructor + getters + setters
}