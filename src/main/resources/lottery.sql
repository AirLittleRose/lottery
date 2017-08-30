create database lottery

use lottery

select * from users;
select * from league;
select * from team;
select * from game;

--用户
	--用户id
	--用户名
	--密码
	--电话号码
	--邮箱
	--身份证
	--备用字段
create table users(
	userid int primary key auto_increment,
    username varchar(50) not null ,
    password varchar(16) not null,
    tel varchar(15),
    email varchar(40),
    idcard varchar(20),
    temp1 varchar(50),
    temp2 varchar(50),
    temp3 varchar(50)
)


--联赛
	--Id
	--联赛名
create table league(
	leagueid int primary key,
	leaguename varchar(50) not null,
	temp1 varchar(50),
    temp2 varchar(50),
    temp3 varchar(50)
) 


--球队
	--id
	--联赛id
	--球队名
create table team(
	teamid int primary key,
	leagueid int,
	teamname varchar(50) not null ,	
	temp1 varchar(50),
    temp2 varchar(50),
    temp3 varchar(50),
	foreign key (leagueid) references league(leagueid)
)


--比赛
	--id
	--赛季id
	--主场id
	--客场id
	--主场得分
	--客场得分
	--比赛状态
		--	未开始=0,比赛取消=3,比赛进行中=32,比赛 结束 =30
	--比赛日期
create table game(
	gameid varchar(20) primary key,
	seasonid int not null,
	leagueid int,
	homeid int not null,
	awayid int not null,
	homescore int,
	awayscore int,
	gamestatus int check (matchstatus in (0,3,30,32)),
	matchdate varchar(20) not null,
	temp1 varchar(50),
    temp2 varchar(50),
    temp3 varchar(50),
    foreign key (leagueid) references league(leagueid),
    foreign key (homeid) references team(teamid),
    foreign key (awayid) references team(teamid)
)
  --单注足彩投注信息
	--id
	--比赛id
    --预测结果
    	--0主胜, 1平, 2主败
    --开奖状态
    	--0 未开奖, 1已开奖
create table soccer(
	sid int primary key auto_increment,
    gameid char(20),
    predictresult int check(predictresult in (0,1,2)),
    status int check(status in (0,1)),
	temp1 varchar(50),
    temp2 varchar(50),
    temp3 varchar(50),
    foreign key (gameid) references game(gameid)
)


--用户投注足彩
	--投注id
	--单号
	--用户id
	--投注信息id
	--投注时间
create table user_soccer(
	usid int primary key auto_increment,
	orderid int not null unique,
	userid int ,
	sid int,
	ordertime datetime not null,
	temp1 varchar(50),
    temp2 varchar(50),
    temp3 varchar(50),
    foreign key (userid) references users(userid),
    foreign key (sid) references soccer(sid)
)










