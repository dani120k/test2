package com.test2.test2.model;

import javax.persistence.*;

@Entity
@Table(name = "cexorder")
public class CexOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productid;

    private Long cexid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Long getCexid() {
        return cexid;
    }

    public void setCexid(Long cexid) {
        this.cexid = cexid;
    }
}
