package com.mall.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import javax.annotation.Resource;

@Configuration
@EnableAuthorizationServer
/***
 *配置认证服务器：
 *@author jokerBird
 *@Data create 2023-02-06 12:59
*/
public class authServer extends AuthorizationServerConfigurerAdapter {
    //配置令牌端点的安全配置：
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")             //允许申请
                .checkTokenAccess("permitAll()")           //允许检查
                .allowFormAuthenticationForClients();//表单认证(申请令牌)
    }
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    //配置客户端服务：
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()//使用inMemory存储
                .withClient("mall")
                .secret( passwordEncoder.encode("mall")) //客户端密钥
                .resourceIds("res_content_1","res_learing_1","res_pay_1")//资源列表
                .authorizedGrantTypes("authorization_code", "password","client_credentials","implicit","refresh_token")
                // 该client允许的授权类型authorization_code,password,refresh_token,implicit,client_credentials
                .scopes("all") //允许的授权范围
                .autoApprove(true)//不自动跳转到授权页面
                .redirectUris("www.mall.com");//授权后跳转到。

    }



    @Autowired
    AuthenticationManager authenticationManager;
    @Resource(name="AuthorizationServerTokenServicesCustom")
    private AuthorizationServerTokenServices authorizationServerTokenServices;
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)//认证管理器
                .tokenServices(authorizationServerTokenServices)//令牌管理服务
                .allowedTokenEndpointRequestMethods(HttpMethod.GET)
        ;//允许请求的方法。
    }
}
