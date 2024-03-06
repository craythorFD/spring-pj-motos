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
@Table(name = "TB_TIPO_VEICULO")
public class TipoVeiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_VEICULO")
    @SequenceGenerator(name = "SQ_TIPO_VEICULO", sequenceName = "SQ_TIPO_VEICULO", initialValue = 1, allocationSize = 50)
    @Column(name = "ID_TIPO_VEICULO")
    private Long id;
    @Column(name = "NM_TIPO_VEICULO")
    private String nome;
    @ManyToOne
    @JoinColumn(name = "VEICULO", referencedColumnName = "ID_VEICULO", foreignKey = @ForeignKey(name = "FK_TIPO_VEICULO_VEICULO"))
    private Veiculo tipo;
}