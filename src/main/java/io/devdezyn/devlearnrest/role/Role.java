package io.devdezyn.devlearnrest.role;

import javax.persistence.*;

@Entity(name = "Role")
@Table(
        name = "roles",
        uniqueConstraints = {
                @UniqueConstraint(name = "role_name_unique", columnNames = "name")
        })
public class Role {
    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_sequence"
    )
    private Long id;
    @Column(length = 60)
    private String name;
    private String description;

    public Role() {
    }

    public Role(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
