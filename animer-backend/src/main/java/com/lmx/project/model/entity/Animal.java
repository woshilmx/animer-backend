package com.lmx.project.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

/**
 * 动物
 * @TableName animal
 */
@TableName(value ="animal")
@Data
public class Animal implements Serializable {
    /**
     * 动物编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 动物名称
     */
    private String name;

    /**
     * 分类编号
     */
    private Long categoryid;

    /**
     * 动物简介
     */
    private String introduction;

    /**
     * 图片
     */
    private String picture;

    /**
     * 濒危等级
     */
    private String endangeredlevel;

    /**
     * 形态描述
     */
    private String morphologydescription;

    /**
     * 生活习性
     */
    private String habit;

    /**
     * 生活地理环境
     */
    private String geographicalenvironment;

    /**
     * 分布范围
     */
    private String distributionrange;

    /**
     * 各界报道
     */
    private String report;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Animal other = (Animal) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCategoryid() == null ? other.getCategoryid() == null : this.getCategoryid().equals(other.getCategoryid()))
            && (this.getIntroduction() == null ? other.getIntroduction() == null : this.getIntroduction().equals(other.getIntroduction()))
            && (this.getPicture() == null ? other.getPicture() == null : this.getPicture().equals(other.getPicture()))
            && (this.getEndangeredlevel() == null ? other.getEndangeredlevel() == null : this.getEndangeredlevel().equals(other.getEndangeredlevel()))
            && (this.getMorphologydescription() == null ? other.getMorphologydescription() == null : this.getMorphologydescription().equals(other.getMorphologydescription()))
            && (this.getHabit() == null ? other.getHabit() == null : this.getHabit().equals(other.getHabit()))
            && (this.getGeographicalenvironment() == null ? other.getGeographicalenvironment() == null : this.getGeographicalenvironment().equals(other.getGeographicalenvironment()))
            && (this.getDistributionrange() == null ? other.getDistributionrange() == null : this.getDistributionrange().equals(other.getDistributionrange()))
            && (this.getReport() == null ? other.getReport() == null : this.getReport().equals(other.getReport()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getIsdelete() == null ? other.getIsdelete() == null : this.getIsdelete().equals(other.getIsdelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCategoryid() == null) ? 0 : getCategoryid().hashCode());
        result = prime * result + ((getIntroduction() == null) ? 0 : getIntroduction().hashCode());
        result = prime * result + ((getPicture() == null) ? 0 : getPicture().hashCode());
        result = prime * result + ((getEndangeredlevel() == null) ? 0 : getEndangeredlevel().hashCode());
        result = prime * result + ((getMorphologydescription() == null) ? 0 : getMorphologydescription().hashCode());
        result = prime * result + ((getHabit() == null) ? 0 : getHabit().hashCode());
        result = prime * result + ((getGeographicalenvironment() == null) ? 0 : getGeographicalenvironment().hashCode());
        result = prime * result + ((getDistributionrange() == null) ? 0 : getDistributionrange().hashCode());
        result = prime * result + ((getReport() == null) ? 0 : getReport().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getIsdelete() == null) ? 0 : getIsdelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", categoryid=").append(categoryid);
        sb.append(", introduction=").append(introduction);
        sb.append(", picture=").append(picture);
        sb.append(", endangeredlevel=").append(endangeredlevel);
        sb.append(", morphologydescription=").append(morphologydescription);
        sb.append(", habit=").append(habit);
        sb.append(", geographicalenvironment=").append(geographicalenvironment);
        sb.append(", distributionrange=").append(distributionrange);
        sb.append(", report=").append(report);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", isdelete=").append(isdelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}