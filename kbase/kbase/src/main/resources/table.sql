drop table kbase_menu_mast;
create table kbase_menu_mast(
menu_id	varchar(10) comment '菜单编号',
menu_desc	varchar(60) comment '菜单显示',
menu_type	char(1) comment '菜单类型 R-根节点 L-叶节点',
menu_owner	char(1) comment '菜单所有者-与柜员表柜员类型对应',
status	char(1) comment '菜单状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '菜单主表';

create table kbase_err_def(
  err_code	char(8) comment '错误代码',
  err_msg	varchar(32) comment '错误信息',
  err_lvl	char(1) comment '错误级别 E-异常  D-一般信息'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '错误信息表';