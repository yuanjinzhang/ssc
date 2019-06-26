/**
 * 
 */
$(document).ready(function() {
	InitMainTable();
	initUpdate();
	
})
var $table;
function InitMainTable () {
    var queryUrl = '/student/select/course';
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
        //height: 500,                      
        uniqueId: "id",                    
        showToggle: true, 
        queryParams : function (params) {
            var temp = {   
                pageModel:{
                	pageSize: params.limit,                        
                    pageIndex: (params.offset / params.limit) + 1,   //页码
                    sort: params.sort,     
                    sortOrder: params.order 
                }
            	
            };
            return temp;
        },
        columns: [ {
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
            title: '学生学号',
            align: 'center',
        }, {
            field: 'score',
            title: '成绩',
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
		'<button id="tableEditor" type="button" class="btn btn-info" data-toggle="modal" data-target="#updateModal">修改</button>',
	].join("");
}
var operateEvents={
		"click #tableEditor":function(e,value,row,index){
			$("#updateCno").val(row.cno);
			$("#updateCname").val(row.cname);
			$("#updateUserId").val(row.userId);
			$("#updateScore").val(row.score);
		},
		"click #tableDelete":function(e,value,row,index){
			
		}
}

function initUpdate(){
	$("#updateBtn").click(function(){
		$.ajax("/update/selectCourse",
		        {
		            dataType: "json", // 预期服务器返回的数据类型。
		            type: "POST", //  请求方式 POST
		            crossDomain:true,  
		            contentType: "application/json", 
		            // 发送到服务器的数据
		            data:JSON.stringify({
		            	"cno":$("#updateCno").val(),
		            	"cname":$("#updateCname").val(),
		            	"userId":$("#updateUserId").val(),
		            	"score":$("#updateScore").val()
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
