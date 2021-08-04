package com.mar.empleados.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
    
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "gerentes", 
    joinColumns = @JoinColumn(name = "empleado_id"), 
    inverseJoinColumns = @JoinColumn(name = "gerente_id")
    )
    private List<Empleado> gerentes;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "gerentes", 
    joinColumns = @JoinColumn(name = "gerente_id"), 
    inverseJoinColumns = @JoinColumn(name = "empleado_id")
    )
    private List<Empleado> empleadoGerentes;
    
    public Empleado() {
        
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Empleado> getGerentes() {
		return gerentes;
	}

	public void setGerentes(List<Empleado> gerentes) {
		this.gerentes = gerentes;
	}

	public List<Empleado> getEmpleadoGerentes() {
		return empleadoGerentes;
	}

	public void setEmpleadoGerentes(List<Empleado> empleadoGerentes) {
		this.empleadoGerentes = empleadoGerentes;
	}       

}