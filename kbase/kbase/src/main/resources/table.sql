drop table kbase_menu_mast;
create table kbase_menu_mast(
menu_id	varchar(10) comment '�˵����',
menu_desc	varchar(60) comment '�˵���ʾ',
menu_type	char(1) comment '�˵����� R-���ڵ� L-Ҷ�ڵ�',
menu_owner	char(1) comment '�˵�������-���Ա���Ա���Ͷ�Ӧ',
status	char(1) comment '�˵�״̬'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '�˵�����';

create table kbase_err_def(
  err_code	char(8) comment '�������',
  err_msg	varchar(32) comment '������Ϣ',
  err_lvl	char(1) comment '���󼶱� E-�쳣  D-һ����Ϣ'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '������Ϣ��';