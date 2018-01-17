drop table kbase_menu_mast;
create table kbase_menu_mast(
menu_id	varchar(10) comment '菜单编号',
menu_desc	varchar(60) comment '菜单显示',
parent_id	varchar(1) comment '父节点编号',
menu_type	char(1) comment '菜单类型 R-根节点 L-叶节点',
menu_owner	char(1) comment '菜单所有者-与柜员表柜员类型对应',
status	char(1) comment '菜单状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '菜单主表';

create table kbase_err_def(
  err_code	char(8) comment '错误代码',
  err_msg	varchar(32) comment '错误信息',
  err_lvl	char(1) comment '错误级别 E-异常  D-一般信息'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '错误信息表';

create table kbase_user_ticket(
  ticket	char(32) NOT NULL PRIMARY KEY comment 'session标志',
  user_id	BIGINT comment '错误信息',
  last_log_time	TIMESTAMP (6)  comment '最后登记时间' --时间戳会自动登记，不需要默认值。精度过低时，只是显示问题。调大后，再次查询，丢失的精度仍会出现
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '用户-session对照表';


insert into kbase_err_def (err_code,err_msg,err_lvl) values ('DBER0001','未找到符合条件的记录','E');
insert into kbase_err_def (err_code,err_msg,err_lvl) values ('DBER0002','记录已存在','E');
insert into kbase_err_def (err_code,err_msg,err_lvl) values ('COMM0001','未找到指定用户','E');
insert into kbase_err_def (err_code,err_msg,err_lvl) values ('COMM0002','用户总线为空','E');



select * from kbase_menu_mast start with parent_id = '1' connect by prior parent_id = menu_id;

--查询菜单树方法
DROP FUNCTION IF EXISTS getMenuTree;
CREATE function getMenuTree(rootId INT,lvl int)
  RETURNS varchar(1000) CHARSET utf8
BEGIN 
	DECLARE sTemp VARCHAR(1000); 
	DECLARE sTempChd VARCHAR(1000); 
	
	SET sTemp = '$'; 
	SET sTempChd =cast(rootId as CHAR); 
	if lvl = 0
	then
		set lvl=5;
	end if;
	
	WHILE sTempChd is not null and lvl > -1 DO 
	 SET sTemp = concat(sTemp,',',sTempChd); 
	 SELECT group_concat(menu_id) INTO sTempChd FROM kbase_menu_mast where FIND_IN_SET(parent_id,sTempChd)>0; 
	 set lvl=lvl-1;
	END WHILE; 
	RETURN substr(sTemp,3);
END;
--查询菜单树的语句     
select * from kbase_menu_mast
where FIND_IN_SET(menu_id,concat(getMenuTree(0,3)));


create table kbase_knowledge_mast(
  k_id	varchar(10) NOT NULL PRIMARY KEY comment '主键',
  k_title	varchar(256) comment '标题',
  make_user	BIGINT(10) comment '创建用户',
  make_date	TIMESTAMP(6) comment '创建用户',
  last_mnt_user	BIGINT(10) comment '最后维护用户',
  last_mnt_date	TIMESTAMP(6) comment '最后维护日期',
  flg_mnt_status	char(1) comment '当前状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '知识库主表';

create table kbase_knowledge_detl(
  k_id	varchar(10) NOT NULL PRIMARY KEY comment '主键',
  k_text	BLOB comment '错误信息'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '知识库明细表';

create table kbase_knowledge_tag(
  k_id	varchar(10) comment '主键',
  k_tag	varchar(60) comment '错误信息'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '知识点标签';