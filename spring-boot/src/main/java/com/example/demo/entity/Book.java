package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("book")
@Data
public class Book {
    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;

    private String bookName;

private double price;

private String  author;

private  Integer num;

}
