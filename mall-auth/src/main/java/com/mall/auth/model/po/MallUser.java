package com.mall.auth.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author joker
 * @since 2023-02-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MallUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户账户唯一标识
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;

    private String email;

    private String sex;

    private String old;

    private Date createDate;

    private Date exchangeDate;


}
