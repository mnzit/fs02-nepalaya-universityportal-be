package com.nepalaya.up.model;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_SUBJECTS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.Cache(region = "student_subjects", usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class StudentSubject extends BaseEntity<User> {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID", referencedColumnName = "ID")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "PROGRAM_ID", referencedColumnName = "ID")
    private Program program;

    @Column(name = "SEMESTER")
    private Long semester;

}

