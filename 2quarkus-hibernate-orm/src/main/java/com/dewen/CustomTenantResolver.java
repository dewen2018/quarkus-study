// package com.dewen;
//
// import io.quarkus.hibernate.orm.PersistenceUnitExtension;
// import io.quarkus.hibernate.orm.runtime.tenant.TenantResolver;
// import io.vertx.ext.web.RoutingContext;
//
// import javax.enterprise.context.RequestScoped;
// import javax.inject.Inject;
//
// @PersistenceUnitExtension
// @RequestScoped
// public class CustomTenantResolver implements TenantResolver {
//
//     @Inject
//     RoutingContext context;
//
//     @Override
//     public String getDefaultTenantId() {
//         return "base";
//     }
//
//     @Override
//     public String resolveTenantId() {
//         // String path = context.request().path();
//         // String[] parts = path.split("/");
//         //
//         // if (parts.length == 0) {
//         //     // resolve to default tenant config
//         //     return getDefaultTenantId();
//         // }
//         //
//         // return parts[1];
//
//         // OIDC TenantResolver has already calculated the tenant id and saved it as a RoutingContext `tenantId` attribute:
//         // return context.get("tenantId");
//     }
//
// }