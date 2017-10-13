/*创建数据库*/
DROP DATABASE IF EXISTS studyplatform;
CREATE DATABASE IF NOT EXISTS studyplatform charset=utf8;
USE studyplatform;
/*创建用户表*/
CREATE TABLE user(
	# 用户id
	u_id INT PRIMARY KEY,
	# 用户名
	u_name VARCHAR(50),
	# 身份标识
	identify VARCHAR(50),
	# 手机号
	phone VARCHAR(20),
	# 邮箱
	email VARCHAR(50),
	# 加密后的密码
	pwd VARCHAR(100),
	# 激活状态
	status VARCHAR(10),
	# 性别
	gender VARCHAR(10),
	# 头像
	photo VARCHAR(10)
);
/*创建提交课程表*/
CREATE TABLE appointment(
	# 课程id
	c_id	INT PRIMARY KEY,
	# 课程名称
	c_name VARCHAR(100),
	# 教师的用户id
	u_id INT,
	c_type VARCHAR(50),
	integral INT,
	# 提交时间
	issuetime TIMESTAMP,
	# 课程开始日期
	start DATE,
	# 课程结束日期
	end DATE,
	# 开始时间
	begin TIME,
	# 结束时间
	terminal TIME,
	# 简介
	introduce TEXT,
	# 审核、申请、预约状态
	status VARCHAR(50)
);
insert into appointment(c_id,c_name,u_id,c_type,integral) values(1,'大数据','1','大数据',5);
/*创建课程预约表*/
CREATE TABLE curriculum(
	# 用户id
	u_id INT NOT NULL ,
	# 课程id
	c_id INT NOT NULL ,
	# 预约日期
	apdate DATE,
	# 预约时间
	aptime TIME
);
/*创建发布作业表*/
CREATE TABLE task(
	# 任务id
	t_id INT PRIMARY KEY ,
	# 任务名称
	t_name VARCHAR(50),
	# 教师id
	u_id INT NOT NULL ,
	# 任务内容
	t_content TEXT,
	# 上传时间
	t_update DATE,
	# 最晚提交日期
	t_submit DATE
);
/*创建提交作业表*/
CREATE TABLE assignment(
	# 作业id
	a_id INT PRIMARY KEY ,
	# 学员id
	u_id INT NOT NULL ,
	# 任务id
	t_id INT NOT NULL ,
	# 提交日期
	a_update DATE,
	# 作业内容
	a_content TEXT,
	# 作业的批阅状态
	a_status VARCHAR(20),
	# 作业的批阅内容
	a_remark TEXT
);
/*创建试题库*/
CREATE TABLE test(
  # 试题id
	q_id INT PRIMARY KEY ,
	# 试题的所属课程模块
	q_course TEXT NOT NULL ,
	# 问题内容
	question TEXT NOT NULL ,
	# 答案内容
	answer TEXT NOT NULL ,
	# 选项A
	ansA VARCHAR(100),
	# 选项B
	ansB VARCHAR(100),
	# 选项C
	ansC VARCHAR(100),
	# 选项D
	ansD VARCHAR(100)
);
/*创建成绩表*/
CREATE TABLE score(
	# 成绩的id
	s_id INT PRIMARY KEY ,
	# 用户id
	u_id INT NOT NULL ,
	# 测试时间
	s_uptime DATE,
	# 测试的课程模块
	s_course TEXT
);

/*============================================*/
/*每个人将自己要建的表写在下面，注明自己名字，写注释，如需修改之前的表，通知对方并在下方写自己的修改语句，写明注释*/

/*
屈佳 问答区的表
 */
/*创建问题表*/
CREATE TABLE question(
	# 问题的id
	q_id INT PRIMARY KEY ,
	# 用户id
	u_id INT NOT NULL ,
	# 发表时间
	q_uptime DATE NOT NULL ,
	# 问题的主题
	q_title VARCHAR(50) NOT NULL,
	# 详细信息
	q_detail TEXT NOT NULL,
	# 图片
	q_picture TEXT,
	# 悬赏积分
	q_score INT,
	# 回复问题id
	q_a_id
);
/*每个人将自己要建的数据库写在下面，注明自己名字，写注释，如需修改之前的表，通知对方并写明注释*/
/*黄伟*/
/*创建学习资源表*/
CREATE TABLE resource(
  # 资源id
  r_id INT PRIMARY KEY,
  # 资源名称
  r_name VARCHAR(50) NOT NULL ,
  # 资源链接
  r_URL VARCHAR(100) NOT NULL ,
  # 上传时间
  r_uptime DATE NOT NULL ,
  # 描述
  desp VARCHAR (100) NOT NULL ,
  # 资源类型
  r_type VARCHAR (10) NOT NULL ,
  # 时长
  duration TIME ,
  # 文件大小
  filesize VARCHAR (10) NOT NULL ,
  # 课程方向
  major VARCHAR (10) NOT NULL ,
  # 课程类型
  genre VARCHAR (50) NOT NULL
);
/*============================================*/
/*每个人将自己要建的表写在下面，注明自己名字，写注释，如需修改之前的表，通知对方并在下方写自己的修改语句，写明注释*/

/*
刘鹏   签到的表
 */
/*创建签到表*/
CREATE TABLE signintable(
  #用户id
  u_id VARCHAR (50) NOT NULL ,
  #星期一
  monday VARCHAR (50) DEFAULT '未签到',
  #星期二
  uesday VARCHAR (50) DEFAULT '未签到',
  #星期三
  wednesday VARCHAR (50) DEFAULT '未签到',
  #星期四
  thursday VARCHAR (50) DEFAULT '未签到',
  #星期五
  friday VARCHAR (50) DEFAULT '未签到',
  #星期六
  saturday VARCHAR (50) DEFAULT '未签到',
  #星期日
  sunday VARCHAR (50) '未签到'
);
/*============================================*/
/*每个人将自己要建的表写在下面，注明自己名字，写注释，如需修改之前的表，通知对方并在下方写自己的修改语句，写明注释*/
/*黄伟*/
/*创建收藏表*/
CREATE TABLE collection(
  # 资源id
  r_id VARCHAR (50) NOT NULL ,
  # 资源名称
  r_name VARCHAR (50) NOT NULL ,
  # 用户id
  u_id VARCHAR (50) NOT NULL ,
  # 收藏日期
  c_date DATE NOT NULL
);

/*每个人将自己要建的表写在下面，注明自己名字，写注释，如需修改之前的表，通知对方并在下方写自己的修改语句，写明注释*/
/*黄伟*/
/*创建点赞表*/
CREATE TABLE mylike(
  # 资源id
  r_id VARCHAR (50) NOT NULL ,
  # 用户id
  u_id VARCHAR (50) NOT NULL
);
/*宗凯*/
/*创建公告表*/
CREATE TABLE notice(
  # 公告id
  n_id INT PRIMARY KEY,
  # 公告标题
  n_title VARCHAR(100) NOT NULL ,
  # 公告内容
  n_content TEXT NOT NULL ,
  # 发布时间
  n_time TIMESTAMP NOT NULL ,
  # 发布者id
  n_a_id INT
);
/*宗凯*/
/*创建意见表*/
CREATE TABLE complaint(
  # 意见id
  cp_id INT PRIMARY KEY,
  # 意见内容
  cp_content TEXT NOT NULL ,
  # 提交时间
  cp_time TIMESTAMP NOT NULL ,
  # 提交者id
  cp_a_id INT,
  # 是否回复
  cp_status INT
);

/*黄伟*/
/*资源购买表*/
CREATE TABLE purchase(
  # 资源id
  r_id VARCHAR (50) NOT NULL ,
  # 用户id
  u_id VARCHAR (50) NOT NULL
);
/*每个人将自己要建的数据库写在下面，注明自己名字，写注释，如需修改之前的表，通知对方并写明注释*/
/*袁青英*/
/*创建积分表*/
CREATE TABLE coin(
  #用户id
  u_id VARCHAR (50) not NULL COMMENT '用户id',
  #用户积分
  u_coin VARCHAR (50) not NULL  DEFAULT '0' COMMENT '用户金币'
)COMMENT '积分表';
/**创建消费记录表*/
CREATE TABLE consumerrecord(
  id INT PRIMARY KEY auto_increment,
  #用户id
  u_id VARCHAR(50) not NULL comment'用户id',
  #时间
  datetime varchar(50),
  #支付收入类型
  payincometype varchar(2) comment '0支付，1充值',
  #金钱
  coin varchar(50),
  #原因
  cause varchar(50)

);
/*黄伟*/
/*资源下载表*/
CREATE TABLE download(
  # 资源id
  r_id VARCHAR (50) NOT NULL ,
  # 用户id
  u_id VARCHAR (50) NOT NULL
);
