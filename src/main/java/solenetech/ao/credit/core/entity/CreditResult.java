package solenetech.ao.credit.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import solenetech.ao.credit.core.enuns.ResultStatus;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "creditresults")
@Entity
public class CreditResult {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private ResultStatus status;
    private double score;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "creditrequest_id", unique = true)
    private CreditRequest creditRequest;
}
