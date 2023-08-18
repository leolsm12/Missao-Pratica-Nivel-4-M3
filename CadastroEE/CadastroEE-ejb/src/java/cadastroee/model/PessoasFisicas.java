/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroee.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author leosc
 */
@Entity
@Table(name = "PessoasFisicas")
@NamedQueries({
    @NamedQuery(name = "PessoasFisicas.findAll", query = "SELECT p FROM PessoasFisicas p"),
    @NamedQuery(name = "PessoasFisicas.findByIdPFisica", query = "SELECT p FROM PessoasFisicas p WHERE p.idPFisica = :idPFisica"),
    @NamedQuery(name = "PessoasFisicas.findByCpf", query = "SELECT p FROM PessoasFisicas p WHERE p.cpf = :cpf")})
public class PessoasFisicas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPFisica")
    private Integer idPFisica;
    @Column(name = "cpf")
    private String cpf;
    @JoinColumn(name = "idPFisica", referencedColumnName = "idPessoa", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pessoas pessoas;

    public PessoasFisicas() {
    }

    public PessoasFisicas(Integer idPFisica) {
        this.idPFisica = idPFisica;
    }

    public Integer getIdPFisica() {
        return idPFisica;
    }

    public void setIdPFisica(Integer idPFisica) {
        this.idPFisica = idPFisica;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pessoas getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoas pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPFisica != null ? idPFisica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoasFisicas)) {
            return false;
        }
        PessoasFisicas other = (PessoasFisicas) object;
        if ((this.idPFisica == null && other.idPFisica != null) || (this.idPFisica != null && !this.idPFisica.equals(other.idPFisica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.PessoasFisicas[ idPFisica=" + idPFisica + " ]";
    }
    
}
