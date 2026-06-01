package cl.dgac.licencia.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "licenciaPiloto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Licencia{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idLicencia")
    private int idLicencia;

    @Column(name="rutPiloto", nullable=false, length=12)
    private String rutPiloto;

    @Column(name="fechaVencimiento", nullable=false)
    private LocalDate fechaVen;

    @Column(name="estadoVigencia", nullable=false, length=20)
    private String estVigencia;
}
