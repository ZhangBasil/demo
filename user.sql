CREATE TABLE `t_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(50) NOT NULL COMMENT '用户姓名',
  `user_pwd` varchar(50) NOT NULL COMMENT '用户密码',
  `user_sex` varchar(2) DEFAULT NULL COMMENT '用户性别',
  `user_age` int(2) not NULL COMMENT '用户年龄',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除（0：否 1：是）',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户表';
