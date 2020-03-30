function changeUse () {
/*	console.log(this);
    console.log($("#used").val())
    console.log($("#use").val())
    console.log($("#using").val())*/
  /*  $("#used").val($("#yesterday").val()-$("#using").val());*/

    $("#using").val($("#yesterday").val()-$("#used").val());
    var myDate = new Date();
console.log(myDate.getHours());
var hours = myDate.getHours();
    if (hours < 9) {
        $("#use").val($("#yesterday").val()-$("#using").val()*10);

    } else if (hours < 14) {
        // 9点5倍 10点 4倍 11点3.3倍 12点 2.5倍 13点 2倍
        $("#use").val($("#yesterday").val()-$("#using").val()*10/(hours-7));
    } else {
        $("#use").val($("#yesterday").val()-$("#using").val()*24/hours);
    }

}
layui.use('form', function () {
    var form = layui.form;
    form.on('radio', function (data) {
        $("#remaining").val($("#yesterday").val()-$("#avg").val()*data.value);
        $("#tian").val($("#yesterday").val()/$("#avg").val() /data.value);
    })
});