/**
 * 债券数据库的映射
 */
package com.bondsales.backend.dao.mapper;

import com.bondsales.backend.dao.entity.Bond;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BondMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOND
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long bondid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOND
     *
     * @mbggenerated
     */
    int insert(Bond record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOND
     *
     * @mbggenerated
     */
    Bond selectByPrimaryKey(Long bondid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOND
     *
     * @mbggenerated
     */
    List<Bond> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOND
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Bond record);
}