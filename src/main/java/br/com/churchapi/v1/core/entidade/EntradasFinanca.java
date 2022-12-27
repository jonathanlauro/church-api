package br.com.churchapi.v1.core.entidade;

import br.com.churchapi.v1.core.enums.ConversorDeTipoEntrada;
import br.com.churchapi.v1.core.enums.TipoEntrada;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "ENTRADAS_FINANCA")
public class EntradasFinanca implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENTRADA")
    private Integer id;

    @Column(name = "VL_ENTRADA")
    private BigDecimal valor;

    @Column(name = "ORIGEM")
    private String origem;

    @Convert(converter = ConversorDeTipoEntrada.class)
    @Column(name = "TP_ENTRADA")
    private TipoEntrada tipoEntrada;

    @ManyToOne()
    @JoinColumn(name = "ID_IGREJA")
    private Igreja igreja;

    @Column(name = "DT_REGISTRO")
    private Date dataRegistro;

    public EntradasFinanca() {
        this(null,null,null,null,null,null);
    }

    public EntradasFinanca(Integer id, BigDecimal valor, String origem, TipoEntrada tipoEntrada, Igreja igreja, Date dataRegistro) {
        this.id = id;
        this.valor = valor;
        this.origem = origem;
        this.tipoEntrada = tipoEntrada;
        this.igreja = igreja;
        this.dataRegistro = dataRegistro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public Igreja getIgreja() {
        return igreja;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
