$(function () {
    initTable();
});
var initTable = function () {
    $('#Table').dataTable({
        "processing": false,
        "serverSide": true,
        "bSort": false,
        "bFilter": false,
        "bLengthChange": false,
        "iDisplayLength": 10,
        "bRetrieve": true,
        "ajax": {
            "url": parent.pageContext+"/orgDetail/fee/getList",
            "data": function (d) {
                d.consNo = $('#paymentType').val();
                d.orgNo = $('#mchId').val();
                d.dateMin = $('#dateMin').val();
                d.dateMax = $('#dateMax').val();
            },
            "type": "get"
        }, "oLanguage": {
            "sZeroRecords": "无数据",
            "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
            "sInfoEmpty": "没有数据",
            "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "尾页"
            },
            "sZeroRecords": "<i class='layui-icon' style='font-size: 270px; color:#BDBDBD;'>&#xe600;</i><br><span>无数据</span>"
        },
        "columns": [
            {"data": "mchId"},
            {"data": "chargeTime"},
            {"data": "remark"},
            {"data": "applicant"},
            {"data": "paymentType"},

            {"data": "paymentAmount"},

        ],
        "fnDrawCallback": function (oSettings) {
            //获取后台方式 直接可以拿到json 之后进行处理
            var json = jQuery.parseJSON(oSettings.jqXHR.responseText);
            $("#pageTotal").html(json.recordsTotal);
        }
    });
}
function doSearch() {
    //$("#checkErrorTable").dataTable().fnDrawCallback();
    $("#Table").dataTable().fnClearTable(); //清空一下table
    $("#Table").dataTable().fnDestroy(); //还原初始化了的datatable
    initTable();
}
