package br.com.neoholding.oi.garcom.config;

//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//    private String CLIENT_ID;
//    private String CLIENT_SECRET;
//    private String GRANT_TYPE_PASSWORD;
//    private String AUTHORIZATION_CODE;
//    private String REFRESH_TOKEN;
//    private String IMPLICIT;
//    private String SCOPE_READ;
//    private String SCOPE_WRITE;
//    private String TRUST;
//    private int ACCESS_TOKEN_VALIDITY_SECONDS;
//    private int REFRESH_TOKEN_VALIDITY_SECONDS;
//    private String JWT_SIGNING_KEY;
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    public AuthorizationServerConfig(@Value("${client.id}") String CLIENT_ID,
//                                     @Value("${client.secret}") String CLIENT_SECRET,
//                                     @Value("${grant.type.password}") String GRANT_TYPE_PASSWORD,
//                                     @Value("${authorization.code}") String AUTHORIZATION_CODE,
//                                     @Value("${refresh.token}") String REFRESH_TOKEN,
//                                     @Value("${implicit}") String IMPLICIT,
//                                     @Value("${scope.read}") String SCOPE_READ,
//                                     @Value("${scope.write}") String SCOPE_WRITE,
//                                     @Value("${trust}") String TRUST,
//                                     @Value("${access.token.validity.seconds}") int ACCESS_TOKEN_VALIDITY_SECONDS,
//                                     @Value("${refresh.token.validity.seconds}") int REFRESH_TOKEN_VALIDITY_SECONDS,
//                                     @Value("${jwt.signing.key}") String JWT_SIGNING_KEY,
//                                     AuthenticationManager authenticationManager) {
//        this.CLIENT_ID = CLIENT_ID;
//        this.CLIENT_SECRET = CLIENT_SECRET;
//        this.GRANT_TYPE_PASSWORD = GRANT_TYPE_PASSWORD;
//        this.AUTHORIZATION_CODE = AUTHORIZATION_CODE;
//        this.REFRESH_TOKEN = REFRESH_TOKEN;
//        this.IMPLICIT = IMPLICIT;
//        this.SCOPE_READ = SCOPE_READ;
//        this.SCOPE_WRITE = SCOPE_WRITE;
//        this.TRUST = TRUST;
//        this.ACCESS_TOKEN_VALIDITY_SECONDS = ACCESS_TOKEN_VALIDITY_SECONDS;
//        this.REFRESH_TOKEN_VALIDITY_SECONDS = REFRESH_TOKEN_VALIDITY_SECONDS;
//        this.JWT_SIGNING_KEY = JWT_SIGNING_KEY;
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Bean
//    public JwtAccessTokenConverter accessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey(JWT_SIGNING_KEY);
//        return converter;
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new JwtTokenStore(accessTokenConverter());
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
//
//        configurer
//                .inMemory()
//                .withClient(CLIENT_ID)
//                .secret(CLIENT_SECRET)
//                .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT )
//                .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
//                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS).
//                refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_SECONDS);
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.tokenStore(tokenStore())
//                .authenticationManager(authenticationManager)
//                .accessTokenConverter(accessTokenConverter());
//    }
//}