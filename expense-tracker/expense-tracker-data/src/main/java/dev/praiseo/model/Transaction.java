package dev.praiseo.model;

import dev.praiseo.enums.TransactionCategory;
import dev.praiseo.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity(name = "Transaction")
@Table(name = "transaction")
@NoArgsConstructor
public class Transaction extends BaseEntity{
    private String title;
    private Double amount;
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "user_id",
                updatable = false,
                insertable = false)
    private User createdBy;
    private String description;
    private TransactionCategory transactionCategory;
    @CreationTimestamp
    private Date createdAt;

    /**
     * Constructor for a transaction
     * @param title
     * @param amount
     * @param transactionType
     */
    public Transaction(String title, Double amount, TransactionType transactionType) {
        this.title = title;
        this.amount = amount;
        this.transactionType = transactionType;
//        this.createdBy = createdBy;
    }

    @UpdateTimestamp
    private Date updatedAt;

    @Override
    public String toString() {
        return "Transaction{" +
                "title='" + title + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
