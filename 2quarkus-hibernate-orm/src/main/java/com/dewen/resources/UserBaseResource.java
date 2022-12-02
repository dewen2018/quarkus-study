// package com.dewen.resources;
//
// import com.dewen.entity.UserBaseEntity;
// import com.dewen.repository.UserBaseRepository;
// import io.smallrye.mutiny.Uni;
//
// import javax.inject.Inject;
// import javax.transaction.Transactional;
// import javax.ws.rs.*;
// import javax.ws.rs.core.MediaType;
//
// /**
//  * 用户基本信息 Resource
//  */
// @Path("/user")
// @Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
// public class UserBaseResource {
//
//     @Inject
//     UserBaseRepository userBaseRepository;
//
//     @GET
//     @Path("/{id}")
//     public Uni<UserBaseEntity> getOne(@PathParam("id") Long id) {
//         return userBaseRepository.findById(id);
//     }
//
//     @POST
//     @Transactional
//     public Boolean create(UserBaseEntity userBase) {
//         if (userBase.id != null) {
//             throw new WebApplicationException("Id was invalidly set on request.", 422);
//         }
//         userBaseRepository.persist(userBase);
//         return Boolean.TRUE;
//     }
//
//     // @PUT
//     // @Transactional
//     // public UserBaseEntity update(UserBaseEntity userBase) {
//     //     if (userBase.id == null) {
//     //         throw new WebApplicationException("Id was invalidly set on request.", 422);
//     //     }
//     //
//     //     Uni<UserBaseEntity> entity = userBaseRepository.findById(userBase.id);
//     //
//     //     if (entity == null) {
//     //         throw new WebApplicationException("UserInfo with id of " + userBaseEntity.id + " does not exist.", 404);
//     //     }
//     //
//     //     entity.name = userBase.name;
//     //     entity.age = userBase.age;
//     //     return entity;
//     // }
//     //
//     // @DELETE
//     // @Path("{id}")
//     // @Transactional
//     // public Boolean delete(@PathParam("id") Long id) {
//     //     UserBaseEntity entity = userBaseRepository.findById(id);
//     //     if (entity == null) {
//     //         throw new WebApplicationException("UserInfo with id of " + id + " does not exist.", 404);
//     //     }
//     //     userBaseRepository.deleteById(id);
//     //     return Boolean.TRUE;
//     // }
// }
