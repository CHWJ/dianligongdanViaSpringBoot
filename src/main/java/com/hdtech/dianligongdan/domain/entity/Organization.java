package com.hdtech.dianligongdan.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "dianli_organization")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Organization extends BaseEntity implements Serializable {
    @Id
    public int id;

    public String name;
    @Column(name = "parent_id")
    public int parentId;
    public String fullpath;
    public String description;

    @Enumerated(EnumType.STRING)
    public IsAccepter isAccepter;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime created;
}

enum IsAccepter {
    n, y
}
