
!function($) {
    "use strict";

    var CalendarApp = function() {
        this.$body = $("body")
        this.$calendar = $('#calendar'),						//调用calendar的id
        this.$event = ('#calendar-events div.calendar-events'),
        this.$categoryForm = $('#add_new_event form'),
        this.$extEvents = $('#calendar-events'),
        this.$modal = $('#my_event'),							//前端的总事件对象 id为my_event
        this.$saveCategoryBtn = $('.save-category'),
        this.$calendarObj = null								//创建了一个表对象
    };


    /* on drop */											//拖动事件的时候触发  这个操作目前有点问题 分辨率不对劲会报错
    CalendarApp.prototype.onDrop = function (eventObj, date) { 
		console.log(eventObj);
        var $this = this;
            // retrieve the dropped element's stored Event Object  检索已删除元素的存储事件对象
            var originalEventObject = eventObj.data('eventObject');
            var $categoryClass = eventObj.attr('data-class');
            // we need to copy it, so that multiple events don't have a reference to the same object  然后复制这个对象
            var copiedEventObject = $.extend({}, originalEventObject);
            // assign it the date that was reported		改掉这个对象的时间
            copiedEventObject.start = date;
            if ($categoryClass)
                copiedEventObject['className'] = [$categoryClass];
            // render the event on the calendar
            $this.$calendar.fullCalendar('renderEvent', copiedEventObject, true);
            // is the "remove after drop" checkbox checked?
            if ($('#drop-remove').is(':checked')) {			//删除原来的事件
                // if so, remove the element from the "Draggable Events" list
                eventObj.remove();
            }
    },
    /* on click on event */												//当点击事件后触发
    CalendarApp.prototype.onEventClick =  function (calEvent, jsEvent, view) {
		console.log(calEvent)
        var $this = this;
            var form = $("<form></form>");
            form.append("<label>修改事件</label>");
            form.append("<div class='input-group'><input class='form-control' type=text value='" + calEvent.title + "' /><span class='input-group-append'><button type='submit' class='btn btn-success'><i class='fa fa-check'></i> 保存</button></span></div>");
            $this.$modal.modal({
                backdrop: 'static'
            });
			//点击删除时触发
            $this.$modal.find('.delete-event').show().end().find('.save-event').hide().end().find('.modal-body').empty().prepend(form).end().find('.delete-event').unbind('click').click(function () {
                $this.$calendarObj.fullCalendar('removeEvents', function (ev) {
					//console.log("删除了！");
                    return (ev._id == calEvent._id);
                });
                $this.$modal.modal('hide');
            });
			//点击保存时触发
            $this.$modal.find('form').on('submit', function () {
                calEvent.title = form.find("input[type=text]").val();
                $this.$calendarObj.fullCalendar('updateEvent', calEvent);//更新事件
                $this.$modal.modal('hide');
                return false;
            });
    },
    /* on select */													//创建事件时触发
    CalendarApp.prototype.onSelect = function (start, end, allDay) {
		console.log(start)
        var $this = this;
            $this.$modal.modal({
                backdrop: 'static'
            });
            var form = $("<form></form>");
            form.append("<div class='event-inputs'></div>");
            form.find(".event-inputs")
                .append("<div class='form-group'><label class='control-label'>时间名称</label><input class='form-control' placeholder='请输入事件' type='text' name='title'/></div>")
                .append("<div class='form-group mb-0'><label class='control-label'>事件程度:</label><select class='form-control' name='category'></select></div>")
                .find("select[name='category']")
                .append("<option value='bg-danger'>红色</option>")
                .append("<option value='bg-success'>绿色</option>")
                .append("<option value='bg-purple'>紫色</option>")
                .append("<option value='bg-primary'>浅色</option>")
                .append("<option value='bg-info'>蓝色</option>")
                .append("<option value='bg-warning'>黄色</option></div></div>");
            $this.$modal.find('.delete-event').hide().end().find('.save-event').show().end().find('.modal-body').empty().prepend(form).end().find('.save-event').unbind('click').click(function () {
                form.submit();
            });					//对提供提交表单的内容进行绑定，即提交表单的按钮在前端页面自定义
			//提交事件的时候所进行的操作
            $this.$modal.find('form').on('submit', function () {
                var title = form.find("input[name='title']").val();				//获取事件内容
                var beginning = form.find("input[name='beginning']").val();		//获取事件开始和结束时间
                var ending = form.find("input[name='ending']").val();
                var categoryClass = form.find("select[name='category'] option:checked").val();//获取事件颜色（紧急程度
                if (title !== null && title.length != 0) {
                    $this.$calendarObj.fullCalendar('renderEvent', {			//对表对象进行一个设定 包括上述获取到的内容 然后用renderEvent来发送事件到表里
                        title: title,											
                        start:start,
                        end: end,
                        allDay: false,
                        className: categoryClass
                    }, true);  
                    $this.$modal.modal('hide');
                }
                else{
                    alert('你必须添加事件的内容！');
                }
                return false;
                
            });
            $this.$calendarObj.fullCalendar('unselect');					//选择操作取消的时候触发，即当选择不创建事件的时候触发
    },
    CalendarApp.prototype.enableDrag = function() {
        //init events
        $(this.$event).each(function () {
            // it doesn't need to have a start or end
            var eventObject = {
                title: $.trim($(this).text()) // use the element's text as the event title
            };
            // store the Event Object in the DOM element so we can get to it later
            $(this).data('eventObject', eventObject);
            // make the event draggable using jQuery UI
            $(this).draggable({
                zIndex: 999,
                revert: true,      // will cause the event to go back to its
                revertDuration: 0  //  original position after the drag
            });
        });
    }
    /* Initializing */				//对事件表进行初始化
    CalendarApp.prototype.init = function() {
        this.enableDrag();
        /*  Initialize the calendar  */
        var date = new Date();			//获取年月日等等信息
        var d = date.getDate();
        var m = date.getMonth();
        var y = date.getFullYear();
        var form = '';
        var today = new Date($.now());//$.now() 函数用于返回当前时间距1970年1月1日午夜所经过的毫秒数。

        var defaultEvents =  [{			//事件对象数组
                title: 'Event Name 4',
                start: new Date($.now() + 148000000),
                className: 'bg-purple'
            },
            {
                title: 'Test Event 1',
                start: today,
                end: today,
                className: 'bg-success'
            },
            {
                title: 'Test Event 2',
                start: new Date($.now() + 168000000),
                className: 'bg-info'
            },
            {
                title: 'Test Event 3',
                start: new Date($.now() + 338000000),
                className: 'bg-primary'
            }];

        var $this = this;
        $this.$calendarObj = $this.$calendar.fullCalendar({
            slotDuration: '00:15:00', /* If we want to split day time each 15minutes */ //每天以15分钟的间隔分割
            minTime: '08:00:00',				//事件最短时间
            maxTime: '19:00:00',  				//事件最长时间
            defaultView: 'month',  
            handleWindowResize: true,   
             /*设置日历头部信息，如果设置为false，则不显示头部信息。
                                      * 包括left,center,right左中右三个位置都可以对应一下配置
                                      * title:显示当前月份/周、日信息
                                      * prev:用于切换到上一月/周/日视图的按钮
                                      * next:用于切换到下一月/周/日视图的按钮
                                      * prevYear：用于切换到上一年视图的按钮
                                      * nextYear：用于切换到下一年视图的按钮
									  * 只能调节表头的位置，并不能调节显示内容
                                      * */
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            events: defaultEvents,				//事件对象数组
            editable: true,
            droppable: true, // this allows things to be dropped onto the calendar !!!
            eventLimit: true, //数据条数太多时，限制各自里显示的数据条数（多余的以“+2more”格式显示），默认false不限制,支持输入数字设定固定的显示条数
            selectable: true,
			
			nowIndicator : true,            //周/日视图中显示今天当前时间点（以红线标记），默认false不显示
			monthNames : ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"], //月份自定义命名
			monthNamesShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"], //月份缩略命名（英语比较实用：全称January可设置缩略为Jan）
			dayNames: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],       //同理monthNames
			dayNamesShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],  //同理monthNamesShort
			
			
            drop: function(date) { $this.onDrop($(this), date); },	//拖动
            select: function (start, end, allDay) { $this.onSelect(start, end, allDay); },
            eventClick: function(calEvent, jsEvent, view) { $this.onEventClick(calEvent, jsEvent, view); }

        });

        //on new event
        this.$saveCategoryBtn.on('click', function(){
            var categoryName = $this.$categoryForm.find("input[name='category-name']").val();
            var categoryColor = $this.$categoryForm.find("select[name='category-color']").val();
            if (categoryName !== null && categoryName.length != 0) {
                $this.$extEvents.append('<div class="calendar-events" data-class="bg-' + categoryColor + '" style="position: relative;"><i class="fa fa-circle text-' + categoryColor + '"></i>' + categoryName + '</div>')
                $this.enableDrag();
            }

        });
    },

   //init CalendarApp
    $.CalendarApp = new CalendarApp, $.CalendarApp.Constructor = CalendarApp
    
}(window.jQuery),

//initializing CalendarApp
function($) {
    "use strict";
    $.CalendarApp.init()
}(window.jQuery);