<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header_login.jsp" %>
<link rel="stylesheet" type="text/css" href="easyui15/themes/ui-pepper-grinder/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui15/themes/icon.css"> 	
<script type="text/javascript" src="easyui15/jquery.min.js"></script>
<script type="text/javascript" src="easyui15/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui15/jquery.edatagrid.js"></script>
 	
 	<title>人人乐彩票管理后台欢迎您</title>
 	<script type="text/javascript">
 	<%--	$(function(){
 			$('#westpanel').panel({
 				href:'back/manager/westpanel.html',
 			
 			});
 		})(); --%>
 		

 		$(function(){
 			var treeData=[{
 				"text":"公告管理",
 				"state":"closed",
 				"children":[{
 						"text":"新增公告",
 						"attributes":{
 							"url":"<iframe src='addNews.action' style='width:100%;height:100%;border:1px;'/>"
 						}
 					},{
 						"text":"公告维护",
 						"attributes":{
 							"url":"<iframe src='WEB-INF/pages/manaNews.jsp'style='width:100%;height:100%;border:0px;'/>"
 						}
 					}]
 			}];
 			
 			var treeDataLot=[{
 				"text":"彩票管理",
 				"state":"closed",
 				"children":[{
 						"text":"获奖情况统计",
 						"attributes":{
 							"url":"<iframe src='back/manager/news/konwLot.jsp' style='width:100%;height:100%;border:0px;' scrolling='yes'/>"
 						}
 					},{
 						"text":"金额流水",
 						"attributes":{
 							"url":"<iframe src='back/manager/news/konwMon.jsp'style='width:100%;height:100%;border:0px;'/>"
 						}
 					}]
 			}];
 			
 			/*
 			//相当于$(document).ready(function(){});
 			$("#newsTypeTree").tree({
 				data:treeData, 	   //将这里改成：url:" right.action" 这个地址会得到一个上面treeData 这样的字符串
 				onClick:function(node){
 					//alert(node.text);
 					if(node.attributes){
 						//alert(node.attributes.url);
 						openTab(node);
 					}
 				}
 			}); 
 			*/ 			
 			
 			showTree("newsTree",treeData);
 			showTree("LotTree",treeDataLot); 		 		
 		});
 		
 		
 		//显示树 
 		//参数一：要显示树的容器   ul 标签的id 号 ，data 树的节点内容 json格式
 		function showTree(treeId,data){
 			$("#"+treeId).tree({
 				data:data, 	   //将这里改成：url:" right.action" 这个地址会得到一个上面treeData 这样的字符串
 				onClick:function(node){
 					//alert(node.text);
 					if(node.attributes){
 						//alert(node.attributes.url);
 						openTab(node);
 					}
 				}
 			}); 	
 		}
 		
 		
 		function openTab(node){  //node 有text , url
 			if($("#mainTt").tabs("exists",node.text)){
 				$("#mianTt").tabs("select",node.text);
 			}else{
 				$("#mainTt").tabs("add",{
 					title:node.text,
 					selected:true,
 					closable:true,
 					//href:node.attributes.url
 					content:node.attributes.url
 				})
 			}
 		}
 	</script>
 	
 	 	
</head>
<body class="easyui-layout layout panel-noscroll">

	
	
	<div class="easyui-layout" style="width:100%; height:750px;">
			<div data-options="region:'north'" style="height:50px">
				<h1 style="text-align:center;line-height:40px;">人人乐彩票后台管理</h1>
			</div>
			
			<div data-options="region:'south',split:true"  style="height:50px;"></div>
			
			<div data-options="region:'east',split:true" title="East" style="width:100px;"></div>
			
			<div data-options="region:'west',split:true" title="West" style="width:150px;">
				
				
				
					
	<div class="easyui-accordion" style="width:500px;height:300px;">
	
				<div title="公告管理" style="overflow:auto; padding:10px;">
					<div class="easyui-panel" style="padding:5px">
						<ul id="newsTree" class="easyui-tree" data-options="animate:true,state:closed,fit:true">
									
						</ul> 
					</div>
					
				</div>
							
				<div title="彩票管理" style="overflow:auto; padding:10px; overflow:scroll;">
					<div class="easyui-panel" style="padding:5px">
						<ul id="LotTree" class="easyui-tree" data-options="animate:true,state:closed,fit:true">
									
						</ul> 
					</div>
				</div>
					
				
				<div title="数据字典" style="overflow:auto; padding:10px;">数据字典</div>
				
				<div title="系统备份还原"  style="overflow:auto; padding:10px;">系统备份还原</div>					
				
				<div title="权限管理"  style="overflow:auto; padding:10px;">权限管理</div>
		
			</div>
				
		</div>
		
			<div data-options="region:'center',title:'主操作区',iconCls:'icon-ok'">
			<!-- tabs区  有很多tab -->
				<div id="mainTt" class="easyui-tabs" data-options="fit:true,border:false">
					<div title="待处理业务区">欢迎您</div>
				</div>
			</div>
		
		
	</div>
</body>
</html>