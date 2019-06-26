/**
 * 
 */
$(document).ready(function() {
	InitMainTable();
	initUpdate();
	
})
var $table;
function InitMainTable () {
    var queryUrl = '/course/select';
	$table = $('#table').bootstrapTable({
        url: queryUrl,                      
        method: 'post',                      
        toolbar: '#toolbar',               
        striped: true,                     
        cache: false,                      
        pagination: true,                 
        sortable: true,                    
        sortOrder: "asc",                 
        singleSelect:"true",				
        sidePagination: "server",           
        pageNumber: 1,                      
        pageSize: 10,                    
        pageList: [10, 15, 20, 50,100],        
        search: false,                      
        strictSearch: true,
        showColumns: true,                  
        showRefresh: true,                 
        minimumCountColumns: 2,            
        clickToSelect: true,                  
        uniqueId: "id",                   
        showToggle: true,         
        queryParams : function (params) {
            var temp = {   
                pageModel:{
                	pageSize: params.limit,                         //页面大小
                    pageIndex: (params.offset / params.limit) + 1,   //页码
                    sort: params.sort,      //排序列名  
                    sortOrder: params.order //排位命令（desc，asc） 
                }
            	
            };
            return temp;
        },
        columns: [{
            field: 'cno',
            title: '课程编号',
            align: 'center',
            sortable: true
        }, {
            field: 'cname',
            title: '课程名称',
            align: 'center',
        }, {
            field: 'userId',
            title: '教师编号',
            align: 'center',
        }, {
            field: 'credit',
            title: '学       分',
            align: 'center',
        }, {
            field: 'period',
            title: '学       时',
            align: 'center',
        }, {
            field: 'num',
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
		'<button id="tableEditor" type="button" class="btn btn-info" data-toggle="modal" data-target="#updateModal">审核</button>'
	].join("");
}
var operateEvents={
		"click #tableEditor":function(e,value,row,index){
			$("#updateCno").val(row.cno);
			$("#updateCname").val(row.cname);
			$("#updateUserId").val(row.userId);
			$("#updateCredit").val(row.credit);
			$("#updatePeriod").val(row.period);
			$("#updateNum").val(row.num);
		}
}

function initUpdate(){
	$("#updateBtn").click(function(){
		$.ajax("/update/course",
		        {
		            dataType: "json",
		            type: "POST", //  请求方式 POST
		            crossDomain:true,  
		            contentType: "application/json",
		            data:JSON.stringify({
		            	"cno":$("#updateCno").val(),
		            }),
		            async: false,
		            success: function(data){
		            	alert("成功");
		            },
		            error: function(){
		                alert("错误");
		           }
		    })
	})
}
