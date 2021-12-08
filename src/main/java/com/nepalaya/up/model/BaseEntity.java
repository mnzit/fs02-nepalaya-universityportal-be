package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity<T extends User> implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = true)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;

    @Basic(optional = true)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_DATE",insertable = false)
    private Date modifiedDate;

    @Basic(optional = true)
    @CreatedBy
    @JoinColumn(name = "CREATED_BY", referencedColumnName = "ID", updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private T createdBy;

    @Basic(optional = true)
    @LastModifiedBy
    @JoinColumn(name = "MODIFIED_BY", referencedColumnName = "ID", insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private T modifiedBy;

    @Basic(optional = true)
    @Column(name = "STATUS", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean status;
}