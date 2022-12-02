// package com.dewen.entity;
//
// import io.quarkus.hibernate.reactive.panache.PanacheEntity;
//
// import javax.persistence.*;
// import java.util.Date;
//
// /**
//  * 用户基本信息 Entity
//  */
// @Entity
// @Table(name = "t_user_base")
// public class UserBaseEntity extends PanacheEntity {
//
//     /**
//      * 主键
//      */
//     // @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     public Long id;
//
//     /**
//      * 姓名
//      */
//     public String name;
//
//     /**
//      * 年龄
//      */
//     public String age;
//
//     /**
//      * 创建时间
//      */
//     public Date createTime;
//
//
//     @Override
//     public String toString() {
//         return "UserBaseEntity{" +
//                 "id=" + id +
//                 ", name='" + name + '\'' +
//                 ", age='" + age + '\'' +
//                 ", createTime=" + createTime +
//                 '}';
//     }
// }
