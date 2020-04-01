layui.use('element', function () {
});


$(function () {
    if ($("#LAY_app").find(".layui-this").length == 0) {
        $(".layui-nav-itemed").first().addClass('layui-this');
    }

    $(".layui-nav-itemed").click(function () {
        $(this).slibings(li).addClass("layui-this");
    });
});