drop table kbase_menu_mast;
create table kbase_menu_mast(
menu_id	varchar(10) comment '�˵����',
menu_desc	varchar(60) comment '�˵���ʾ',
parent_id	varchar(1) comment '���ڵ���',
menu_type	char(1) comment '�˵����� R-���ڵ� L-Ҷ�ڵ�',
menu_owner	char(1) comment '�˵�������-���Ա���Ա���Ͷ�Ӧ',
status	char(1) comment '�˵�״̬'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '�˵�����';

create table kbase_err_def(
  err_code	char(8) comment '�������',
  err_msg	varchar(32) comment '������Ϣ',
  err_lvl	char(1) comment '���󼶱� E-�쳣  D-һ����Ϣ'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '������Ϣ��';

create table kbase_user_ticket(
  ticket	char(32) NOT NULL PRIMARY KEY comment 'session��־',
  user_id	BIGINT comment '������Ϣ',
  last_log_time	TIMESTAMP (6)  comment '���Ǽ�ʱ��' --ʱ������Զ��Ǽǣ�����ҪĬ��ֵ�����ȹ���ʱ��ֻ����ʾ���⡣������ٴβ�ѯ����ʧ�ľ����Ի����
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '�û�-session���ձ�';


insert into kbase_err_def (err_code,err_msg,err_lvl) values ('DBER0001','δ�ҵ����������ļ�¼','E');
insert into kbase_err_def (err_code,err_msg,err_lvl) values ('COMM0001','δ�ҵ�ָ���û�','E');
insert into kbase_err_def (err_code,err_msg,err_lvl) values ('COMM0002','�û�����Ϊ��','E');


select * from kbase_menu_mast start with parent_id = '1' connect by prior parent_id = menu_id;

--��ѯ�˵�������
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
--��ѯ�˵��������     
select * from kbase_menu_mast
where FIND_IN_SET(menu_id,concat(getMenuTree(0,3)));