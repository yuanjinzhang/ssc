/**
 * 
 */
$(document).ready(function() {
	initTable();
	initSearch();
})
var $table;
//初始化bootstrap-table的内容
function initTable () {
    //记录页面bootstrap-table全局变量$table，方便应用
    var queryUrl = '/search/course';
	//var rows= $("#table").bootstrapTable('getSelections');
	$table = $('#table').bootstrapTable({
        url: queryUrl,                      //请求后台的URL（*）
        method: 'post',                      //请求方式（*）
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        sortName:"id",
        sortOrder: "asc",                   //排序方式
        singleSelect:"true",				//只能选一行
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
        pageSize: 10,                      //每页的记录行数（*）
        pageList: [10, 15, 20, 50,100],        //可供选择的每页的行数（*）
        search: false,                      //是否显示表格搜索
        strictSearch: true,
        showColumns: true,                  //是否显示所有的列（选择显示的列）
        showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        //height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        showToggle: true,                   //是否显示详细视图和列表视图的切换按钮
        //cardView: false,                    //是否显示详细视图
        //detailView: false,                  //是否显示父子表
//        search:true,
//        searchAlign: 'left',
//        searchOnEnterKey:true,
        buttonsAlign:'left',				//buttons方向
        toolbarAlign:'right',				//自定义toolbar方向
        //得到查询的参数
        queryParams : function (params) {
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        	console.log(params)
            var temp = {   
        		param:{
        			cno:$("#searchCno").val()
        		},
                pageModel:{
                	limit: params.limit,                         //页面大小
                    page: (params.offset / params.limit) + 1,   //页码
                    offset:params.offset,
                    sort: params.sort,      //排序列名  
                    order: params.order //排位命令（desc，asc） 
                }
            	
            };
            return temp;
        },
        columns: [ {
            field: 'cno',
            title: '课程号',
        }, {
            field: 'cname',
            title: '课程名'
        }, {
            field: 'userId',
            title: '教师名',
        }, {
            field: 'credit',
            title: '学分',
        }, {
            field: 'period',
            title: '学时',
        }, {
            field: 'num',
            title: '额定人数'
        }, {
            field: 'place',
            title: '授课地点',
        }, {
            field: 'date',
            title: '开课时间'
        },],
        onLoadSuccess: function () {
        	
        },
        onLoadError: function () {
            showTips("数据加载失败！");
        },
    });
    
};
function initSearch(){
	$("#search").click(function(){
		$('#table').bootstrapTable('refresh');
	})
}