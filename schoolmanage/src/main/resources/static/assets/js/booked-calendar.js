/*
* jQuery-Calendar Plugin v1.1.0
*/
$(function () {
    $('#calendar').calendar({
        months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
        days: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
    });

});
function delect(res) {
    swal({
            title: "确定删除吗？",
            text: "你将无法恢复该会话信息！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定删除！",
            cancelButtonText: "取消删除！",
            closeOnConfirm: false,
            closeOnCancel: false
        },
        function (isConfirm) {
            if (isConfirm) {
                $.ajax({
                    type: "post",
                    url: "/talk/deletetalk",
                    dataType: "json",
                    data: {'id': res},
                }).done(function (res) {
                    if (res.code == 500) {
                        swal("删除失败", "服务器繁忙中...", "warning");
                    } else if (res.code == 200) {
                        swal("删除成功！", "即将返回谈话列表", "success");
                        setTimeout("window.location.href='psychology.html'", "1200");
                    }
                })
            } else {
                swal("取消！", "你的谈话信息是安全的XD:)",
                    "error");
            }
        });
}
function edit(res) {
    window.location.href='/edit-talk.html?id='+res;
}
(function ($) {

    $.fn.calendar = function (opts) {
        var first=true
        var nfirst=true
        var options = $.extend({
            color: '',
            months: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'Octomber', 'November', 'December'],
            days: ['Mo', 'Di', 'Mi', 'Do', 'Fr', 'Sa', 'So'],
            onSelect: function (res) {
                res.date = moment(res.date).format('Y-MM-DD');
                $.ajax({
                    type:"post",
                    data:{'date':res.date},
                    url: "talk/findbytime",
                }).done(function (re) {
                    var msg = "";
                    $.each(re, function (i, n) {
                        msg+="<div class=\"toggle ttm-style-befault box-shadow_1 ttm-toggle-title-bgcolor-white project_item "+n.types+"\" style='width: 100%'>";
                        msg+="<div class=\"toggle-title\"><a href=\"#\">"+(i+1)+".   "+n.teacher+"--"+n.time+ "与"+n.student+"的谈话"+"</a></div>";
                        msg+="<div class=\"toggle-content\" style='display: none' >";
                        msg+="<p>"+n.content+"</p>";
                        msg+="<div style=\"float: right\">";
                        msg+="<a title=\"修改\"   tabindex=\"0\" onclick='edit("+n.id+")'><i class=\"ti ti-pencil\"></i></a>";
                        msg+="<a  class=\"ttm_link\" tabindex=\"0\" onclick='delect("+n.id+")'><i class=\"ti ti-trash\"></i></a>";
                        msg+="</div>";
                        msg+="</div>";
                        msg+="</div>";
                    });
                    var url = document.location.toString();//获取url地址
                    var id=null;
                    if(url.indexOf("?")!=-1&&first)
                    {
                        var urlParmStr = url.slice(url.indexOf('?')+1);//获取问号后所有的字符串
                        var arr = urlParmStr.split('&');//通过&符号将字符串分割转成数组
                        id= arr[0].split("=")[1];//获取数组中第一个参数//
                        $.ajax({
                            type:"post",
                            data:{'id':id},
                            url: "talk/findbyid",
                        }).done(function (re) {
                            var mg = "";
                            mg+="<div class=\"toggle ttm-style-befault box-shadow_1 ttm-toggle-title-bgcolor-white project_item "+re.types+"\" style='width: 100%'>";
                            mg+="<div class=\"toggle-title\"><a href=\"#\">"+1+".   "+re.teacher+"--"+re.time+ "与"+re.student+"的谈话"+"</a></div>";
                            mg+="<div class=\"toggle-content\" style='display: none' >";
                            mg+="<p>"+re.content+"</p>";
                            mg+="<div style=\"float: right\">";
                            mg+="<a title=\"修改\"   tabindex=\"0\" onclick='edit("+re.id+")'><i class=\"ti ti-pencil\"></i></a>";
                            mg+="<a  class=\"ttm_link\" tabindex=\"0\" onclick='delect("+re.id+")'><i class=\"ti ti-trash\"></i></a>";
                            mg+="</div>";
                            mg+="</div>";
                            mg+="</div>";
                                if (re==null||re==""){
                                    $("#talks").html("暂无");
                                }else {
                                    $("#talks").html("");
                                    var i=$("#talks").isotope('insert',$(mg));
                                    if (first&&i.children().length==0){$("#talks").html(mg);}
                                    else first=false;
                                }
                                first=false
                        })
                    }else {
                        if (re==null||re==""){
                            $("#talks").html("暂无");
                        }else {
                            $("#talks").html("");
                            var i=$("#talks").isotope('insert',$(msg));
                            if (nfirst&&i.children().length==0){$("#talks").html(msg);}
                            else nfirst=false;
                        }
                    }
                })
            }
        }, $.fn.calendar.defaults, opts);
        
        return this.each(function () {
            var currentYear, currentMonth, currentDay, currentCalendar;
            
            initCalendar($(this), options);
        });
    };
    
    function initCalendar(wrapper, options) {
        var color = options.color; 
        
        wrapper.addClass('calendar').empty();
        
        var header = $('<header>').appendTo(wrapper);
        
        var buttonLeft = $('<span>').appendTo(header);
        buttonLeft.addClass('button').addClass('left');
        buttonLeft.html(' <i class="ti ti-arrow-left"> ');
        buttonLeft.bind('click', function () { currentCalendar = $(this).parents('.calendar'); selectMonth(false, options); });
        buttonLeft.bind('mouseover', function () { $(this).css('background', color); });
        buttonLeft.bind('mouseout', function () { $(this).css('background', color); });
        
        var headerLabel = $('<span>').appendTo(header);
        headerLabel.addClass('header-label')
        headerLabel.html(' Month Year ');
        headerLabel.bind('click', function () { 
            currentCalendar = $(this).parents('.calendar');
            selectMonth(null, options, new Date().getMonth(), new Date().getFullYear());
            
            currentDay = new Date().getDate();
            triggerSelectEvent(options.onSelect);
        });
        
        var buttonRight = $('<span>').appendTo(header);
        buttonRight.addClass('button').addClass('right');
        buttonRight.html(' <i class="ti ti-arrow-right"> ');
        buttonRight.bind('click', function () { currentCalendar = $(this).parents('.calendar'); selectMonth(true, options); });
        buttonRight.bind('mouseover', function () { $(this).css('background', (color)); });
        buttonRight.bind('mouseout', function () { $(this).css('background', color); });
        
        var dayNames = $('<table>').appendTo(wrapper);
        dayNames.append('<thead><th>' + options.days.join('</th><th>') + '</th></thead>');
       
        var calendarFrame = $('<div>').appendTo(wrapper);
        calendarFrame.addClass('calendar-frame');
        
        headerLabel.click();
    }
    
    function selectMonth(next, options, month, year) {
        var tmp = currentCalendar.find('.header-label').text().trim().split(' '), tmpYear = parseInt(tmp[1], 10);
        
        currentMonth = month || ((next) ? ((tmp[0] === options.months[options.months.length - 1]) ? 0 : options.months.indexOf(tmp[0]) + 1) : ((tmp[0] === options.months[0]) ? 11 : options.months.indexOf(tmp[0]) - 1));
        currentYear = year || ((next && currentMonth === 0) ? tmpYear + 1 : (!next && currentMonth === 11) ? tmpYear - 1 : tmpYear);
        
        var calendar = createCalendar(currentMonth, currentYear, options), frame = calendar.frame();
        
        currentCalendar.find('.calendar-frame').empty().append(frame);
        currentCalendar.find('.header-label').text(calendar.label);
        
        frame.on('click', 'td', function () {
            $('td').removeClass('selected');
            $(this).addClass('selected');
            
            currentDay = $(this).text();
            triggerSelectEvent(options.onSelect);
        });
    }   
    
    function createCalendar(month, year, options) {
        var currentDay = 1, daysLeft = true,
        startDay = new Date(year, month, currentDay).getDay() - 1,
        lastDays = [31, (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31], 
        calendar = [];
        
        var i = 0;
        while(daysLeft) {
            calendar[i] = [];
            
            for(var d = 0; d < 7; d++) {
                if(i == 0) {
                    if(d == startDay) {
                        calendar[i][d] = currentDay++;
                        startDay++;
                    }
                } else if(currentDay <= lastDays[month]) {
                    calendar[i][d] = currentDay++;
                } else {
                    calendar[i][d] = ''; 
                    daysLeft = false;
                }
                
                if (currentDay > lastDays[month]) { 
                    daysLeft = false; 
                } 
            }
            
            i++;
        }
        
        var frame = $('<table>').addClass('current');
        var frameBody = $('<tbody>').appendTo(frame);
        
        for(var j = 0; j < calendar.length; j++) {
            var frameRow = $('<tr>').appendTo(frameBody);
            
            $.each(calendar[j], function (index, item) {
                var frameItem = $('<td>').appendTo(frameRow);
                frameItem.text(item);
            });
        }
        
        $('td:empty', frame).addClass('disabled');
        if(currentMonth === new Date().getMonth()) { 
            $('td', frame).filter(function () { return $(this).text() === new Date().getDate().toString(); }).addClass('today'); 
        } 
    
        return { frame: function () { return frame.clone() }, label: options.months[month] + ' ' + year };
    }
    
    function triggerSelectEvent(event) {
        var date = new Date(currentYear, currentMonth, currentDay);
            
        var label = [];
        label[0] = (date.getDate() < 10) ? '0' + date.getDate() : date.getDate();
        label[1] = ((date.getMonth() + 1) < 10) ? '0' + (date.getMonth() + 1) : date.getMonth() + 1;
        label[2] = (date.getFullYear());

        if(event != undefined) {
            event({date: date, label: label.join('.')});
        }
    }
       
    function createAccent(color, percent) {
        var num = parseInt(color.slice(1),16), amt = Math.round(2.55 * percent), R = (num >> 16) + amt, G = (num >> 8 & 0x00FF) + amt, B = (num & 0x0000FF) + amt;
        return '#' + (0x1000000 + (R < 255 ? R < 1 ? 0 : R : 255) * 0x10000 + (G < 255 ? G < 1 ? 0 : G : 255) * 0x100 + (B < 255 ? B < 1 ? 0 : B : 255)).toString(16).slice(1);
    }

}(jQuery));