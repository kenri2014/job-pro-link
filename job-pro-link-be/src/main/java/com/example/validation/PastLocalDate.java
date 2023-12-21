package com.example.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * /**
 *  * @description  LocalDataタイプのデータをチェックするためのカスタムアノテーション
 *  * @author ziqi
 *  * @since 2023-12-13
 * */

@Documented
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Constraint(validatedBy = {PastLocalDateValidator.class})
@Retention(RUNTIME)
public @interface PastLocalDate {
    /**
     * エラーメッセージ
     */
    String message() default "今日と未来の日付は選択できない";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}

