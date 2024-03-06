package br.com.fiap.springpjmotos.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_VEICULO")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VEICULO")
    @SequenceGenerator(name = "SQ_VEICULO", sequenceName = "SQ_VEICULO", initialValue = 1, allocationSize = 50)
    @Column(name = "ID_VEICULO")
    private Long id;
    @Column(name = "NM_VEICULO")
    private String nome;
    @Column(name = "COR")
    private String cor;
    @Column(name = "PRECO")
    private Double preco;
    @Column(name = "CILINDRADAS")
    private Short cilindradas;
}