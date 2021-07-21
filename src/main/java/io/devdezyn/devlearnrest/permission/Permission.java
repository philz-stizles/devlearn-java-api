package io.devdezyn.devlearnrest.permission;

import javax.persistence.*;

@Entity(name = "Permission")
@Table(
        name = "permission",
        uniqueConstraints = {
                @UniqueConstraint(name = "permission_name_unique", columnNames = "name")
        })
public class Permission {
    @Id
    @SequenceGenerator(
            name = "permission_sequence",
            sequenceName = "permission_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "permission_sequence"
    )
    private Long id;
    private String name;
    private String description;

    public Permission() {
    }

    public Permission(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Permission(String name, String description) {
        this.name = name;
        this.description = description;
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
