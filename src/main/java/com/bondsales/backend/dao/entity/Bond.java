package com.bondsales.backend.dao.entity;

import java.io.Serializable;

public class Bond implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BOND.bondID
     *
     * @mbggenerated
     */
    private Integer bondid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BOND.bondName
     *
     * @mbggenerated
     */
    private String bondname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BOND
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BOND.bondID
     *
     * @return the value of BOND.bondID
     *
     * @mbggenerated
     */
    public Integer getBondid() {
        return bondid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BOND.bondID
     *
     * @param bondid the value for BOND.bondID
     *
     * @mbggenerated
     */
    public void setBondid(Integer bondid) {
        this.bondid = bondid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BOND.bondName
     *
     * @return the value of BOND.bondName
     *
     * @mbggenerated
     */
    public String getBondname() {
        return bondname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BOND.bondName
     *
     * @param bondname the value for BOND.bondName
     *
     * @mbggenerated
     */
    public void setBondname(String bondname) {
        this.bondname = bondname == null ? null : bondname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOND
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bondid=").append(bondid);
        sb.append(", bondname=").append(bondname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}