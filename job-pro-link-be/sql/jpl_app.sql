# DROP DATABASE IF EXISTS `jpl_app`;
# CREATE DATABASE `jpl_app`;

USE `jpl_app`;


DROP TABLE IF EXISTS `m_kbn_catagories`;
CREATE TABLE `m_kbn_catagories`(
    `catagory_id` VARCHAR(20) NOT NULL,
    `code` VARCHAR(20) NOT NULL,
    `label` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `created_by` VARCHAR(20) NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_by` VARCHAR(20) NOT NULL,
    `updated_at` DATETIME NOT NULL,
    `lock_no` INT NOT NULL DEFAULT '0',
    PRIMARY KEY (`catagory_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



INSERT INTO `m_kbn_catagories` VALUES('ITAL0001', '性別区分', 'GENDER_KBN', '人材の性別を表す区分', '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_catagories` VALUES('ITAL0002', '学歴区分', 'EDUCATION_KBN', '人材の最終学歴を表す区分', '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_catagories` VALUES('ITAL0003', 'スキル区分', 'SKILL_KBN', '人材のスキルを表す区分', '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_catagories` VALUES('ITAL0004', '上達程度', 'SKILL_LEVEL_KBN', 'スキルや能力のレベルを表す区分', '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_catagories` VALUES('ITAL0005', '言語区分', 'LANGUAGE_KBN', '人材はどの言語が話せるを表す区分', '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_catagories` VALUES('ITAL0006', '国籍区分', 'COUNTRY_KBN', '人材の国籍を表す区分', '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_catagories` VALUES('ITAL0007', '企業規模の区分', 'COMPANY_SIZE_KBN', '企業の従業員数による区分', '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_catagories` VALUES('ITAL0008', '福利厚生の区分', 'BENEFIT_KBN', '企業の福利厚生を表す区分', '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_catagories` VALUES('ITAL0009', '職種', 'JOB_CATEGORY_KBN', '職業や仕事の種類を区別する', '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_catagories` VALUES('ITAL0010', '地域区分', 'CITY_KBN', '特定の地理的領域を表す区分', '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_catagories`VALUES('ITAL0011', '選考ステータス区分', 'Entry_Status_KBN', '選考のステータスを表す区分', '1',  NOW(), '1',  NOW(), 0);



DROP TABLE IF EXISTS `m_kbn_values`;
CREATE TABLE `m_kbn_values`(
    `value_id` VARCHAR(20) NOT NULL,
    `catagory_id` VARCHAR(20) NOT NULL,
    `code` VARCHAR(20) NOT NULL,
    `label` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `order` INT NOT NULL,
    `created_by` VARCHAR(20) NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_by` VARCHAR(20) NOT NULL,
    `updated_at` DATETIME NOT NULL,
    `lock_no` INT NOT NULL DEFAULT '0',
    PRIMARY KEY (`value_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



INSERT INTO `m_kbn_values` VALUES('1', 'ITAL0001', '男性', 'MALE', '性別が男性である', 1, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('2', 'ITAL0001', '女性', 'FEMALE', '性別が女性である', 2, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('3', 'ITAL0002', '高校卒', 'HIGH_SCHOOL', '高校卒業を持つ学歴', 1, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('4', 'ITAL0002', '専門学校卒', 'TECHNICAL SCHOOL', '専門学校卒業を持つ学歴', 2, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('5', 'ITAL0002', '学士', 'BACHELOR', '学士号を持つ学歴', 3, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('6', 'ITAL0002', '修士', 'MASTER', '修士号を持つ学歴', 4, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('7', 'ITAL0003', 'HTML・CSS', 'HTML・CSS', '', 1, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('8', 'ITAL0003', 'JavaScript', 'JavaScript', '', 2, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('9', 'ITAL0003', 'Java', 'Java', '', 3, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('10', 'ITAL0003', 'C++', 'C++', '', 4, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('11', 'ITAL0003', 'Python', 'Python', '', 5, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('12', 'ITAL0003', 'SQL', 'SQL', '', 6, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('13', 'ITAL0003', 'PHP', 'PHP', '', 7, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('14', 'ITAL0004', '一般', 'General', '一般的なスキルや能力のレベルを指す', 1, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('15', 'ITAL0004', '熟練', 'Skilled', '熟練的なスキルや能力のレベルを指す', 2, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('16', 'ITAL0004', '精通', 'Proficient', '精通的なスキルや能力のレベルを指す', 3, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('ja', 'ITAL0005', '日本語', 'Janpanese', '', 1, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('en', 'ITAL0005', '英語', 'English', '', 2, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('zh', 'ITAL0005', '中国語', 'Chinese', '', 3, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('fr', 'ITAL0005', 'フランス語', 'French', '', 4, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('ko', 'ITAL0005', '韓国語', 'Korean', '', 5, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('de', 'ITAL0005', 'ドイツ語', 'German', '', 6, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('ru', 'ITAL0005', 'ロシア語', 'Russian', '', 7, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('es', 'ITAL0005', 'スペイン語', 'Spanish', '', 8, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('th', 'ITAL0005', 'タイ語', 'Thai', '', 9, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('it', 'ITAL0005', 'イタリア語', 'Italian', '', 10, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('JPN', 'ITAL0006', '日本', 'Japan', '', 1, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('CHN', 'ITAL0006', '中国', 'China', '', 2, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('USA', 'ITAL0006', '米国', 'America', '', 3, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('CAN', 'ITAL0006', 'カナダ', 'Canada', '', 4, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('GBR', 'ITAL0006', 'イギリス', 'Britain', '', 5, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('BRA', 'ITAL0006', 'ブラジル', 'Brazil', '', 6, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('DEU', 'ITAL0006', 'ドイツ', 'Germany', '', 7, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('FRA', 'ITAL0006', 'フランス', 'France', '', 8, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('ESP', 'ITAL0006', 'スペイン', 'Spain', '', 9, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('AUS', 'ITAL0006', 'オーストラリア', 'Australia', '', 10, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('RUS', 'ITAL0006', 'ロシア', 'Russia', '', 11, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('KOR', 'ITAL0006', '韓国', 'Korea', '', 12, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('ITA', 'ITAL0006', 'イタリア', 'Italy', '', 13, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('S20', 'ITAL0007', '20人以下', '', '従業員数が20人以下', 1, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('S99', 'ITAL0007', '20人ー99人', '', '従業員数が20人以上と99人以下', 2, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('S299', 'ITAL0007', '100人ー299人', '', '従業員数が100人以上と299人以下', 3, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('S499', 'ITAL0007', '300人ー499人', '', '従業員数が300人以上と499人以下', 4, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('S999', 'ITAL0007', '500人ー999人', '', '従業員数が500人以上と999人以下', 5, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('S1000', 'ITAL0007', '1000人以上', '', '従業員数が1000人以上', 6, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('B001', 'ITAL0008', '健康保険', 'Health Insurance', '', 1, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('B002', 'ITAL0008', '労働保険', 'Labor Insurance', '', 2, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('B003', 'ITAL0008', '社保年金', 'Social Security', '', 3, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('B004', 'ITAL0008', '子育て支援', 'Childcare Support', '', 4, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('B005', 'ITAL0008', '住宅支援', 'Housing Support', '', 5, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('B006', 'ITAL0008', '交通费支给', 'Commuting Allowance', '', 6, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('B007', 'ITAL0008', '有奖金', 'Bonus', '', 7, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('J001', 'ITAL0009', 'プログラマー', 'Programmer', '', 1, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('J002', 'ITAL0009', 'サーバーエンジニア', 'Server Enginner', '', 2, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('J003', 'ITAL0009', 'ネットワークエンジニア', 'Network Enginner', '', 3, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('J004', 'ITAL0009', 'データベースエンジニア', 'Database Enginner', '', 4, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('J005', 'ITAL0009', 'セキュリティエンジニア', 'Security Enginner', '', 5, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('J006', 'ITAL0009', '販売員', 'Salesperson', '', 6, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('J007', 'ITAL0009', '会計士', 'Accountant', '', 7, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('C001', 'ITAL0010', '東京', 'Tokyo', '', 1, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('C002', 'ITAL0010', '横浜', 'Yokohama', '', 2, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('C003', 'ITAL0010', '大阪', 'Osaka', '', 3, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('C004', 'ITAL0010', '名古屋', 'Nagoya', '', 4, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('C005', 'ITAL0010', '札幌', 'Sapporo', '', 5, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('C006', 'ITAL0010', '神戸', 'Kobe', '', 6, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('C007', 'ITAL0010', '京都', 'Kyoto', '', 7, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('C008', 'ITAL0010', '福岡', 'Fukuoka', '', 8, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('C009', 'ITAL0010', '川崎', 'Kawasaki', '', 9, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('C010', 'ITAL0010', '埼玉', 'Saitama', '', 10, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('C011', 'ITAL0010', '広島', 'Hiroshima', '', 11, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('17', 'ITAL0011', '応募中', 'Applying', '求人への応募が行われている状態', 1, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('18', 'ITAL0011', '応募済み', 'Applied', '求人への応募が完了した状態', 2, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('19', 'ITAL0011', '書類選考中', 'Under Review', '提出された履歴書や応募資料を選考する段階', 3, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('20', 'ITAL0011', '選考通過', 'Shortlisted', '書類選考を通過し、次の選考段階に進むことが決まった状態', 4, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('21', 'ITAL0011', '選考不合格', 'Not Shortlisted', '書類選考で落選した状態', 5, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('22', 'ITAL0011', '面接予定', 'Scheduled for Interview', '面接が予定されている状態', 6, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('23', 'ITAL0011', '面接済み', 'Interviewed', '面接が完了した状態', 7, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('24', 'ITAL0011', '内定', 'Offer Extended', '選考プロセスを通じて内定が出された状態', 8, '1',  NOW(), '1',  NOW(), 0);
INSERT INTO `m_kbn_values` VALUES('25', 'ITAL0011', '不合格', 'Rejected', '最終的に不合格となった状態', 9, '1',  NOW(), '1',  NOW(), 0);


DROP TABLE IF EXISTS `m_users`;
CREATE TABLE `m_users`(
    `user_id` VARCHAR(20) NOT NULL,
    `icon` VARCHAR(255),
    `user_name` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `birthday` DATE NOT NULL,
    # 性別区分
    `gender_kbn` VARCHAR(20) NOT NULL,
    `mobile_phone` VARCHAR(20) NOT NULL,
    # 国籍区分
    `country_kbn` VARCHAR(20),
    `address` VARCHAR(255),
    # 学歴区分
    `education_kbn` VARCHAR(20),
    `specialty` VARCHAR(255),
    `school` VARCHAR(255),
    `admission_date` DATE,
    `graduation_date` DATE,
    `description` VARCHAR(1000),
    # [{course_name: 研修経歴名, attendance: 受講状況FLAG, start_date: 開始年月日, pass: 受講結果FLAG}, ]
    `courses` JSON,
    # [{project_name: 項目経歴名, start_date: 開始年月日, end_date: 終了年月日, description: 項目経歴説明, media: メディア}, ]
    `project_histories` JSON,
    # [{work_name: 職務経歴名, start_date: 開始年月日, end_date: 終了年月日, description: 職務経歴説明}, ]
    `work_histories` JSON,
    # [{language_name: 言語名, communication_level: 会話能力上達程度区分, reading_level: 読解力上達程度区分, language_certificates: [言語証書名, ]}, ]
    `languages` JSON,
    # [{skill_name: スキル, usage_month: 使用時間(月), skill_level: スキル上達程度区分, skill_certificates: [スキル証書名, ]}, ]
    `skills` JSON,
    `created_by` VARCHAR(20) NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_by` VARCHAR(20) NOT NULL,
    `updated_at` DATETIME NOT NULL,
    `lock_no` INT NOT NULL DEFAULT '0',
    `del_flg` varchar(1) NOT NULL DEFAULT '0',
    KEY `idx_user_name`(`user_name`) USING BTREE,
    PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


INSERT INTO `m_users` (`user_id`, `user_name`, `password`, `email`, `birthday`, `gender_kbn`,  `mobile_phone`, `created_by`, `created_at`, `updated_by`, `updated_at`)
VALUES('1', 'admin', '12345678', 'admin@qq.com', NOW(), '男性', '137xxxxxxxx', '1',  NOW(), '1',  NOW());

ALTER TABLE `m_kbn_catagories` ADD FOREIGN KEY (`created_by`) REFERENCES `m_users`(`user_id`);
ALTER TABLE `m_kbn_catagories` ADD FOREIGN KEY (`updated_by`) REFERENCES `m_users`(`user_id`);
ALTER TABLE `m_kbn_values` ADD FOREIGN KEY (`created_by`) REFERENCES `m_users`(`user_id`);
ALTER TABLE `m_kbn_values` ADD FOREIGN KEY (`updated_by`) REFERENCES `m_users`(`user_id`);


INSERT INTO `m_users` VALUES('2', NULL, 'guest', '12345678', 'guest@qq.com',  NOW(), '1', '137xxxxxxxx', 'CHN', '天津', '3', '日本語専門', 'bilibili大学',  NOW(),  NOW(), '自己PR', NULL, NULL, NULL, NULL, NULL, '1',  NOW(), '1',  NOW(), '0', 0);

UPDATE `m_users` SET  `courses` = JSON_ARRAY(
    JSON_OBJECT('course_name', 'Java入門', 'attendance', '受講', 'start_date', '2023-01-01', 'pass', '合格'),
    JSON_OBJECT('course_name', 'Javaプログラミング', 'attendance', '未受講', 'start_date', '2023-01-01', 'pass', '不合格')
) WHERE `user_id` = '2';

UPDATE `m_users` SET  `project_histories` = JSON_ARRAY(
    JSON_OBJECT('project_name', '求人サイトシステム開発', 'start_date', '2023-01-01', 'end_date', '2023-01-01', 'description', '項目経歴説明')
) WHERE `user_id` = '2';

UPDATE `m_users` SET  `work_histories` = JSON_ARRAY(
    JSON_OBJECT('work_name', 'Java初級エンジニア', 'start_date', '2023-01-01', 'end_date', '2023-01-01', 'description', '職務経歴説明')
) WHERE `user_id` = '2';

UPDATE `m_users` SET  `languages` = JSON_ARRAY(
    JSON_OBJECT('language_name', '日本語', 'communication_level', '精通', 'reading_level', '熟練', 'language_certificates', JSON_ARRAY('ビジネス日本語能力テスト（BJT）J1+', '日本語能力検定（JLPT）N1'))
) WHERE `user_id` = '2';

UPDATE `m_users` SET  `skills` = JSON_ARRAY(
    JSON_OBJECT('skill_name', 'JAVA', 'usage_month', '6', 'skill_level', '一般', 'skill_certificates', JSON_ARRAY())
) WHERE `user_id` = '2';



DROP TABLE IF EXISTS `m_companies`;
CREATE TABLE `m_companies`(
    `company_id` VARCHAR(20) NOT NULL,
    `icon` VARCHAR(255),
    `company_name` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `address` VARCHAR(255),
    `mobile_phone` VARCHAR(20),
    `director_name` VARCHAR(255),
    `establishment_date` DATE,
    # 企業規模の区分
    `employment_scorp_kbn` VARCHAR(20),
    `description` VARCHAR(1000),
    `ratify_flg` VARCHAR(1) NOT NULL DEFAULT '0',
    `created_by` VARCHAR(20) NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_by` VARCHAR(20) NOT NULL,
    `updated_at` DATETIME NOT NULL,
    `lock_no` INT NOT NULL DEFAULT '0',
    `del_flg` varchar(1) NOT NULL DEFAULT '0',
    KEY `idx_company_name`(`company_name`) USING BTREE,
    PRIMARY KEY (`company_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



INSERT INTO `m_companies` VALUES('1', NULL, 'xx会社', '12345678', 'company@qq.com', '天津', '137xxxxxxxx', '小野',  NOW(), 'S299', '企業紹介', '1', '1',  NOW(), '1',  NOW(), '0', 0);



DROP TABLE IF EXISTS `t_jobs`;
CREATE TABLE `t_jobs`(
    `job_id` VARCHAR(20) NOT NULL,
    `company_id` VARCHAR(20) NOT NULL,
    `job_name` VARCHAR(255) NOT NULL,
    `wage_min` VARCHAR(255),
    `wage_max` VARCHAR(255),
    # 職種区分
    `job_type_kbn` VARCHAR(20),
    # 地域区分
    `city_kbn` VARCHAR(20),
    `start_date` DATE,
    `end_date` DATE,
    # 経験時間要求区分
    `work_experience_kbn` VARCHAR(20),
    # 学歴区分
    `education_kbn` VARCHAR(20),
    `description` VARCHAR(1000),
    # [スキル, ]
    `skills` JSON,
    # [言語,]
    `languages` JSON,
    # [福利,]
    `benefits` JSON,
    `created_by` VARCHAR(20) NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_by` VARCHAR(20) NOT NULL,
    `updated_at` DATETIME NOT NULL,
    `lock_no` INT NOT NULL DEFAULT '0',
    `del_flg` varchar(1) NOT NULL DEFAULT '0',
    KEY `idx_job_name`(`job_name`) USING BTREE,
    PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



DROP TABLE IF EXISTS `t_application`;
CREATE TABLE `t_application`(
    `application_id` VARCHAR(20) NOT NULL,
    `user_id` VARCHAR(20) NOT NULL,
    `job_id` VARCHAR(20) NOT NULL,
    `application_date` DATE NOT NULL,
    `application_status_kbn` VARCHAR(20),
    `created_by` VARCHAR(20) NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_by` VARCHAR(20) NOT NULL,
    `updated_at` DATETIME NOT NULL,
    `lock_no` INT NOT NULL DEFAULT '0',
    `del_flg` varchar(1) NOT NULL DEFAULT '0',
    PRIMARY KEY (`application_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



DROP TABLE IF EXISTS `t_application_results`;
CREATE TABLE `t_application_results`(
    `result_id` VARCHAR(20) NOT NULL,
    `application_id` VARCHAR(20) NOT NULL,
    # 選考種類区分
    `selection_type_kbn` VARCHAR(20),
    # [{start_time: xxx, end_time: xxx}, ]
    `interview_optional_time` JSON,
    `interview_start_time` DATETIME,
    `interview_end_time` DATETIME,
    `result_flg` VARCHAR(1),
    `created_by` VARCHAR(20) NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_by` VARCHAR(20) NOT NULL,
    `updated_at` DATETIME NOT NULL,
    `lock_no` INT NOT NULL DEFAULT '0',
    `del_flg` varchar(1) NOT NULL DEFAULT '0',
    PRIMARY KEY (`result_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



DROP TABLE IF EXISTS `t_messages`;
CREATE TABLE `t_messages`(
    `message_id` VARCHAR(20) NOT NULL,
    `from_id ` VARCHAR(20) NOT NULL,
    `to_id` VARCHAR(20) NOT NULL,
    `title` VARCHAR(255) NOT NULL,
    `content` VARCHAR(1000),
    # [{start_time: xxx, end_time: xxx}, ]
    `interview_optional_time` JSON,
    `already_read_flg` VARCHAR(1) NOT NULL DEFAULT '0',
    `created_by` VARCHAR(20) NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_by` VARCHAR(20) NOT NULL,
    `updated_at` DATETIME NOT NULL,
    `lock_no` INT NOT NULL DEFAULT '0',
    `del_flg` varchar(1) NOT NULL DEFAULT '0',
    PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;