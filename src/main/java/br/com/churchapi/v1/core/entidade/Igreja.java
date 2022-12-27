package br.com.churchapi.v1.core.entidade;

import br.com.churchapi.v1.core.enums.ConversorStatusIgreja;
import br.com.churchapi.v1.core.enums.StatusIgreja;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_igreja")
public class Igreja implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_IGREJA")
    private Integer id;

    @Column(name = "NOME_FANTASIA")
    private String nomeFantasia;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "STATUS")
    @Convert(converter = ConversorStatusIgreja.class)
    private StatusIgreja status;

    public Igreja() {
        this(null,null,null,null,null);
    }

    public Igreja(Integer id, String nomeFantasia, String cnpj, String endereco,StatusIgreja status) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public StatusIgreja getStatus() {
        return status;
    }

    public void setStatus(StatusIgreja status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Igreja igreja = (Igreja) o;
        return Objects.equals(id, igreja.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Igreja{" +
                "id=" + id +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", endereco='" + endereco + '\'' +
                ", status=" + status +
                '}';
    }
}
