/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author damian
 */
@Entity
@Table(name = "users_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersCategory.findAll", query = "SELECT u FROM UsersCategory u"),
    @NamedQuery(name = "UsersCategory.findById", query = "SELECT u FROM UsersCategory u WHERE u.id = :id"),
    @NamedQuery(name = "UsersCategory.findByUserCategory", query = "SELECT u FROM UsersCategory u WHERE u.userCategory = :userCategory")})
public class UsersCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "user_category")
    private String userCategory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUserCategory")
    private Collection<Users> usersCollection;

    public UsersCategory() {
    }

    public UsersCategory(Integer id) {
        this.id = id;
    }

    public UsersCategory(Integer id, String userCategory) {
        this.id = id;
        this.userCategory = userCategory;
    }
    
    public UsersCategory(String userCategory) {
        this.userCategory = userCategory;
    }
           
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersCategory)) {
            return false;
        }
        UsersCategory other = (UsersCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.dbabinski.jdbc.entity.UsersCategory[ id=" + id + " ]";
    }
    
}
