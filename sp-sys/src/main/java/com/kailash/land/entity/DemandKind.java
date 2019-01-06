package com.kailash.land.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DemandKind implements Serializable{
    private Integer pkid;

    private Integer demandId;

    private Integer kind;

    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public Integer getDemandId() {
        return demandId;
    }

    public void setDemandId(Integer demandId) {
        this.demandId = demandId;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }
}