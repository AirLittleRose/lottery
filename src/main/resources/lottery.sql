create database lottery

use lottery

select * from users;
select * from league;
select * from team;
select * from info;

create table info(
	iid int primary key auto_increment,
    xid varchar(15) ,
    oddsmid varchar(15),
	oh varchar(5),
    od varchar(5),
    oa varchar(5),
    lid varchar(10),
    ln varchar(20),
    sid varchar(15),
	htid int,
    hn varchar(20),
    gtid int,
    gn varchar(20),
    mtime datetime,
    cl varchar(15),
    add_date datetime
)
drop table info;

--联赛
	--Id
	--联赛名
create table league(
	league_id int primary key,
	league_name varchar(50) not null,
    color varchar(15) not null
) 


--球队
	--id
	--联赛id
	--球队名
create table team(
	team_id int,
	league_id int,
	team_name varchar(50) not null 
)

alter table team  DROP FOREIGN KEY league_id
-- 比赛
	-- id
    -- 主胜
    -- 平
    -- 主败
    -- 联赛id
    -- 主队 id
    -- 客队id
    -- 比赛时间
create table game(
	game_id int primary key,
	oh varchar(5) ,
    od varchar(5),
    oa varchar(5),
    league_id varchar(10),
    home_id varchar(10),
    away_id varchar(10),
    game_time datetime
)

-- 通过info的信息插入新的League
insert into league(league_id,league_name,color)
		(select distinct(lid) as league_id ,ln as league_name,cl as color from info
		where lid not in (select league_id from league))
        
        
-- 通过info信息插入新的Team
insert into team(team_id, team_name, league_id)
select* from (
select distinct(htid) as team_id,hn as team_name, lid as league_id from info
where hn not in (select team_name from team)
union all
select distinct(gtid) as team_id, gn as team_name, lid as league_id from
info where gtid not in (select team_id from team)
and gtid not in(select htid from info) ) a where team_id not in (select
team_id from team)


-- 插入 (信息最新,且game表中不存在的) 比赛数据
insert into game(game_id, oh, od, oa, league_id, home_id, away_id, game_time)
select distinct(xid) as game_id, oh, od, oa, lid as league_id, htid as home_id, gtid as away_id, mtime as game_time from info where add_date = (select max(add_date) from info) and xid not in (select game_id from game)
------------------------------------------



--用户
	--用户id
	--用户名
	--密码
	--电话号码
	--邮箱
	--身份证
	--密钥
	--过期时间
	--备用字段
create table users(
	userid int primary key auto_increment,
    username varchar(50) not null ,
    password varchar(100) not null,
    tel varchar(15),
    email varchar(40),
    idcard varchar(20),
    validataCode varchar(100),
    outDate datetime,
    temp3 varchar(50)
);

select * from users;
delete from  users;
drop table users;


create table news(
	newid int primary key auto_increment,
	news varchar(200) not null,
	temp1 varchar(50),
	temp2 varchar(50)
);

drop table news;
select * from news;




insert into users(username,password,tel,email,idcard) values
	('adc','adc','15574749058','1092318651@qq.com','433711199804237672')
	
insert into users(username,password,tel,email,idcard) values
	('abc','abc','15574749058','1092318651@qq.com','433711199804237672')

--用户投注双色球
	--usid
	--userid
	--单号	orderid		20170406006293714  --》设想 ：date年4月2日2时2分2秒2毫秒4 + 5位随机数
	--投注时间
	--开奖状态		0 未开奖      1 已开奖
create table userSsq(
	usid int primary key auto_increment,
	userid int not null,
	orderid varchar(30) not null,
	ordertime datetime not null,	
	ssq_issue varchar(20) not null,
	
    status int,
    temp3 varchar(50)
)
alter table betSsq drop column status
select * from userSsq;
update userSsq set status = 0 where ssq_issue='2017100';
alter table userSsq alter column status set default 0;
select distinct ssq_issue from userSsq order by ssq_issue desc;
delete from userSsq;
delete from betSsq;

alter table userSsq change column temp2 status int;

insert into userSsq(userid,orderid,ordertime) values(2,now()+'23456', now() )
---------------------------------------------------

select usid,ssq.userid as userid,username, orderid,ordertime,ssq_issue,redball,blueball,sigprice,multinum 
from
(
select a.usid as usid,userid,orderid,ordertime,ssq_issue,redball,blueball,sigprice,multinum from
	(select usid,userid,orderid,ordertime,ssq_issue from userSsq) a
	inner join
	(select usid,redball,blueball,sigprice,multinum from betSsq) b
	on a.usid = b.usid
) ssq
inner join
(select userid,username from users) u
on ssq.userid = u.userid order by usid desc


select * from
	(select usid,userid,orderid,ordertime from userSsq) a
	inner join
	(select usid,ssq_issue,redball,blueball,sigprice,multinum from betSsq) b
	on a.usid = b.usid
	
--------------------------------------------------
insert into betSsq(usid,ssq_issue,sigprice,multinum,redball,blueball) values
	(3,'2017078',2,1,'130507021623','08');
insert into betSsq(usid,ssq_issue,sigprice,multinum,redball,blueball) values
	(3,'2017078',2,1,'130507021623','19')
--双色球投注信息		betSsq
	--bsid
	--usid		用户投注双色球id
	--期号	ssq_issue	2017xxx (每周二、四、日晚上21:15开奖)
	--单注价格		sigprice
	--注数		multinum
	--红球号码		redball
	--蓝球号码		blueball
create table betSsq(
	bsid int primary key auto_increment,
	usid int not null,
	sigprice int not null,
	multinum int not null,
	redball varchar(50) not null,
	blueball varchar(10) not null,
	
    temp2 varchar(50),
    temp3 varchar(50)
)
update betSsq set status = 0 ;
alter table betSsq alter column status set default 0;
alter table betSsq change column temp1 status int;
select * from betSsq;
drop table userSsq;
alter table betSsq modify column redball varchar(50) not null;
delete from userSsq where usid=22

	select a.usid as usid,userid,orderid,ordertime,ssq_issue,redball,blueball,sigprice,multinum from
		(select usid,userid,orderid,ordertime,ssq_issue from userSsq) a
		inner join
		(select usid,redball,blueball,sigprice,multinum from betSsq) b
		on a.usid = b.usid
		where ssq_issue='2017102'
-----------------------------------------------------------------------------
select ssq_issue,resulttime,redball,blueball from lotteryResult where ssq_issue='2017099';
--双色球开奖结果	lotteryResult
	--lrid
	--期号	ssq_issue
	--开奖日期时间
	--红球号码
	--蓝球号码
create table lotteryResult(
	lrid int primary key auto_increment,
	ssq_issue varchar(20) not null,
	resulttime varchar(30) not null,
	redball varchar(30) not null,
	blueball varchar(10) not null,
	temp1 varchar(50),
    temp2 varchar(50),
    temp3 varchar(50)
)

insert into lotteryResult(ssq_issue,resulttime,redball,blueball) values('2017102','2017-08-31','04 08 10 14 18 20','11')
delete from lotteryResult;
select * from lotteryResult;
alter table lotteryResult modify column resulttime varchar(30) not null;
alter table lotteryResult drop column validity
-----------------------------------
select distinct ai.usid as usid,userid,ssq_issue,orderid,ordertime,redball,blueball,
				multinum,status,grade,award
from
(select usid,redball,blueball,grade,award from awardInfo ) ai
inner join
(select a.usid as usid,userid,orderid,ordertime,ssq_issue,status,multinum
	from
	(select usid,userid,orderid,ordertime,ssq_issue,status from userSsq where status=1) a
	inner join 
	(select usid,multinum from betSsq) b
	on a.usid=b.usid
) ssq
on ssq.usid = ai.usid
where userid=2
order by ssq_issue desc,grade asc
-------------------------------------
--中奖信息		awardInfo
	--aid
	--userid
	--username
	--单号
	--中奖等级
	--中奖金额
	--（期号、红蓝球号码、注数、单注价格、收益倍率）
create table awardInfo(
	aid int primary key auto_increment,
	usid int not null,
	redball varchar(30) not null,
	blueball varchar(10) not null,
	grade int not null check(grade in(1,2,3,4,5,6) ),
	award double not null,
	temp1 varchar(50),
    temp2 varchar(50),
    temp3 varchar(50)
)

select distinct ai.usid as usid,userid,ssq_issue,orderid,ordertime,redball,blueball,
				multinum,status,grade,award,count(distinct(redball)) as awardInfocount
		from
		(select usid,redball,blueball,grade,award from awardInfo ) ai
		inner join
		(select a.usid as usid,userid,orderid,ordertime,ssq_issue,status,multinum
			from
			(select usid,userid,orderid,ordertime,ssq_issue,status from userSsq where status=1) a
			inner join 
			(select usid,multinum from betSsq) b
			on a.usid=b.usid
		) ssq
		on ssq.usid = ai.usid
		where userid=2


drop table awardInfo;
insert into awardInfo(userid,orderid,grade,award) values(11,'20170825110351812403',6,5.0);
insert into notAwardInfo(userid,orderid) values(11,'20170825110351812403');
select * from awardInfo;
delete from awardInfo where aid = 1;
select * from notAwardInfo;
--未中奖信息		
	--aid
	--userid
	--username
	--单号
create table notAwardInfo(
	aid int primary key auto_increment,
	usid int not null,
	redball varchar(30) not null,
	blueball varchar(10) not null,
	temp1 varchar(50),
    temp2 varchar(50),
    temp3 varchar(50)
)
delete from notAwardInfo
drop table notAwardInfo;


--彩票
	--彩票id  用来在数据库中唯一标识
	--彩票类型     1：双色球       2：足彩   (关联  双色球玩法表        足彩玩法表)
	--单注价格	 (默认每注两元)
	--彩票倍数    (对双色球而言，是注数    	对足彩而言，是买的倍数)
create table lotteryTickets(
	ltid int primary key auto_increment,
    lttype int not null,
    price int not null,
    multiple int not null,
	temp1 varchar(50),
    temp2 varchar(50),
    temp3 varchar(50)
)

--双色球投注
	--id
	--投注期号      2017xxx (每周二、四、日晚上21:15开奖)
	--彩票类型
	--投注时间      datetime  年月日  时分秒2
    --开奖时间		开奖时间   通过该字段判断是否开奖和购票截止时间    (如果已开奖，则关联中奖状态表 isWinState)
    --红球号码
    --蓝球号码
    --兑奖截止日期
create table ssq(
	ssqid int primary key auto_increment,
	lttype
	rednums varchar(60) not null,
    bluenums varchar(50) not null,
	temp1 varchar(50),
    temp2 varchar(50),
    temp3 varchar(50)
)



--用户投注信息记录
	--投注id
	--彩票id
	--投注单号	 20170406006293714  --》设想 ：date年4月2日2时2分2秒2毫秒4 + 5位随机数
	--备用字段
    
create table assumeInfo(
	aiid int primary key auto_increment,
    userid int,
    ltid int,
    orderid varchar(30) not null,
    ordertime datetime not null,
    endtime datetime not null,
    orderissue varchar(15) not null,
	lotterytime datetime not null,
	temp1 varchar(50),
    temp2 varchar(50),
    temp3 varchar(50),
    FOREIGN KEY (userid) REFERENCES users(userid),
    FOREIGN KEY (ltid) REFERENCES lotteryTickets(ltid)
)

create table ssq_iswin(
	ssqiwid
	ssqid
	iwsid	
)

--中奖状态表
	--中奖状态id
	--中奖状态	 0：未中奖       1：中奖  (如果已中奖，则关联中奖等级表  winGrade )
    
create table isWinState(
	iwsid int primary key auto_increment,
    iswin int not null check(iswin in (0,1)),
	temp1 varchar(50),
    temp2 varchar(50),
    temp3 varchar(50)
)


--中奖表
	--中奖id
	--中奖等级     0:足彩中奖    双色球-> 1:一等奖       2：二等奖      3：三等奖      4：四等奖      5：五等奖     6：六等奖
    --收益倍率    (对双色球而言，是收益倍数	对足彩而言，是赔率)
create table winGrade(
	winid int primary key auto_increment,
    grade int not null check(grade in(0,1,2,3,4,5,6)),
    odds double(10,2) not null,
	temp1 varchar(50),
    temp2 varchar(50),
    temp3 varchar(50)
)	

--双色球开奖结果
	--id
    --红球开奖结果
    --篮球开奖结果
    --开奖期号
create table ssqresult(
	srid int primary key auto_increment,
    rednums varchar(10) not null,
    bluenum varchar(1) not null,
    orderissue datetime not null,
	temp1 varchar(50),
    temp2 varchar(50),
    temp3 varchar(50)
)

