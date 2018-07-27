package br.com.neoholding.oi.garcom.config;

//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter
//{
//    private String RESOURCE_ID;
//
//    @Autowired
//    public ResourceServerConfig(@Value("${resource.id}") String RESOURCE_ID) {
//        this.RESOURCE_ID = RESOURCE_ID;
//    }
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) {
//        resources.resourceId(RESOURCE_ID).stateless(false);
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.
//                anonymous().disable()
//                .authorizeRequests()
//                .antMatchers("/users/**").access("hasRole('ADMIN')")
//                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
//    }
//}