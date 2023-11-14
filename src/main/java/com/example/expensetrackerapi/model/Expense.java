package com.example.expensetrackerapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
//import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_expenses")
public class Expense {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name = "expense_name")
@NotNull(message = "Expense name must not be null")
@Size(min = 3,message = "At least 3 characters required")
private String name;

private String description;
@Column(name = "expense_amount")
private BigDecimal amount;
private String category;

private Date date;
@Column(name = "created_at",nullable = false,updatable = false)
@CreationTimestamp
private LocalDateTime createdAt;
@UpdateTimestamp
@Column(name = "updated_at")
private LocalDateTime updatedAt;

}
