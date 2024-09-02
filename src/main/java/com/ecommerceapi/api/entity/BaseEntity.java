package com.ecommerceapi.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@MappedSuperclass
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    protected Long id;

    @Setter
    @NotNull
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @Setter
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    protected Instant createdAt;

    @Setter
    @UpdateTimestamp
    @Column(name = "updated_at")
    protected Instant updatedAt;

    @Setter
    @Column(name = "deleted_at")
    protected Instant deletedAt;

    public BaseEntity(@NotNull final Long id) {
        this.id = id;
    }
}
