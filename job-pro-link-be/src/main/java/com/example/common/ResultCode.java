package com.example.common;

import lombok.Getter;
/**
 * @description  返されたコードやメッセージ
 * @author ziqi
 * @since 2023-12-13
 */
@Getter
public enum ResultCode implements StatusCode{
    SUCCESS("TAL200", "リクエスト成功"),
    LOGIN_FAILED("TAL201", "IDやパスワードが違っている。"),
    REGISTER_FAILED("TAL202", "登録に失敗しました。"),
    INVALID_TOKEN_ERROR("TAL203", "ログイン情報が無効です。再度ログインしてください。"),
    NAME_VALIDATE_ERROR("TAL204", "ユーザー名の検査に失敗しました。"),
    PASSWORD_VALIDATE_ERROR("TAL205", "パスワードの検査に失敗しました。"),
    VALIDATE_ERROR("TAL206", "パラメータの検査に失敗しました。");

    private String code;
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
