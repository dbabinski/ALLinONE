/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XC
 */
@Entity
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findById", query = "SELECT p FROM Products p WHERE p.id = :id"),
    @NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Products p WHERE p.productName = :productName"),
    @NamedQuery(name = "Products.findByProductAutorName", query = "SELECT p FROM Products p WHERE p.productAutorName = :productAutorName"),
    @NamedQuery(name = "Products.findByProductAutorLastname", query = "SELECT p FROM Products p WHERE p.productAutorLastname = :productAutorLastname"),
    @NamedQuery(name = "Products.findByProductCountryName", query = "SELECT p FROM Products p WHERE p.productCountryName = :productCountryName"),
    @NamedQuery(name = "Products.findByProductCost", query = "SELECT p FROM Products p WHERE p.productCost = :productCost")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_autor_name")
    private String productAutorName;
    @Column(name = "product_autor_lastname")
    private String productAutorLastname;
    @Column(name = "product_country_name")
    private String productCountryName;
    @Column(name = "product_cost")
    private Integer productCost;
    @JoinColumn(name = "id_product_category", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductCategory idProductCategory;

    public Products() {
    }

    public Products(Integer id) {
        this.id = id;
    }
    
    public Products(Integer id, ProductCategory idProductCategory, String productName, String productAutorName, String productAutorLastname, String productCountryName, Integer productCost){
        this.id = id;
        this.idProductCategory = idProductCategory;
        this.productName = productName;
        this.productAutorName = productAutorName;
        this.productAutorLastname = productAutorLastname;
        this.productCountryName = productCountryName;
        this.productCost = productCost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductAutorName() {
        return productAutorName;
    }

    public void setProductAutorName(String productAutorName) {
        this.productAutorName = productAutorName;
    }

    public String getProductAutorLastname() {
        return productAutorLastname;
    }

    public void setProductAutorLastname(String productAutorLastname) {
        this.productAutorLastname = productAutorLastname;
    }

    public String getProductCountryName() {
        return productCountryName;
    }

    public void setProductCountryName(String productCountryName) {
        this.productCountryName = productCountryName;
    }

    public Integer getProductCost() {
        return productCost;
    }

    public void setProductCost(Integer productCost) {
        this.productCost = productCost;
    }

    public ProductCategory getIdProductCategory() {
        return idProductCategory;
    }

    public void setIdProductCategory(ProductCategory idProductCategory) {
        this.idProductCategory = idProductCategory;
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
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.softmedica.jdbc.jpa.Products[ id=" + id + " ]";
    }
    
}
