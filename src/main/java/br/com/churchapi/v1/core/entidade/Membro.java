package br.com.churchapi.v1.core.entidade;

import br.com.churchapi.v1.core.enums.ConversorStatus;
import br.com.churchapi.v1.core.enums.StatusMembro;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_membros")
public class Membro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MEMBRO")
    private Integer id;

    @Column(name = "NO_MEMBRO")
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String telefone;

    @Column(name = "ST_MEMBRO")
    @Convert(converter = ConversorStatus.class)
    private StatusMembro status;

    @ManyToOne
    @JoinColumn(name = "ID_IGREJA")
    private Igreja igreja;

    public Membro() {
        this(null,null,null,null,null,null);
    }

    public Membro(Integer id, String nome, String email, String telefone, StatusMembro status, Igreja igreja) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.status = status;
        this.igreja = igreja;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public StatusMembro getStatus() {
        return status;
    }

    public void setStatus(StatusMembro status) {
        this.status = status;
    }

    public Igreja getIgreja() {
        return igreja;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membro membro = (Membro) o;
        return Objects.equals(id, membro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Membro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", status=" + status +
                '}';
    }
}
