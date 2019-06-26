/**
 * 
 */
$(document).ready(function() {
	InitMainTable();
	initInsert();
	initDelete();
	
})
var $table;
function InitMainTable () {
    var queryUrl = '/teacher/apply';//与controller类对应
	$table = $('#table').bootstrapTable({
        url: queryUrl,                     
        method: 'post',                      //Post方式
        toolbar: '#toolbar',                
        striped: true,                      
        cache: false,                      
        pagination: true,                   //分页
        sortable: true,                     //排序
        sortOrder: "asc",                   //排序方式
        singleSelect:"true",				
        sidePagination: "server",           
        pageNumber: 1,                     
        pageSize: 10,                      
        pageList: [10, 15, 20, 50,100],      
        search: false,                      
        strictSearch: true,
        showColumns: true,                  //显示所有列
        showRefresh: true,                  
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,               
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        showToggle: true, 
        queryParams : function (params) {
            var temp = {   
                pageModel:{
                	pageSize: params.limit,                         
                    pageIndex: (params.offset / params.limit) + 1,  
                    sort: params.sort,      //排序列名  
                    sortOrder: params.order //排位命令（desc，asc） 
                }
            	
            };
            return temp;
        },
        columns: [{
            field: 'applyno',
            title: '申请编号',
            align: 'center',
            sortable: true
        }, {
            field: 'applytime',
            title: '申请时间',
            align: 'center',
            //sortable: true
        }, {
            field: 'userId',
            title: '教师编号',
            align: 'center',
        }, {
            field: 'name',
            title: '教师名称',
            align: 'center',
        }, {
            field: 'cname',
            title: '课程名称',
            align: 'center',
        }, {
            field: 'crrdit',
            title: '学       分',
            align: 'center',
        }, {
            field: 'period',
            title: '学       时',
            align: 'center',
        }, {
            field: 'applynum',
            title: '人       数',
            align: 'center',
        }, {
            field:'ID',
            title: '操作',
            align: 'center',
            valign: 'middle',
            formatter: "actionFormatter",
            events:"operateEvents"
        }],
        onLoadSuccess: function () {
        	
        },
        onLoadError: function () {
            showTips("数据加载失败！");
        },
    });
    
};

function actionFormatter(value,row,index,field){
	return [
		'<button id="tableEditor" type="button" class="btn btn-info" data-toggle="modal" data-target="#insertModal">审核</button>',
		'<button id="tableDelete" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deleteModal">删除</button>'
		].join("");
}
var operateEvents={
		"click #tableEditor":function(e,value,row,index){
			$("#insertApplyno").val(row.applyno);
			$("#insertUserId").val(row.userId);
			$("#insertCname").val(row.cname);
			$("#insertCredit").val(row.credit);
			$("#insertPeriod").val(row.period);
			$("#insertApplynum").val(row.applynum);
		},
		"click #tableDelete":function(e,value,row,index){
			$("#deleteNo").val(row.applyno);
		}
}
//数据增加
function initInsert(){
	$("#insertBtn").click(function(){
		$.ajax("/course/insert",
		        {
		            dataType: "json", // 预期服务器返回的数据类型。
		            type: "POST", //  请求方式 POST
		            crossDomain:true,  // 跨域请求
		            contentType: "application/json", 
		            // 发送到服务器的数据
		            data:JSON.stringify({
		            	"cno"			:	$("#insertApplyno").val(),
		    			"userId"		:	$("#insertUserId").val(),
		    			"cname"			:	$("#insertCname").val(),
		    			"credit"		:	$("#insertCredit").val(),
		    			"period"		:	$("#insertPeriod").val(),
		    			"num"			:	$("#insertApplynum").val(),
		            }),
		          
		            async: false, // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
		            // 请求成功后的回调函数。
		            success: function(data){
		            	$("#resMsg").text(data.msg);
	               		$("#resInfoModal").modal('show');
		                if(data.status==200){
			            	$("#insertModal").modal('hide');
		                    $('#table').bootstrapTable('refresh');
		                }
		            },
		            error: function(){
		                alert("错误");
		           }
		    })
	})
}

function initDelete(){
	$("#deleteBtn").click(function(){
		$.ajax("/delete/apply",
		        {
		            dataType: "json", // 预期服务器返回的数据类型。
		            type: "POST", //  请求方式 POST或GET
		            crossDomain:true,  // 跨域请求
		            contentType: "application/json", //  发送信息至服务器时的内容编码类型
		            // 发送到服务器的数据
		            data:JSON.stringify({
		            	"applyno"		:	$("#deleteNo").val()
		            }),
		          
		            async: false, // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
		            // 请求成功后的回调函数。
		            success: function(data){
	               		$("#deleteModal").modal('hide');
		            	$("#resMsg").text(data.msg);
	               		$("#resInfoModal").modal('show');
		               	if(data.status==200){
		               		$('#table').bootstrapTable('refresh');
		               	}
		               	alert("成功");
		            },
		            error: function(){
		                alert("错误");
		           }
		    })
	})
}