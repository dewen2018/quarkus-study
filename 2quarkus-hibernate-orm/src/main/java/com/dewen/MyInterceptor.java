// package com.dewen;
//
// import io.quarkus.hibernate.orm.PersistenceUnitExtension;
// import org.hibernate.EmptyInterceptor;
// import org.hibernate.type.Type;
//
// import java.io.Serializable;
//
// @PersistenceUnitExtension
// public class MyInterceptor extends EmptyInterceptor {
//     @Override
//     public boolean onLoad(Object entity, Serializable id, Object[] state,
//                           String[] propertyNames, Type[] types) {
//         // ...
//         return false;
//     }
// }