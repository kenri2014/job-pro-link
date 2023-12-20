package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
/**
 * @description  クロスドメインリクエストのコンフィグ
 * @author ziqi
 * @since 2023-12-13
 */
@Configuration
public class MyCorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        //1.CORSのコンフィグ情報の追加
        CorsConfiguration config = new CorsConfiguration();
        //1) フロントエンドサーバーを記入する
        config.addAllowedOrigin("http://localhost:5173");
        //2) Cookie情報を送信するかどうか
        config.setAllowCredentials(true);
        //3) 許可されるリクエスト・モダリティ
        config.addAllowedMethod("*");
        // 4）許可されるヘッダー
        config.addAllowedHeader("*");

        //2.すべてのリクエストをインターセプトする
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        //3.新しいCorsFilterを返す.
        return new CorsFilter(configSource);
    }
}

