package com.uca.capas.EjemploParcial.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "contribuyente")
public class Contribuyente {
	
	@Id
	@GeneratedValue(generator="contribuyente_c_contribuyente_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "contribuyente_c_contribuyente_seq", sequenceName = "public.contribuyente_c_contribuyente_seq", allocationSize = 1)
	@Column(name = "c_contribuyente")
	private Integer ccontribuyente;
	
	@Column(name = "s_nombre")
	private String snombre;
	
	@Column(name = "s_apellido")
	private String sapellido;
	
	@Column(name = "s_nit")
	private String snit;
	
	@NotNull(message = "El campo Fecha no puede quedar vacio")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "f_fecha_ingreso")
	private Date fingreso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "c_importancia")
	private Importancia importancia;
	
	@Transient
	private Integer cimportancia;
	
	public Contribuyente() {}

	public Integer getCcontribuyente() {
		return ccontribuyente;
	}

	public void setCcontribuyente(Integer ccontribuyente) {
		this.ccontribuyente = ccontribuyente;
	}

	public String getSnombre() {
		return snombre;
	}

	public void setSnombre(String snombre) {
		this.snombre = snombre;
	}

	public String getSapellido() {
		return sapellido;
	}

	public void setSapellido(String sapellido) {
		this.sapellido = sapellido;
	}

	public String getSnit() {
		return snit;
	}

	public void setSnit(String snit) {
		this.snit = snit;
	}

	public Date getFingreso() {
		return fingreso;
	}
	
	public String getFingresoDelegate() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(fingreso);
	}

	public void setFingreso(Date fingreso) {
		this.fingreso = fingreso;
	}

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}

	public Integer getCimportancia() {
		return cimportancia;
	}

	public void setCimportancia(Integer cimportancia) {
		this.cimportancia = cimportancia;
	}

}
