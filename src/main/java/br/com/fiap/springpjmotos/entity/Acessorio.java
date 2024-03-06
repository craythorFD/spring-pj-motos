package br.com.fiap.springpjmotos.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.LinkedHashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACESSORIO")
    @SequenceGenerator(name = "SQ_ACESSORIO", sequenceName = "SQ_ACESSORIO", initialValue = 1, allocationSize = 50)
    @Column(name = "ID_ACESSORIO")
    private Long id;
    @Column(name = "NM_ACESSORIO")
    private String nome;
    @Column(name = "PRECO")
    private Double preco;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_VEICULO_ACESSORIO",
            joinColumns = {
                    @JoinColumn(
                            name = "ACESSORIO",
                            referencedColumnName = "ID_ACESSORIO",
                            foreignKey = @ForeignKey(name = "FK_ACESSORIO_VEICULO")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "VEICULO",
                            referencedColumnName = "ID_VEICULO",
                            foreignKey = @ForeignKey(name = "FK_VEICULO_ACESSORIO")
                    )
            }
    )
    private Set<Veiculo> acessorios = new LinkedHashSet<>();
}