package org.sierou.pojo.caution;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sierou.pojo.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "TRAFFIC_CAUTION")
@Data
@EqualsAndHashCode(callSuper = false)
public class TrafficCaution implements Serializable{
    /**
     * PK
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 标题
     */
    @Column(name = "TITLE")
    private String title;

    /**
     * 排序
     */
    @Column(name = "SORT")
    private Integer sort;

    /**
     * 图片路径
     */
    @Column(name = "PIC_PATH")
    private String picPath;

    /**
     * 城市ID
     */
    @Column(name = "AREA_D")
    private Integer areaD;

    /**
     * 是否删除
     */
    @Column(name = "IS_DELETE")
    private String isDelete;

    /**
     * 添加人
     */
    @Column(name = "CREAT_USER_ID")
    private Integer creatUserId;

    /**
     * 添加时间
     */
    @Column(name = "CREAT_TIME")
    private String creatTime;

    /**
     * 修改人
     */
    @Column(name = "EDIT_USER_ID")
    private Integer editUserId;

    /**
     * 修改时间
     */
    @Column(name = "EDIT_TIME")
    private String editTime;

    /**
     * 内容
     */
    @Column(name = "CONTENT")
    private String content;


}
