package com.demo.embedded.collection.basiccollection_embedded;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skills {
    @ElementCollection
    private List<String> languages;
    @ElementCollection
    private List<String> frameworks;

    // no-args constructor getters and setters
}
