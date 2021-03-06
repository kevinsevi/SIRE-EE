/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sire.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pestupinan
 */
@Entity
@Table(name = "COM_VISITA_CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComVisitaCliente.findAll", query = "SELECT c FROM ComVisitaCliente c")
    , @NamedQuery(name = "ComVisitaCliente.findByCodEmpresa", query = "SELECT c FROM ComVisitaCliente c WHERE c.comVisitaClientePK.codEmpresa = :codEmpresa")
    , @NamedQuery(name = "ComVisitaCliente.findByCodDocumento", query = "SELECT c FROM ComVisitaCliente c WHERE c.comVisitaClientePK.codDocumento = :codDocumento")
    , @NamedQuery(name = "ComVisitaCliente.findByNumVisita", query = "SELECT c FROM ComVisitaCliente c WHERE c.comVisitaClientePK.numVisita = :numVisita")
    , @NamedQuery(name = "ComVisitaCliente.findByFechaVisita", query = "SELECT c FROM ComVisitaCliente c WHERE c.fechaVisita = :fechaVisita")
    , @NamedQuery(name = "ComVisitaCliente.findByCodCliente", query = "SELECT c FROM ComVisitaCliente c WHERE c.codCliente = :codCliente")
    , @NamedQuery(name = "ComVisitaCliente.findByDescCliente", query = "SELECT c FROM ComVisitaCliente c WHERE c.descCliente = :descCliente")
    , @NamedQuery(name = "ComVisitaCliente.findByObservacion", query = "SELECT c FROM ComVisitaCliente c WHERE c.observacion = :observacion")
    , @NamedQuery(name = "ComVisitaCliente.findByEstado", query = "SELECT c FROM ComVisitaCliente c WHERE c.estado = :estado")
    , @NamedQuery(name = "ComVisitaCliente.findByFechaEstado", query = "SELECT c FROM ComVisitaCliente c WHERE c.fechaEstado = :fechaEstado")})
public class ComVisitaCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComVisitaClientePK comVisitaClientePK;
    @Column(name = "FECHA_VISITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisita;
    @Size(max = 20)
    @Column(name = "COD_CLIENTE")
    private String codCliente;
    @Size(max = 200)
    @Column(name = "DESC_CLIENTE")
    private String descCliente;
    @Size(max = 400)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "FECHA_ESTADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEstado;
    @JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GnrEmpresa gnrEmpresa;
    @JoinColumns({
        @JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false)
        , @JoinColumn(name = "COD_CLIENTE", referencedColumnName = "COD_CLIENTE", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CxcCliente cxcCliente;
    @JoinColumns({
        @JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false)
        , @JoinColumn(name = "COD_VENDEDOR", referencedColumnName = "COD_VENDEDOR")})
    @ManyToOne(optional = false)
    private FacVendedor facVendedor;
    @JoinColumn(name = "NOMBRE_USUARIO", referencedColumnName = "NOMBRE_USUARIO")
    @ManyToOne
    private GnrUsuarios nombreUsuario;
    @Transient
    private GnrLogHistorico gnrLogHistorico;

    public ComVisitaCliente() {
    }

    public ComVisitaCliente(ComVisitaClientePK comVisitaClientePK) {
        this.comVisitaClientePK = comVisitaClientePK;
    }

    public ComVisitaCliente(String codEmpresa, String codDocumento, int numVisita) {
        this.comVisitaClientePK = new ComVisitaClientePK(codEmpresa, codDocumento, numVisita);
    }

    public ComVisitaClientePK getComVisitaClientePK() {
        return comVisitaClientePK;
    }

    public void setComVisitaClientePK(ComVisitaClientePK comVisitaClientePK) {
        this.comVisitaClientePK = comVisitaClientePK;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getDescCliente() {
        return descCliente;
    }

    public void setDescCliente(String descCliente) {
        this.descCliente = descCliente;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(Date fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

    public GnrEmpresa getGnrEmpresa() {
        return gnrEmpresa;
    }

    public void setGnrEmpresa(GnrEmpresa gnrEmpresa) {
        this.gnrEmpresa = gnrEmpresa;
    }

    public CxcCliente getCxcCliente() {
        return cxcCliente;
    }

    public void setCxcCliente(CxcCliente cxcCliente) {
        this.cxcCliente = cxcCliente;
    }

    public FacVendedor getFacVendedor() {
        return facVendedor;
    }

    public void setFacVendedor(FacVendedor facVendedor) {
        this.facVendedor = facVendedor;
    }

    public GnrUsuarios getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(GnrUsuarios nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public GnrLogHistorico getGnrLogHistorico() {
        return gnrLogHistorico;
    }

    public void setGnrLogHistorico(GnrLogHistorico gnrLogHistorico) {
        this.gnrLogHistorico = gnrLogHistorico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comVisitaClientePK != null ? comVisitaClientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComVisitaCliente)) {
            return false;
        }
        ComVisitaCliente other = (ComVisitaCliente) object;
        if ((this.comVisitaClientePK == null && other.comVisitaClientePK != null) || (this.comVisitaClientePK != null && !this.comVisitaClientePK.equals(other.comVisitaClientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sire.entities.ComVisitaCliente[ comVisitaClientePK=" + comVisitaClientePK + " ]";
    }

}
